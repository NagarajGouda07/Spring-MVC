package com.xworkz.registeration.controller;

import com.xworkz.registeration.dto.RegisterationDTO;
import com.xworkz.registeration.service.RegisterationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class RegisterationController {

    @Autowired
    RegisterationService registerationService;

    RegisterationController(){
        System.out.println("This is RegisterationController const");
    }

    @PostMapping("/xworkz")
    public String save(RegisterationDTO registerationDTO){
        System.out.println("This is a RegisterationDTO ");
        System.out.println(registerationDTO);

        boolean saved = registerationService.save(registerationDTO);
        if (saved){
            System.out.println("RegisterationController is a data saved successfuly");
        }else {
            System.out.println("RegisterationController is  not saved ");
        }
        return "Success.jsp";
    }
}
