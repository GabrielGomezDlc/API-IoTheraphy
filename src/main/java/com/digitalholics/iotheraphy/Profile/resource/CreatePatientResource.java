package com.digitalholics.iotheraphy.Profile.resource;

import com.digitalholics.iotheraphy.Security.User.User;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreatePatientResource {

    private Integer id;
    private Number age;
    private String photoUrl;
    private String birthdayDate;
    private Number appointmentQuantity;
    private User user;
}