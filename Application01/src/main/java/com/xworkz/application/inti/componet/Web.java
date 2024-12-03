package com.xworkz.application.inti.componet;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class Web {
    Web(){
        System.out.println("This is a componet class..");
    }

    @RequestMapping("/send")
    public String send(){
        System.out.println("This is running method");
        return "index.jsp";
    }
}
