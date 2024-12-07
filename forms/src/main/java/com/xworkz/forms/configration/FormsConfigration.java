package com.xworkz.forms.configration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("com.xworkz.forms")
@EnableWebMvc
public class FormsConfigration {
    public FormsConfigration(){
        System.out.println("This is a formsconfigration create a const..");
    }
}
