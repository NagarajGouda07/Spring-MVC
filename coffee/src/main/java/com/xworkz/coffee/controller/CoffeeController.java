package com.xworkz.coffee.controller;

import com.xworkz.coffee.dto.CoffeeDTO;
import com.xworkz.coffee.service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class CoffeeController {

    @Autowired
    private CoffeeService coffeeService;

    public CoffeeController(){
        System.out.println("this is a CoffeeController const..");
    }

    @PostMapping("/signup")
    public String signup(CoffeeDTO coffeeDTO){
        System.out.println("This is a signup Method........");
        System.out.println("CONTROLLER = "+ coffeeDTO);
        boolean saved = coffeeService.save(coffeeDTO);

        if (saved){
            System.out.println("Data is saved successfully");
            return "Success.jsp";
        }else {
            System.out.println("Data is Not saved successfully");
            return "Signup.jsp";
        }

    }

//    @PostMapping("/signin")
//    public String signin(){
//        System.out.println("This is a signin Method........");
//        return "index.jsp";
//    }
}
