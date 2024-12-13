package com.xworkz.registeration.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "registeration")
@RequiredArgsConstructor
public class RegisterationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "confirmPassword")
    private String confirmPassword;
    @Column(name = "phone_no")
    private String phone_no;

}
