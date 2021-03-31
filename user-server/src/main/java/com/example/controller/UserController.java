package com.example.controller;

import com.example.domain.RequestDto;
import com.example.domain.ResponseDto;
import com.example.dto.DscOperatorUser;
import com.example.dto.DscToken;
import com.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user/")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @PostMapping(value = "/insertUser")
    public ResponseDto insertUser(@RequestBody RequestDto<DscOperatorUser> requestDto) {
        iUserService.insertUser(requestDto.getBody());
        return ResponseDto.success();
    }

    @PostMapping(value = "/queryUserByToken")
    public ResponseDto<DscOperatorUser> queryUserByToken(@RequestBody RequestDto<DscToken> requestDto) {
        DscOperatorUser user = iUserService.queryUserByToken(requestDto.getBody());
        return ResponseDto.<DscOperatorUser>success().setBody(user);
    }

    @PostMapping(value = "/login")
    public ResponseDto<DscOperatorUser> login(@RequestBody RequestDto<DscOperatorUser> requestDto) {
        DscOperatorUser user = iUserService.login(requestDto.getBody());
        return ResponseDto.<DscOperatorUser>success().setBody(user);
    }

}
