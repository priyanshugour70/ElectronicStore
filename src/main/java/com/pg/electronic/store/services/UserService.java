package com.pg.electronic.store.services;

import com.pg.electronic.store.dtos.UserDto;

import java.util.List;

public interface UserService {


    // Create User
    UserDto createUser(UserDto userDto);

    // Update User
    UserDto updateUser(UserDto userDto, String userId);

    // Delete User
    void deleteUser(String userId);

    // Get All Users
    List<UserDto> getAllUser();

    // Get Single User by ID
    UserDto getUserById(String userId);

    // Get Single user by email
    UserDto getUserByEmail(String email);

    // Search Users
    List<UserDto> searchUser(String keyword);

    // other user specific features
}
