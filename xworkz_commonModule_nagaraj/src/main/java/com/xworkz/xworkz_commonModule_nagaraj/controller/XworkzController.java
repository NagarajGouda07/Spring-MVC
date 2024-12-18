package com.xworkz.xworkz_commonModule_nagaraj.controller;

import com.xworkz.xworkz_commonModule_nagaraj.dto.SignupDTO;
import com.xworkz.xworkz_commonModule_nagaraj.service.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class XworkzController {
    @Autowired
    private SignupService service;

    public XworkzController() {
        System.out.println("No-Args Const of XworkzController");
    }

    @GetMapping("/signup")
    public String onSignup() {
        System.out.println("Displaying Signup Form");
        return "SignUp.jsp";
    }

    @PostMapping("/signup")
    public String onSignup(SignupDTO signupDTO) {
        System.out.println("Executing onSignup in Controller");
        boolean check=service.validateAndSave(signupDTO);
        if(check){
            System.out.println("Data is a saved");
            return "Signin.jsp";
        }else {
            System.out.println("Data Not saved");
        }
        return "SignUp.jsp";
    }

    @GetMapping("/signin")
    public String onSignin() {
        System.out.println("Displaying Signup Form");
        return "Signin.jsp";
    }

    @PostMapping("/signin")
    public String onSignin(SignupDTO dto) {
        return "Signin.jsp";
    }
}
