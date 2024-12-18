package com.xworkz.xworkz_commonModule_nagaraj.service;

import com.xworkz.xworkz_commonModule_nagaraj.dto.SignupDTO;
import com.xworkz.xworkz_commonModule_nagaraj.entity.SignupEntity;
import com.xworkz.xworkz_commonModule_nagaraj.repository.SignupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class SignupServiceImpl implements SignupService {

    @Autowired
    private SignupRepository repository;

    public SignupServiceImpl() {
        System.out.println("no-Args Const of SignupServiceImpl");
    }


    public char[] passwordRandomGenerator() {

        String numbers = "0987654321";
        String capitalLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String smallLetters = "zyxwvutsrqponmlkjihgfedcba";

        String code = capitalLetters + smallLetters + numbers;
        Random random = new Random();

        char[] generateCode = new char[8];

        for (int i = 0; i < 8; i++) {
            generateCode[i] = code.charAt(random.nextInt(code.length()));
        }
        return generateCode;
    }

    @Override
    public boolean validateAndSave(SignupDTO signupDTO) {
        System.out.println("Executing validateAndSave in SignupServiceImpl");
        boolean validation = false;
        if (signupDTO.getEmail() != null) {
            char[] password = passwordRandomGenerator();

            SignupEntity entity = new SignupEntity();

            entity.setUserName(signupDTO.getUserName());
            entity.setPhone(signupDTO.getPhone());
            entity.setEmail(signupDTO.getEmail());
            entity.setPassword(password);
            entity.setAlterEmail(signupDTO.getAlterEmail());
            entity.setAlterPhone(signupDTO.getAlterPhone());
            entity.setLocation(signupDTO.getLocation());
            validation = true;

            System.out.println("Generated Code :" + password);

            repository.send(entity);

        }

        return validation;
    }
}
