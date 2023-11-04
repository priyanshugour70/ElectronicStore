package com.pg.electronic.store.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {



    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails normal = User.builder()
                .username("Priyanshu")
                .password(passwordEncoder().encode("password"))
                .roles("NORMAL")
                .build();

        UserDetails admin = User.builder()
                .username("Devanshu")
                .password(passwordEncoder().encode("password"))
                .roles("ADMIN")
                .build();

        // users create


        // InMemoryUserDetailManager...

        return new InMemoryUserDetailsManager(normal,admin);
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }




}
