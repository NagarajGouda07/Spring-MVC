package com.xworkz.xworkz_course_reg.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "xworkztable")
@RequiredArgsConstructor
@NamedQuery(name = "getByEmail", query = "SELECT xe FROM XworkzEntity xe WHERE xe.email = :byemail")

public class XworkzEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "age")
    private int age;
    @Column(name = "password")
    private String password;
    @Column(name = "cPassword")
    private String cPassword;
    @Column(name = "ph")
    private String ph;

}
