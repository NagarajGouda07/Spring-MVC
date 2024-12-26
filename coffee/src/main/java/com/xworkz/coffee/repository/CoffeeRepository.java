package com.xworkz.coffee.repository;

import com.xworkz.coffee.entity.CoffeeEntity;

public interface CoffeeRepository {
    boolean saveRepo(CoffeeEntity coffeeEntity);
}
