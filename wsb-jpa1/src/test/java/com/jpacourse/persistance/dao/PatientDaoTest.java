package com.jpacourse.persistance.dao;

import com.jpacourse.persistance.entity.*;
import com.jpacourse.persistance.enums.Specialization;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PatientDaoTest {

    @Autowired
    private PatientDao patientDao;

    @Autowired
    private DoctorDao doctorDao;

    @Transactional
    @Test
    public void testAddVisitToPatient() {
        // given – pacjent
        PatientEntity patient = new PatientEntity();
        patient.setFirstName("Jan");
        patient.setLastName("Kowalski");
        patient.setTelephoneNumber("123456789");
        patient.setPatientNumber("P001");
        patient.setDateOfBirth(LocalDate.of(1990, 1, 1));
        patient = patientDao.save(patient);

        // doktor
        DoctorEntity doctor = new DoctorEntity();
        doctor.setFirstName("Anna");
        doctor.setLastName("Nowak");
        doctor.setTelephoneNumber("987654321");
        doctor.setDoctorNumber("D001");
        doctor.setSpecialization(Specialization.OCULIST); // dopasuj do enum
        doctor = doctorDao.save(doctor);

        // when
        patientDao.addVisitToPatient(
                patient.getId(),
                doctor.getId(),
                LocalDateTime.of(2025, 4, 15, 10, 0),
                "Wizyta testowa"
        );

        // then
        PatientEntity updated = patientDao.findOne(patient.getId());
        assertThat(updated.getVisits()).isNotEmpty();
        VisitEntity visit = updated.getVisits().get(0);
        assertThat(visit.getDescription()).isEqualTo("Wizyta testowa");
        assertThat(visit.getDoctor().getFirstName()).isEqualTo("Anna");
    }
}
