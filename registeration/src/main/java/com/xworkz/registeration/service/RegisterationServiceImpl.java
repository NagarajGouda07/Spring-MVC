package com.xworkz.registeration.service;

import com.xworkz.registeration.dto.RegisterationDTO;
import com.xworkz.registeration.entity.RegisterationEntity;
import com.xworkz.registeration.repository.RegisterationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class RegisterationServiceImpl implements RegisterationService{

    @Autowired
    RegisterationRepo registerationRepo;

    @Override
    public boolean save(RegisterationDTO registerationDTO) {
        boolean valid =true;
        if (registerationDTO != null){

            String name = registerationDTO.getName();
            if (name.length() >=7 ){
                System.out.println("valid name");
                valid = true;
            }else {
                System.out.println("Invalid name");
                valid = false;
            }

            int age = registerationDTO.getAge();
            if (age >= 18){
                System.out.println("valid age");
                valid = true;
            }else {
                System.out.println("Invalid age");
                valid = false;
            }

            String email = registerationDTO.getEmail();
            if (email.contains("@") && email.endsWith("@gmail.com")) {
                System.out.println("Valid email");
                valid = true;
            } else {
                System.out.println("Invalid email");
                valid = false;
            }

            String password = registerationDTO.getPassword();
            if (password.length() >= 7) {
                System.out.println("Valid password");
                valid = true;
            } else {
                System.out.println("Invalid password");
                valid = false;
            }

            String confirmPassword = registerationDTO.getConfirmPassword();
            if (password.equals(confirmPassword)) {
                System.out.println("Passwords match");
                valid = true;
            } else {
                System.out.println("Passwords do not match");
                valid = false;
            }

            String phone_no = registerationDTO.getPhone_no();
            if (phone_no.startsWith("8") && phone_no.length() == 10) {
                System.out.println("Valid phone number");
                valid = true;
            } else {
                System.out.println("Invalid phone number");
                valid = false;
            }
        }

        if (valid) {
            RegisterationEntity registerationEntity = new RegisterationEntity();
            registerationEntity.setName(registerationDTO.getName());
            registerationEntity.setAge(registerationDTO.getAge());
            registerationEntity.setEmail(registerationDTO.getEmail());
            registerationEntity.setPassword(registerationDTO.getPassword());
            registerationEntity.setConfirmPassword(registerationDTO.getConfirmPassword());
            registerationEntity.setPhone_no(registerationDTO.getPhone_no());

            // Save to the database using repository
            return registerationRepo.save(registerationEntity);
        }

        return valid;
    }
}
