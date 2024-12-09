package com.xworkz.forms.service;

import org.springframework.stereotype.Service;

@Service
public class PassportServiceImpl implements PassportService{
    PassportServiceImpl(){
        System.out.println("This a PassportServiceImpl const...");
    }

    @Override
    public boolean validAndSave() {
        System.out.println("This is a PassportServiceImpl method...");
        return true;
    }
}
