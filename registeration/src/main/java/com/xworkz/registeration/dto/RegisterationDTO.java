package com.xworkz.registeration.dto;

import lombok.Data;

@Data
public class RegisterationDTO {
    private int id;
    private String name;
    private int age;
    private String email;
    private String password;
    private String confirmPassword;
    private String phone_no;
}
