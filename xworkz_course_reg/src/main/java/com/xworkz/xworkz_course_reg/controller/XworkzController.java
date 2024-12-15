package com.xworkz.xworkz_course_reg.controller;

import com.xworkz.xworkz_course_reg.dto.XworkzDTO;
import com.xworkz.xworkz_course_reg.service.XworkzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class XworkzController {

    @Autowired
    private XworkzService xworkzService;

    public XworkzController() {
        System.out.println("Created XworkzController");
    }

    @PostMapping("/xworkz")
    public String onSave(XworkzDTO xworkzDTO, Model model) {
        System.out.println("created onSave in CourseController");
        String validationMessage = xworkzService.validateAndSave(xworkzDTO);

        if ("Validation successful".equals(validationMessage)) {
            model.addAttribute("success", "Signup successful");
            return "success";  // Redirect to Success page
        } else {
            model.addAttribute("failure", validationMessage);
            model.addAttribute("fail", "Invalid Data");
            return "signup";  // Return to Signup page
        }
    }


    @PostMapping("/signin")
    public String onSignIn(String email, String password, Model model) {
        System.out.println("created onSignIn in CourseController");
        String validationMessage = xworkzService.verificationUser(email, password);

        if (validationMessage.equals("Authentication successful")) {
            String userName = xworkzService.getNameByEmail(email);
            model.addAttribute("userName", userName);
            return "signin";  // Redirect to Signin page with user name
        } else {
            model.addAttribute("error", "Given email and password do not match.");
            return "signin";  // Return to Signin page with error message
        }
    }

}



