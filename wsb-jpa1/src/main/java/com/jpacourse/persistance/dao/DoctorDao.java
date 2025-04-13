package com.jpacourse.persistance.dao;

import com.jpacourse.persistance.entity.DoctorEntity;

public interface DoctorDao {
    DoctorEntity save(DoctorEntity doctor);
    DoctorEntity findOne(Long id);
}
