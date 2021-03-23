package com.example.service.impl;

import com.example.common.dto.UserDto;
import com.example.dao.UserDaoImpl;
import com.example.dto.UserAddDto;
import com.example.service.IUserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDaoImpl dao;

    @Override
    public UserDto queryUserByToken(String token) {
        return null;
    }

    @Override
    public void addUser(UserAddDto userAddDto, UserDto userDto) {
        userAddDto.setPassword(DigestUtils.md5Hex(userAddDto.getPassword()));
        userAddDto.setCreatedBy(userDto.getUserId());
        dao.addUser(userAddDto);
    }
}
