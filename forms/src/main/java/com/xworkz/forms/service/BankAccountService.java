package com.xworkz.forms.service;

import com.xworkz.forms.dto.BankAccountDTO;

public interface BankAccountService {
    boolean validAndSave(BankAccountDTO bankAccountDTO);

}
