package com.xworkz.forms.componet;

import com.xworkz.forms.dto.BankAccountDTO;
import com.xworkz.forms.dto.HospitalDTO;
import com.xworkz.forms.dto.PassportDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class Forms {
    public Forms(){
        System.out.println("this is a forms componet cons..");
    }

    @RequestMapping("/bank account")
    public String bankAccount(BankAccountDTO bankAccountDTO){
        System.out.println("this is a BankAccount = " + bankAccountDTO);
        return "BankAccount.jsp";
    }

    @RequestMapping("/hospital")
    public String hospital(HospitalDTO hospitalDTO){
        System.out.println("This is a Hospital = " + hospitalDTO);
        return "Hospital.jsp";
    }

    @RequestMapping("/passport")
    public String passport(PassportDTO passportDTO){
        System.out.println("This is a Passport = "+ passportDTO);
        return "Passport.jsp";
    }
}
