package com.xworkz.forms.dto;

import lombok.Data;

@Data
public class PassportDTO {
    private String fullName;
    private String dob;
    private String gender;
    private String nationality;
    private String address;
    private String passportType;
    private String applicationID;
    private String photoUpload;
    private String documentsUpload;
}
