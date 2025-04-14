package com.jpacourse.dto;

import com.jpacourse.persistance.entity.DoctorEntity;
import com.jpacourse.persistance.entity.MedicalTreatmentEntity;
import com.jpacourse.persistance.entity.PatientEntity;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class VisitTO implements Serializable
{
    private Long id;
    private String description;
    private LocalDateTime time;
    private DoctorEntity doctor;
    private PatientEntity patient;
    private List<MedicalTreatmentEntity> medicalTreatments;






    public Long getId() {
        return id;
    }

    public void setId(Long id) {this.id = id;}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public void setDoctor(DoctorEntity doctor) {
        this.doctor = doctor;
    }

    public void setPatient(PatientEntity patient) {
        this.patient = patient;
    }
    public DoctorEntity getDoctor() {
        return doctor;
    }

    public PatientEntity getPatient() {
        return patient;
    }


}
