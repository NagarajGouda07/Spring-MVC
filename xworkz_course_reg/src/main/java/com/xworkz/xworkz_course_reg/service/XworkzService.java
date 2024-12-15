package com.xworkz.xworkz_course_reg.service;

import com.xworkz.xworkz_course_reg.dto.XworkzDTO;

public interface XworkzService {
    public String validateAndSave(XworkzDTO xworkzDTO);

    String verificationUser(String email, String password);

    String getNameByEmail(String email);
}