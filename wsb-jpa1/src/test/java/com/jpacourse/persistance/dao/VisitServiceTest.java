package com.jpacourse.persistance.dao;

import com.jpacourse.dto.VisitTO;
import com.jpacourse.persistance.entity.VisitEntity;
import com.jpacourse.service.VisitService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SpringBootTest
@AutoConfigureTestDatabase
@Transactional
public class VisitServiceTest {

    @Autowired
    private VisitService visitService;

    @Test
    void shouldReturnAllVisitsForPatient() {
        List<VisitTO> visits = visitService.findAllByPatientId(3L);
        assertThat(visits).hasSize(3);
    }
}
