package com.digitalholics.iotheraphy.Profile.resource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdatePatientResource {
    private String dni;
    private Integer age;
    private String photoUrl;
    private String birthdayDate;
    private Integer appointmentQuantity;
    private String location;
}