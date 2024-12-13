package com.xworkz.registeration.configration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("com.xworkz.registeration")
@EnableWebMvc
public class RegisterationConfigration {

    RegisterationConfigration(){
        System.out.println("This is a RegisterationConfigration const");
    }
}
