package com.jpacourse.persistance.dao.impl;

import com.jpacourse.persistance.dao.DoctorDao;
import com.jpacourse.persistance.entity.DoctorEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class DoctorDaoImpl implements DoctorDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public DoctorEntity save(DoctorEntity doctor) {
        entityManager.persist(doctor);
        return doctor;
    }

    @Override
    public DoctorEntity findOne(Long id) {
        return entityManager.find(DoctorEntity.class, id);
    }
}
