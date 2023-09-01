package com.digitalholics.iotheraphy.Appointment.resource;

import com.digitalholics.iotheraphy.Theraphy.domain.model.entity.Theraphy;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UpdateAppointmentResource {


    private Integer id;

    @NotNull
    @NotBlank
    private Boolean done;

    @NotNull
    @NotBlank
    private String topic;
    private String diagnosis;

    @NotNull
    @NotBlank
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date date;

    @NotNull
    @NotBlank
    private Date hour;

    @NotNull
    @NotBlank
    private String place;


    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "theraphy_id", nullable = false)
    private Theraphy theraphy;
}
