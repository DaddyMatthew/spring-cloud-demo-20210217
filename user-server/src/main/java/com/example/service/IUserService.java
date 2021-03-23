package com.example.service;


import com.example.common.dto.UserDto;
import com.example.dto.UserAddDto;

public interface IUserService {

    void addUser(UserAddDto userAddDto, UserDto userDto);

    UserDto queryUserByToken(String token);
}
