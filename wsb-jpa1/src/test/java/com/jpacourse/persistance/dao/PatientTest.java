package com.jpacourse.persistance.dao;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.mapper.PatientMapper;
import com.jpacourse.persistance.entity.PatientEntity;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;



public class PatientTest {
    @Test
    void shouldMapEntityToTO() {
        // given
        PatientEntity entity = new PatientEntity();
        entity.setId(1L);
        entity.setFirstName("Kacper");
        entity.setLastName("Prusak");
        entity.setTelephoneNumber("123456789");
        entity.setEmail("kacperprusak@wp.pl");
        entity.setPatientNumber("P001");
        entity.setDateOfBirth(LocalDate.of(1990, 5, 20));

        // when
        PatientTO result = PatientMapper.mapToTO(entity);

        // then
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Kacper", result.getFirstName());
        assertEquals("Prusak", result.getLastName());
        assertEquals("123456789", result.getTelephoneNumber());
        assertEquals("kacperprusak@wp.pl", result.getEmail());
        assertEquals("P001", result.getPatientNumber());
        assertEquals(LocalDate.of(1990, 5, 20), result.getDateOfBirth());
    }

    @Test
    void shouldMapTOToEntity() {
        // given
        PatientTO to = new PatientTO();
        to.setFirstName("Marcin");
        to.setLastName("Izydorczyk");
        to.setTelephoneNumber("987654321");
        to.setEmail("marizy@wp.pl");
        to.setPatientNumber("P002");
        to.setDateOfBirth(LocalDate.of(1985, 10, 10));

        // when
        PatientEntity result = PatientMapper.mapToEntity(to);

        // then
        assertNotNull(result);
        assertEquals("Marcin", result.getFirstName());
        assertEquals("Izydorczyk", result.getLastName());
        assertEquals("987654321", result.getTelephoneNumber());
        assertEquals("marizy@wp.pl", result.getEmail());
        assertEquals("P002", result.getPatientNumber());
        assertEquals(LocalDate.of(1985, 10, 10), result.getDateOfBirth());
    }

    @Test
    void shouldReturnNullWhenEntityIsNull() {
        // when + then
        assertNull(PatientMapper.mapToTO(null));
    }

    @Test
    void shouldReturnNullWhenTOIsNull() {
        // when + then
        assertNull(PatientMapper.mapToEntity(null));
    }

}

