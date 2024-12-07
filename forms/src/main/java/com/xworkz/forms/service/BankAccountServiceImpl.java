package com.xworkz.forms.service;

import com.xworkz.forms.dto.BankAccountDTO;

public class BankAccountServiceImpl implements BankAccountService {

    BankAccountServiceImpl(){
        System.out.println("this is a BankAccountServiceImpl const...");
    }
    @Override
    public boolean validAndSave(BankAccountDTO bankAccountDTO) {
        return true;
    }
}
