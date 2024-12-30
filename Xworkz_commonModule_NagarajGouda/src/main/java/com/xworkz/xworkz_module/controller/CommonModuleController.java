package com.xworkz.xworkz_module.controller;

import com.xworkz.xworkz_module.dto.CommonModuleDTO;
import com.xworkz.xworkz_module.entity.CommonModuleEntity;
import com.xworkz.xworkz_module.service.CommonModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.ConstraintViolation;
import java.util.Set;

@Controller
@RequestMapping("/")
public class CommonModuleController {

    @Autowired
    CommonModuleService commonModuleService;

    public CommonModuleController() {
        System.out.println("Created CommonModuleController");
    }

    @GetMapping("/signup")
    public String onSignup() {
        return "Signup.jsp";
    }


    @PostMapping("/signup")
    public String onSave(CommonModuleDTO commonModuleDTO, Model model) {

        System.out.println("Excutng the save method");

        Set<ConstraintViolation<CommonModuleDTO>> constraintViolations = commonModuleService.validateAndSave(commonModuleDTO);

        System.out.println(constraintViolations);

        if ( constraintViolations == null ||constraintViolations.isEmpty()) {

            System.out.println("Data saved");

            model.addAttribute("message", "data is saved");

            return "Success.jsp";

        } else {

            model.addAttribute("error", constraintViolations);

            System.out.println("Data Not Entred");

            return "Signup.jsp";

        }
    }

    @GetMapping("/signin")
    public String onSignin() {
        return "Signin.jsp";
    }

    @PostMapping("/signin")
    public String onSignin(@RequestParam String email, @RequestParam String password, Model model) {
        System.out.println("onSignin in CommonModuleController");
        CommonModuleEntity result = commonModuleService.onSignin(email, password);
        if (result != null) {
            return "Signin.jsp";
        }
        if (result.getSigninCount() == 0){
            return "Success.jsp";
        }
        if (result.getSigninCount() == -1){
            return "Passwordupdate.jsp";
        }
        if (result.getSigninCount() > 3){
            model.addAttribute( "errorMessage", "Account Locked & try Later");
            return "Signin.jsp";
        }
        return "Signin.jsp";
    }

    @PostMapping("/updatePassword")
    public String onUpdatePassword(@RequestParam String email, @RequestParam String newPassword, @RequestParam String confirmPassword) {
        System.out.println("onUpdatePassword in CommonModuleController");
        if (commonModuleService.onUpdate(email, newPassword, confirmPassword)) {
            return "Success.jsp";
        }
        return "PasswordUpdate.jsp";
    }


}
