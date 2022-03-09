package com.rendyezaputra.hris.organizationquery.infrastructure.handler.implementation;

import com.rendyezaputra.hris.hriswebresources.event.team.*;
import com.rendyezaputra.hris.organizationquery.domain.entity.TeamEntity;
import com.rendyezaputra.hris.organizationquery.domain.repository.TeamRepository;
import com.rendyezaputra.hris.organizationquery.infrastructure.handler.TeamEventHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TeamEventHandlerImpl implements TeamEventHandler {
    private final TeamRepository repository;

    @Override
    public void on(TeamCreatedEvent event) {
        TeamEntity entity = TeamEntity.builder()
                .id(event.getId())
                .name(event.getName())
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
    public void on(TeamUpdatedEvent event) {
        TeamEntity entity = repository.findById(event.getId())
                .orElse(null);

        if (entity == null) {
            return;
        }

        entity.setName(event.getName());
        entity.setColor(event.getColor());
        entity.setUpdatedBy(event.getUpdatedBy());
        entity.setUpdatedDate(event.getUpdatedDate());

        repository.save(entity);
    }

    @Override
    public void on(TeamActivatedEvent event) {
        TeamEntity entity = repository.findById(event.getId())
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
    public void on(TeamDeactivatedEvent event) {
        TeamEntity entity = repository.findById(event.getId())
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
    public void on(TeamDeletedEvent event) {
        TeamEntity entity = repository.findById(event.getId())
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
