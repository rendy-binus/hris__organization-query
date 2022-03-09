package com.rendyezaputra.hris.organizationquery.domain.repository;

import com.rendyezaputra.hris.hriswebresources.entity.BaseEntity;
import com.rendyezaputra.hris.organizationquery.domain.entity.JobFunctionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface JobFunctionRepository extends JpaRepository<JobFunctionEntity, UUID> {
    Page<BaseEntity> findByActiveTrueAndDeletedFalse(Pageable pageable);

    Page<BaseEntity> findByActiveFalseAndDeletedFalse(Pageable pageable);

    Page<BaseEntity> findByNameContainingIgnoreCaseAndActiveAndDeletedFalse(String name, boolean active, Pageable pageable);

    Page<BaseEntity> findByLevelEqualsAndActiveAndDeletedFalse(short level, boolean active, Pageable pageable);

    Page<BaseEntity> findByLevelGreaterThanAndActiveAndDeletedFalse(short level, boolean active, Pageable pageable);

    Page<BaseEntity> findByLevelGreaterThanEqualAndActiveAndDeletedFalse(short level, boolean active, Pageable pageable);

    Page<BaseEntity> findByLevelLessThanAndActiveAndDeletedFalse(short level, boolean active, Pageable pageable);

    Page<BaseEntity> findByLevelLessThanEqualAndActiveAndDeletedFalse(short level, boolean active, Pageable pageable);
}
