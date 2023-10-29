package com.pg.electronic.store.services.impl;

import com.pg.electronic.store.dtos.UserDto;
import com.pg.electronic.store.entities.User;
import com.pg.electronic.store.exceptions.ResourceNotFoundException;
import com.pg.electronic.store.repositories.UserRepository;
import com.pg.electronic.store.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper mapper;


    @Override
    public UserDto createUser(UserDto userDto) {

        // Generate Unique id in string format..!
        String userId = UUID.randomUUID().toString();
        userDto.setUserId(userId);

        // Dto To Entity
        User user = dtoToEntity(userDto);
        User savedUser = userRepository.save(user);

        // Entity To Dto
        UserDto newDto = entityToDto(savedUser);
        return newDto;
    }


    @Override
    public UserDto updateUser(UserDto userDto, String userId) {

        // Get Data using Id
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User Not Found with given Id !! "));


        // Set Data
        user.setName(userDto.getName());
//        user.setEmail(userDto.getEmail());
        user.setAbout(userDto.getAbout());
        user.setGender(userDto.getGender());
        user.setPassword(userDto.getPassword());
        user.setImageName(userDto.getImageName());

        // Save Data..
        User updatedUser = userRepository.save(user);
        UserDto updatedDto = entityToDto(updatedUser);
        return updatedDto;
    }


    @Override
    public void deleteUser(String userId) {

        // Get Data using Id
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User Not Found with given Id !! "));

        // Delete User
        userRepository.delete(user);
    }


    @Override
    public List<UserDto> getAllUser() {

        List<User> users = userRepository.findAll();
        List<UserDto> dtoList = users.stream().map(user -> entityToDto(user)).collect(Collectors.toList());

        return dtoList;
    }


    @Override
    public UserDto getUserById(String userId) {

        // Get Data using Id
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User Not Found with given Id !! "));

        UserDto userDto = entityToDto(user);
        return userDto;
    }

    @Override
    public UserDto getUserByEmail(String email) {

        User user = userRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("User Not Found with given Email id"));
        UserDto userDto = entityToDto(user);

        return userDto;
    }

    @Override
    public List<UserDto> searchUser(String keyword) {

        List<User> users = userRepository.findByNameContaining(keyword);
        List<UserDto> dtoList = users.stream().map(user -> entityToDto(user)).collect(Collectors.toList());

        return dtoList;
    }


    // Practice ...
    private UserDto entityToDto(User savedUser) {

//        UserDto userDto = UserDto.builder()
//                .userId(savedUser.getUserId())
//                .name(savedUser.getName())
//                .email(savedUser.getEmail())
//                .password(savedUser.getPassword())
//                .about(savedUser.getAbout())
//                .gender(savedUser.getGender())
//                .imageName(savedUser.getImageName())
//                .build();
//        return userDto;

        return mapper.map(savedUser, UserDto.class);
    }

    private User dtoToEntity(UserDto userDto) {
//        User user = User.builder()
//                .userId(userDto.getUserId())
//                .name(userDto.getName())
//                .email(userDto.getEmail())
//                .password(userDto.getPassword())
//                .about(userDto.getAbout())
//                .gender(userDto.getGender())
//                .imageName(userDto.getImageName())
//                .build();
//        return user;

        return mapper.map(userDto, User.class);
    }
}
