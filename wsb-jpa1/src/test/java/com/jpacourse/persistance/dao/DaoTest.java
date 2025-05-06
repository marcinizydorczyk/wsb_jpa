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
}
