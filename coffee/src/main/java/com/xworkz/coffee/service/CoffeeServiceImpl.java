package com.xworkz.coffee.service;

import com.xworkz.coffee.dto.CoffeeDTO;
import com.xworkz.coffee.entity.CoffeeEntity;
import com.xworkz.coffee.repository.CoffeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class CoffeeServiceImpl implements CoffeeService{

    @Autowired
    private CoffeeRepository coffeeRepository;

    public CoffeeServiceImpl(){
        System.out.println("This is a CoffeeServiceImpl class ----");
    }

    @Override
    public boolean save(CoffeeDTO coffeeDTO) {
        CoffeeEntity coffeeEntity = new CoffeeEntity();

        BeanUtils.copyProperties(coffeeDTO, coffeeEntity);

        return coffeeRepository.saveRepo(coffeeEntity);
    }
}
