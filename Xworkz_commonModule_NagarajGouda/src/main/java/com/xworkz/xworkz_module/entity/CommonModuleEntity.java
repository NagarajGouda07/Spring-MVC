package com.xworkz.xworkz_module.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "common_module_table")
@NamedQuery(name = "getCountOfName", query = "SELECT COUNT(cme) FROM CommonModuleEntity cme WHERE cme.name = :setName")
@NamedQuery(name = "getCountOfEmail", query = "SELECT COUNT(cme) FROM CommonModuleEntity cme WHERE cme.email = :setEmail")
@NamedQuery(name = "getCountOfPhone", query = "SELECT COUNT(cme) FROM CommonModuleEntity cme WHERE cme.ph = :setPh")
@NamedQuery(name = "getCountOfAlterEmail", query = "SELECT COUNT(cme) FROM CommonModuleEntity cme WHERE cme.alterEmail = :setAlterEmail")
@NamedQuery(name = "getCountOfAlterPhone", query = "SELECT COUNT(cme) FROM CommonModuleEntity cme WHERE cme.alterPh = :setAlterPhone")
@NamedQuery(name = "getValue", query = "SELECT cme FROM CommonModuleEntity cme WHERE cme.email = :email")
@NamedQuery(name = "updateCount", query = "UPDATE  CommonModuleEntity a SET a.signinCount=:setNo WHERE a.email = :setEmail")
@NamedQuery(name = "getCountValue", query = "SELECT cme.signinCount FROM CommonModuleEntity cme WHERE cme.email = :email")

public class CommonModuleEntity extends AbstractAdutEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "ph")
    private String ph;

    @Column(name = "alter_email")
    private String alterEmail;

    @Column(name = "alter_ph")
    private String alterPh;

    @Column(name = "location")
    private String location;

    @Column(name = "signin_count")
    private int signinCount;
}