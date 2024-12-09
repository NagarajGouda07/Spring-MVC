package com.xworkz.forms.componet;

import com.xworkz.forms.dto.BankAccountDTO;
import com.xworkz.forms.dto.HospitalDTO;
import com.xworkz.forms.dto.PassportDTO;
import com.xworkz.forms.service.BankAccountService;
import com.xworkz.forms.service.HospitalService;
import com.xworkz.forms.service.PassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class Forms {
    @Autowired
    BankAccountService bankAccountService ;
    @Autowired
    HospitalService hospitalService;
    @Autowired
    PassportService passportService;

    public Forms(){
        System.out.println("this is a forms componet cons..");
    }

    @RequestMapping("/bankAccount")
    public String bankAccount(BankAccountDTO bankAccountDTO){
        System.out.println("this is a BankAccount = " +bankAccountDTO);
        if(bankAccountService.validAndSave()){
            System.out.println("true");
        }else {
            System.out.println("false");
        }
        return "BankAccount.jsp";
    }

    @RequestMapping("/hospital")
    public String hospital(HospitalDTO hospitalDTO){
        System.out.println("This is a Hospital = " + hospitalDTO);
        if(hospitalService.validAndSave()){
            System.out.println("true");
        }else {
            System.out.println("false");
        }

        return "Hospital.jsp";
    }

    @RequestMapping("/passport")
    public String passport(PassportDTO passportDTO){
        System.out.println("This is a Passport = "+ passportDTO);

        if(passportService.validAndSave()){
            System.out.println("true");
        }else {
            System.out.println("false");
        }
        return "Passport.jsp";
    }
}
