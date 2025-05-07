package com.jpacourse.persistance.dao;

import com.jpacourse.persistance.entity.PatientEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class DaoTest {

    @Autowired
    private PatientDao patientDao;

    @Test
    @Transactional
    void shouldFindPatientsByLastName() {
        // given
        PatientEntity patient = new PatientEntity();
        patient.setLastName("Prusak");
        patientDao.save(patient);

        // when
        List<PatientEntity> results = patientDao.findByLastName("Prusak");

        // then
        assertThat(results).isNotEmpty();
    }
    @Test
    @Transactional
    void shouldFindPatientsWithMoreThanXVisits() {
        // given
        PatientEntity patientWith3Visits = new PatientEntity();
        patientWith3Visits.setFirstName("Adam");
        patientWith3Visits.setLastName("Nowak");

        PatientEntity patientWith1Visit = new PatientEntity();
        patientWith1Visit.setFirstName("Ewa");
        patientWith1Visit.setLastName("Kowalska");

        patientDao.save(patientWith3Visits);
        patientDao.save(patientWith1Visit);

        // dodaj 3 wizyty do pierwszego pacjenta
        for (int i = 0; i < 3; i++) {
            patientDao.addVisitToPatient(patientWith3Visits.getId(), null,
                    java.time.LocalDateTime.now(), "Wizyta " + i);
        }

        // dodaj 1 wizytę do drugiego pacjenta
        patientDao.addVisitToPatient(patientWith1Visit.getId(), null,
                java.time.LocalDateTime.now(), "Wizyta pojedyncza");

        // when
        List<PatientEntity> result = patientDao.findPatientsWithMoreThanXVisits(2);

        // then
        assertThat(result).extracting(PatientEntity::getLastName)
                .contains("Nowak")
                .doesNotContain("Kowalska");
    }
}
