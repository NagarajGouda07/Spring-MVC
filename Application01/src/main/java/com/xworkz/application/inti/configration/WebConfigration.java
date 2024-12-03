package com.xworkz.application.inti.configration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("com.xworkz.application.inti")
@EnableWebMvc
public class WebConfigration {
    WebConfigration(){
        System.out.println("This is a configration class");
    }


}


