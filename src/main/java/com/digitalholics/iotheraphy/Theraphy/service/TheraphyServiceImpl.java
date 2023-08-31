package com.digitalholics.iotheraphy.Theraphy.service;

import com.digitalholics.iotheraphy.Shared.Exception.ResourceNotFoundException;
import com.digitalholics.iotheraphy.Shared.Exception.ResourceValidationException;
import com.digitalholics.iotheraphy.Theraphy.domain.model.entity.Theraphy;
import com.digitalholics.iotheraphy.Theraphy.domain.persistence.TheraphyRepository;
import com.digitalholics.iotheraphy.Theraphy.domain.service.TheraphyService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class TheraphyServiceImpl implements TheraphyService {


    private static final String ENTITY = "Theraphy";

    private final TheraphyRepository theraphyRepository;


    private final Validator validator;

    public TheraphyServiceImpl(TheraphyRepository theraphyRepository, Validator validator) {
        this.theraphyRepository = theraphyRepository;
        this.validator = validator;
    }



    @Override
    public List<Theraphy> getAll() {
        return theraphyRepository.findAll();
    }

    @Override
    public Page<Theraphy> getAll(Pageable pageable) {
        return theraphyRepository.findAll(pageable);
    }

    @Override
    public Theraphy getById(Integer theraphyId) {
        return theraphyRepository.findById(theraphyId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, theraphyId));
    }

    @Override
    public Theraphy create(Theraphy theraphy) {
       Set<ConstraintViolation<Theraphy>> violations = validator.validate(theraphy);

       if(!violations.isEmpty())
           throw new ResourceValidationException(ENTITY, violations);

       return theraphyRepository.save(theraphy);
    }

    @Override
    public Theraphy update(Integer theraphyId, Theraphy request) {
        Set<ConstraintViolation<Theraphy>> violations = validator.validate(request);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return theraphyRepository.findById(theraphyId).map(theraphy ->
                theraphyRepository.save(
                        theraphy.withTheraphyName(request.getTheraphyName())
                                .withAppointmentGap(request.getAppointmentGap())
                                .withStartAt(request.getStartAt())
                                .withFinishAt(request.getFinishAt())
                                .withAppointmentQuantity(request.getAppointmentQuantity())
                )).orElseThrow(()-> new ResourceNotFoundException(ENTITY, theraphyId));


    }

    @Override
    public ResponseEntity<?> delete(Integer theraphyId) {
        return theraphyRepository.findById(theraphyId)
                .map(theraphy -> {
                    theraphyRepository.delete(theraphy);
                    return ResponseEntity.ok().build();
                }).orElseThrow(()-> new ResourceNotFoundException(ENTITY, theraphyId));
    }
}