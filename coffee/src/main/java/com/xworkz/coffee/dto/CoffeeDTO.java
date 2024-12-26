package com.xworkz.coffee.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CoffeeDTO {

    private String name;
    private String email;
    private String phoneNo;
    private String password;
    private String altEmail;
    private String location;

}
