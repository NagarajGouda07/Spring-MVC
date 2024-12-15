package com.xworkz.xworkz_course_reg.service;

import com.xworkz.xworkz_course_reg.dto.XworkzDTO;
import com.xworkz.xworkz_course_reg.entity.XworkzEntity;
import com.xworkz.xworkz_course_reg.repository.XworkzRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class XworkzServiceImpl implements XworkzService {

    @Autowired
    private XworkzRepository xworkzRepository;

    public XworkzServiceImpl() {
        System.out.println("No-Args Constructor of XworkzServiceImpl");
    }

    @Override
    @Transactional
    public String validateAndSave(XworkzDTO xworkzDTO) {
        System.out.println("Executing validateAndSave in ServiceImpl");
        System.out.println("Service: " + xworkzDTO);

        String error = "Validation Success";

        if (xworkzDTO != null) {
            String name = xworkzDTO.getName();
            if (name.length() < 10 || !name.matches("^[a-zA-Z0-9]*$")) {
                error = "Invalid Name";
            } else {
                int age = xworkzDTO.getAge();
                if (age <= 18) {
                    error = "Invalid Age";
                } else {
                    String email = xworkzDTO.getEmail();
                    if (!email.contains("@") || !email.endsWith("gmail.com")) {
                        error = "Invalid Email";
                    } else {
                        String password = xworkzDTO.getPassword();
                        if (password.length() < 7 || !password.matches(".*[^a-zA-Z0-9].*")) {
                            error = "Invalid Password";
                        } else {
                            String cPassword = xworkzDTO.getCPassword();
                            if (!cPassword.equals(password)) {
                                error = "Invalid Confirm Password";
                            } else {
                                String ph = xworkzDTO.getPh();
                                if (!ph.startsWith("9") || ph.length() != 10) {
                                    error = "Invalid Contact Number";
                                } else {
                                    XworkzEntity xworkzEntity = new XworkzEntity();
                                    xworkzEntity.setName(xworkzDTO.getName());
                                    xworkzEntity.setEmail(xworkzDTO.getEmail());
                                    xworkzEntity.setAge(xworkzDTO.getAge());
                                    xworkzEntity.setPassword(xworkzDTO.getPassword());
                                    xworkzEntity.setCPassword(xworkzDTO.getCPassword());
                                    xworkzEntity.setPh(xworkzDTO.getPh());

                                    xworkzRepository.save(xworkzEntity);
                                    error = "Validation successful";
                                }
                            }
                        }
                    }
                }
            }
        }

        return error;
    }

    @Override
    @Transactional
    public String verificationUser(String email, String password) {
        System.out.println("Executing verificationUser in ServiceImpl");

        if (email == null || email.isEmpty() || password == null || password.isEmpty()) {
            System.out.println("Email or password is empty.");
            return "Verification failed";
        }

        XworkzEntity xworkzEntity = xworkzRepository.findByEmail(email);
        if (xworkzEntity == null) {
            System.out.println("No user found with email: " + email);
            return "Verification failed";
        }

        System.out.println("User found: " + xworkzEntity.getEmail());

        if (xworkzEntity.getPassword().equals(password)) {
            System.out.println("Password matches");
            return "Authentication successful";
        } else {
            System.out.println("Password does not match");
            return "Verification failed";
        }
    }

    @Override
    public String getNameByEmail(String email) {
        XworkzEntity xworkzEntity = xworkzRepository.findByEmail(email);

        if (xworkzEntity != null && xworkzEntity.getName() != null && !xworkzEntity.getName().isEmpty()) {
            return xworkzEntity.getName();
        } else {
            System.out.println("No user found with the given email.");
            return null;
        }
    }
}

