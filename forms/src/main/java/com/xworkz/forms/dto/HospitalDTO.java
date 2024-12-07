package com.xworkz.forms.dto;

import lombok.Data;

@Data
public class HospitalDTO {
    private String hospitalName;
    private String patientName;
    private String admissionDate;
    private String dischargeDate;
    private String treatmentDetails;
}
