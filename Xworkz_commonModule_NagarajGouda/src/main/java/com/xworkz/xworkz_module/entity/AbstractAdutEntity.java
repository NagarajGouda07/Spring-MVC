package com.xworkz.xworkz_module.entity;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@Data
public class AbstractAdutEntity implements Serializable {
    private  String createdBy;
    private  String updatedBy;
    private LocalDateTime createdDate = LocalDateTime.now();
    private  LocalDateTime updatedDate = LocalDateTime.now();
}
