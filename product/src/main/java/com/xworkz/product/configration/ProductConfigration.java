package com.xworkz.product.configration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("com.xworkz.product")
@EnableWebMvc
public class ProductConfigration {

    public ProductConfigration(){
        System.out.println("This is a ProductConfigration const....");
    }

}
