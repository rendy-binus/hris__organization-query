package com.rendyezaputra.hris.organizationquery.infrastructure.handler.implementation;

import com.rendyezaputra.hris.hriswebresources.event.jobfunction.*;
import com.rendyezaputra.hris.organizationquery.domain.entity.JobFunctionEntity;
import com.rendyezaputra.hris.organizationquery.domain.repository.JobFunctionRepository;
import com.rendyezaputra.hris.organizationquery.infrastructure.handler.JobFunctionEventHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class JobFunctionEventHandlerImpl implements JobFunctionEventHandler {
    private final JobFunctionRepository repository;

    @Override
    public void on(JobFunctionCreatedEvent event) {
        JobFunctionEntity entity = JobFunctionEntity.builder()
                .id(event.getId())
                .name(event.getName())
                .level(event.getLevel())
                .color(event.getColor())
                .createdBy(event.getCreatedBy())
                .createdDate(event.getCreatedDate())
                .updatedBy(event.getCreatedBy())
                .updatedDate(event.getCreatedDate())
                .active(event.isActive())
                .deleted(event.isDeleted())
                .build();

        repository.save(entity);
    }

    @Override
    public void on(JobFunctionUpdatedEvent event) {
        JobFunctionEntity entity = repository.findById(event.getId())
                .orElse(null);

        if (entity == null) {
            return;
        }

        entity.setName(event.getName());
        entity.setLevel(event.getLevel());
        entity.setColor(event.getColor());
        entity.setUpdatedBy(event.getUpdatedBy());
        entity.setUpdatedDate(event.getUpdatedDate());

        repository.save(entity);
    }

    @Override
    public void on(JobFunctionActivatedEvent event) {
        JobFunctionEntity entity = repository.findById(event.getId())
                .orElse(null);

        if (entity == null) {
            return;
        }

        entity.setUpdatedBy(event.getUpdatedBy());
        entity.setUpdatedDate(event.getUpdatedDate());
        entity.setActive(true);

        repository.save(entity);
    }

    @Override
    public void on(JobFunctionDeactivatedEvent event) {
        JobFunctionEntity entity = repository.findById(event.getId())
                .orElse(null);

        if (entity == null) {
            return;
        }

        entity.setUpdatedBy(event.getUpdatedBy());
        entity.setUpdatedDate(event.getUpdatedDate());
        entity.setActive(false);

        repository.save(entity);
    }

    @Override
    public void on(JobFunctionDeletedEvent event) {
        JobFunctionEntity entity = repository.findById(event.getId())
                .orElse(null);

        if (entity == null) {
            return;
        }

        entity.setUpdatedBy(event.getUpdatedBy());
        entity.setUpdatedDate(event.getUpdatedDate());
        entity.setActive(false);
        entity.setDeleted(true);

        repository.save(entity);
    }
}
