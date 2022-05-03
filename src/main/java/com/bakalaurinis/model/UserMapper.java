package com.bakalaurinis.model;

import com.bakalaurinis.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collection;

public class UserMapper {

    public static UserDto toUserDto(User user){
        return UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .name(user.getName())
                .surname(user.getSurname())
                .phone(user.getPhone())
                .build();
    }

    public static UserDtoWithId toUserDtoWithId(User user){
        return UserDtoWithId.builder()
                .email(user.getEmail())
                .password(user.getPassword())
                .name(user.getName())
                .surname(user.getSurname())
                .phone(user.getPhone())
                .id(user.getId())
                .build();
    }

    public static User toUser(UserDto userDto){
        return User.builder()
                .id(userDto.getId())
                .email(userDto.getEmail())
                .name(userDto.getName())
                .surname(userDto.getSurname())
                .phone(userDto.getPhone())
                .build();
    }

    public static User toRegistrationUser(UserRegistrationDto userDto,Role role){
        Collection<Role> roles =new  ArrayList<>();
        roles.add(role);
        return User.builder()
                .email(userDto.getEmail())
                .name(userDto.getName())
                .surname(userDto.getSurname())
                .phone(userDto.getPhone())
                .password(userDto.getPassword())
                .roles(roles)
                .build();
    }
    public static User toLoginUser(UserLoginDto userDto){

        return User.builder()
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .build();
    }

}
