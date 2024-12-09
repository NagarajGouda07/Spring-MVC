package com.xworkz.forms.service;

import org.springframework.stereotype.Service;

@Service
public class HospitalServiceImpl implements HospitalService{

    public  HospitalServiceImpl(){
        System.out.println("this is a HospitalServiceImpl const...");
    }

    @Override
    public boolean validAndSave() {
        System.out.println("it is a HospitalServiceImpl method created");

        return true;
    }
}
