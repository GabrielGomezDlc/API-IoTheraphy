package com.digitalholics.iotheraphy.Profile.resource;

import com.digitalholics.iotheraphy.Security.Domain.Model.Entity.User;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateTherapistResource
{
    private Integer id;
    private String specialization;
    private Number age;
    private String location;
    private String photoUrl;
    private String birthdayDate;
    private Double rating;
    private Number consultationQuantity;
    private Number patientQuantity;
    private Number yearsExperience;
    private Double fees;
    private User user;
}
