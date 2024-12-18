package com.xworkz.xworkz_commonModule_nagaraj.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "signup")
public class SignupEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String userName;

    private String email;

    private char[] password;

    private String phone;

    private String alterEmail;

    private String alterPhone;

    private String location;
}
