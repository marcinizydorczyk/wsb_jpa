package com.jpacourse.persistance.dao.impl;

import com.jpacourse.persistance.dao.PatientDao;
import com.jpacourse.persistance.entity.DoctorEntity;
import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.entity.VisitEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class PatientDaoImpl implements PatientDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public PatientEntity save(PatientEntity patient) {
        entityManager.persist(patient);
        return patient;
    }

    @Override
    @Transactional
    public PatientEntity findOne(Long id) {
        return entityManager.find(PatientEntity.class, id);
    }

    @Override
    @Transactional
    public void addVisitToPatient(Long patientId, Long doctorId, LocalDateTime time, String description) {
        PatientEntity patient = entityManager.find(PatientEntity.class, patientId);
        DoctorEntity doctor = entityManager.find(DoctorEntity.class, doctorId);

        if (patient == null || doctor == null) {
            throw new IllegalArgumentException("Patient or doctor not found");
        }

        VisitEntity visit = new VisitEntity();
        visit.setTime(time);
        visit.setDescription(description);
        visit.setDoctor(doctor);
        visit.setPatient(patient);

        patient.getVisits().add(visit);

        entityManager.merge(patient);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PatientEntity> findByLastName(String lastName) {
        return entityManager.createQuery(
                        "SELECT p FROM PatientEntity p WHERE p.lastName = :lastName", PatientEntity.class)
                .setParameter("lastName", lastName)
                .getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<PatientEntity> findPatientsWithMoreThanXVisits(long numberOfVisits) {
        return entityManager.createQuery(
                        "SELECT p FROM PatientEntity p WHERE SIZE(p.visits) > :visitCount", PatientEntity.class)
                .setParameter("visitCount", numberOfVisits)
                .getResultList();
    }
    public PatientDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional(readOnly = true)
    public List<PatientEntity> findPatientsBornBefore(LocalDate date) {
        return entityManager.createQuery(
                        "SELECT p FROM PatientEntity p WHERE p.dateOfBirth < :date", PatientEntity.class)
                .setParameter("date", date)
                .getResultList();
    }

}
