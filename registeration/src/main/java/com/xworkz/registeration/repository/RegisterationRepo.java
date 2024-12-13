package com.xworkz.registeration.repository;

import com.xworkz.registeration.entity.RegisterationEntity;

public interface RegisterationRepo {
    boolean save(RegisterationEntity registerationEntity);
}
