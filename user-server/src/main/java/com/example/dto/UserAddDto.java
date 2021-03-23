package com.example.dto;

import lombok.Data;

@Data
public class UserAddDto {
    private String id;
    private String userId;
    private String name;
    private String gender;
    private String password;

    private String createdBy;
}
