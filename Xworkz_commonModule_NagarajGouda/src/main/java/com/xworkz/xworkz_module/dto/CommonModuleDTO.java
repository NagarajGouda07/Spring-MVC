package com.xworkz.xworkz_module.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class CommonModuleDTO {

    @NotEmpty(message = "Name can't be empty")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String name;

    @NotEmpty(message = "Email can't be empty")
    @Email(message = "Enter a valid email address")
    private String email;

    @NotEmpty(message = "PhoneNumber can't be empty")
    @Pattern(regexp = "^[0-9]{10}$", message = "PhoneNumber must be 10 digits")
    private String ph;

    @NotEmpty(message = "Alternate Email can't be empty")
    @Email(message = "Enter a valid alternate email address")
    private String alterEmail;

    @NotEmpty(message = "Alternate PhoneNumber can't be empty")
    @Pattern(regexp = "^[0-9]{10}$", message = "Alternate PhoneNumber must be 10 digits")
    private String alterPh;

    @NotEmpty(message = "Location can't be empty")
    @Size(min = 3, max = 100, message = "Location must be between 3 and 100 characters")
    private String location;
}


