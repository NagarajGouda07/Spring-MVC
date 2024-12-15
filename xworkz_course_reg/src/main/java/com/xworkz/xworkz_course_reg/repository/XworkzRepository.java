package com.xworkz.xworkz_course_reg.repository;

import com.xworkz.xworkz_course_reg.entity.XworkzEntity;

public interface XworkzRepository {

    boolean save(XworkzEntity xworkzEntity);
    XworkzEntity findByEmail(String email);

    }
