package com.example.service;

import com.example.common.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("USER-SERVER")
public interface IUserFeignService {

    @GetMapping(value = "/queryUserByToken")
    UserDto queryUserByToken(String token);
}
