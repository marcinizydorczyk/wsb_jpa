package com.jpacourse.persistance.dao;

import com.jpacourse.persistance.entity.PatientEntity;

import java.time.LocalDateTime;

public interface PatientDao {
    void addVisitToPatient(Long patientId, Long doctorId, LocalDateTime time, String description);
    PatientEntity save(PatientEntity patient);
    PatientEntity findOne(Long id);

}