package com.xworkz.xworkz_module.service;

import com.xworkz.xworkz_module.dto.CommonModuleDTO;
import com.xworkz.xworkz_module.entity.CommonModuleEntity;

import javax.persistence.Entity;
import javax.validation.ConstraintViolation;
import java.util.Set;

public interface CommonModuleService {

    Set<ConstraintViolation<CommonModuleDTO>> validateAndSave(CommonModuleDTO commonModuleDTO);
    Long getCountofName(String name);
    Long getCountofEmail(String email);
    Long getCountofPhone(String phone);
    Long getCountofAlterEmail(String alterEmail);
    Long getCountofAlterPhone(String alterPhone);
    CommonModuleEntity onSignin(String email, String password);
    boolean onUpdate(String email, String newPassword, String confirmPassword);
    boolean saveEmail(String email);

}
