package com.example.service;
import com.example.dto.DscOperatorUser;
import com.example.dto.DscToken;

public interface IUserService {

    void insertUser(DscOperatorUser dto);

    DscOperatorUser queryUserByToken(DscToken dto);

    DscOperatorUser login(DscOperatorUser dto);
}
