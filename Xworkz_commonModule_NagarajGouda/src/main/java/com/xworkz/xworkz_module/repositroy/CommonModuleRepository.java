package com.xworkz.xworkz_module.repositroy;

import com.xworkz.xworkz_module.entity.CommonModuleEntity;

public interface CommonModuleRepository {

    boolean save(CommonModuleEntity commonModuleEntity);
    Long getCountOfName(String name);
    Long getCountOfEmail(String email);
    Long getCountOfPhone(String phone);
    Long getCountOfAlterEmail(String alterEmail);
    Long getCountOfAlterPhone(String alterPhone);

    CommonModuleEntity onSignin(String email);
    CommonModuleEntity getData(String email);
    boolean onUpdate(CommonModuleEntity commonModuleEntity);

    int getCount(String email);

    boolean updateCount(int i,String email);
}
