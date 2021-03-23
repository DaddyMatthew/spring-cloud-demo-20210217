package com.example.dao;

import com.example.dto.UserAddDto;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl {

    @Autowired
    private UserMapper mapper;

    public void addUser(UserAddDto userDto) {
        mapper.addUser(userDto);
    }
}
