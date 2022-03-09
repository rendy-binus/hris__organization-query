package com.rendyezaputra.hris.organizationquery.domain.repository;

import com.rendyezaputra.hris.hriswebresources.entity.BaseEntity;
import com.rendyezaputra.hris.organizationquery.domain.entity.TeamEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TeamRepository extends JpaRepository<TeamEntity, UUID> {
    Page<BaseEntity> findByActiveTrueAndDeletedFalse(Pageable pageable);

    Page<BaseEntity> findByActiveFalseAndDeletedFalse(Pageable pageable);

    Page<BaseEntity> findByNameContainingIgnoreCaseAndActiveAndDeletedFalse(String name, boolean active, Pageable pageable);

}
