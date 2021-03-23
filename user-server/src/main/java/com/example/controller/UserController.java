package com.example.controller;

import com.example.common.dto.RequestDto;
import com.example.common.dto.ResponseDto;
import com.example.common.dto.UserDto;
import com.example.dto.UserAddDto;
import com.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/user/")
public class UserController {

    @Autowired
    private IUserService service;

    @PostMapping(value = "/addUser")
    public ResponseDto<UserDto> addUser(@RequestBody RequestDto<UserAddDto> requestDto) {
        service.addUser(requestDto.getBody(), requestDto.getUser());
        return new ResponseDto<UserDto>().setCode("200");
    }

    @PostMapping(value = "/queryUser")
    public ResponseDto<UserDto> queryUser(@RequestBody RequestDto<String> requestDto) {
        UserDto userDto = service.queryUserByToken(requestDto.getBody());
        return new ResponseDto<UserDto>().setCode("200").setBody(userDto);
    }

}
