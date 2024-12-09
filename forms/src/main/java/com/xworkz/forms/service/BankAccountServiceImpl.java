package com.xworkz.forms.service;

import com.xworkz.forms.dto.BankAccountDTO;
import org.springframework.stereotype.Service;

@Service
public class BankAccountServiceImpl implements BankAccountService {


   public  BankAccountServiceImpl(){
        System.out.println("this is a BankAccountServiceImpl const...");
    }
    @Override
    public boolean validAndSave() {
        System.out.println("it is a BankAccountServiceImpl method created");

        return true;
    }
}
