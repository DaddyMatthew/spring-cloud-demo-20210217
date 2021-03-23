package com.example.mapper;

import com.example.dto.UserAddDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserMapper {

    void addUser(@Param("user") UserAddDto userDto);
}
