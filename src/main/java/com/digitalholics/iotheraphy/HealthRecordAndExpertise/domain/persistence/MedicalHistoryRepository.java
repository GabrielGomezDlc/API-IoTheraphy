package com.digitalholics.iotheraphy.HealthRecordAndExpertise.domain.persistence;

import com.digitalholics.iotheraphy.HealthRecordAndExpertise.domain.model.entity.MedicalHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicalHistoryRepository extends JpaRepository<MedicalHistory,Integer> {

    MedicalHistory findByPatientId(Integer patientId);
}
