package com.xworkz.xworkz_commonModule_nagaraj.service;


import com.xworkz.xworkz_commonModule_nagaraj.dto.SignupDTO;

public interface SignupService {

    public boolean validateAndSave(SignupDTO signupDTO);
}
