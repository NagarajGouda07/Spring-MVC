package com.xworkz.xworkz_module.controller;

import com.xworkz.xworkz_module.service.CommonModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class CommonModuleRestController {

    @Autowired
    private CommonModuleService commonModuleService;

    public CommonModuleRestController()
    {
        System.out.println("created CommonModuleRestController");
    }

    @GetMapping(value = "/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String onName(@PathVariable String name) {
        Long count = commonModuleService.getCountofName(name);
        if (count == 0) {
            return "";
        }
        return "Name Already exists";
    }

    @GetMapping(value = "/email/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String onEmail(@PathVariable String email, @RequestParam(required = false) String alterEmail) {
        Long count = commonModuleService.getCountofEmail(email);
        if (alterEmail != null && email.equals(alterEmail)) {
            return "Email and Alternate email should not be the same.";
        }
        if (count > 0) {
            return "Email Already exists";
        }
        return "";
    }

    @GetMapping(value = "/phone/{phone}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String onPhone(@PathVariable String phone, @RequestParam(required = false) String alterPhone) {
        Long count = commonModuleService.getCountofPhone(phone);
        if (alterPhone != null && phone.equals(alterPhone)) {
            return "Phone and Alternate phone should not be the same.";
        }
        if (count > 0) {
            return "Phone Already exists";
        }
        return "";
    }

    @GetMapping(value = "/alterEmail/{alterEmail}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String onAlterEmail(@PathVariable String alterEmail, @RequestParam(required = false) String email) {
        Long count = commonModuleService.getCountofAlterEmail(alterEmail);
        if (email != null && email.equals(alterEmail)) {
            return "Email and Alternate email should not be the same.";
        }
        if (count > 0) {
            return "Alter email Already exists";
        }
        return "";
    }

    @GetMapping(value = "/alterPhone/{alterPhone}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String onAlterPhone(@PathVariable String alterPhone, @RequestParam(required = false) String phone) {
        Long count = commonModuleService.getCountofAlterPhone(alterPhone);
        if (phone != null && phone.equals(alterPhone)) {
            return "Phone and Alternate phone should not be the same.";
        }
        if (count > 0) {
            return "Alter phone Already exists";
        }
        return "";
    }

}