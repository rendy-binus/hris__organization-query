package com.rendyezaputra.hris.organizationquery.api.handler.implementation;

import com.rendyezaputra.hris.hriswebresources.dto.SortDirection;
import com.rendyezaputra.hris.hriswebresources.entity.BaseEntity;
import com.rendyezaputra.hris.organizationquery.api.handler.TeamQueryHandler;
import com.rendyezaputra.hris.organizationquery.api.query.team.FindTeamByActiveQuery;
import com.rendyezaputra.hris.organizationquery.api.query.team.FindTeamByIdQuery;
import com.rendyezaputra.hris.organizationquery.api.query.team.FindTeamByNameQuery;
import com.rendyezaputra.hris.organizationquery.domain.entity.TeamEntity;
import com.rendyezaputra.hris.organizationquery.domain.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TeamQueryHandlerImpl implements TeamQueryHandler {
    private final TeamRepository repository;

    @Override
    public Page<BaseEntity> handle(FindTeamByIdQuery query) {
        List<BaseEntity> entities = new ArrayList<>();
        TeamEntity entity = repository.findById(query.getId())
                .orElse(null);

        if (entity == null) {
            return null;
        }

        entities.add(entity);

        return new PageImpl<>(entities);
    }

    @Override
    public Page<BaseEntity> handle(FindTeamByActiveQuery query) {
        Sort sort = query.getSortDirection().equals(SortDirection.ASC) ? Sort.by(query.getSortField().getField()).ascending()
                : Sort.by(query.getSortField().getField()).descending();
        return query.isActive() ? repository.findByActiveTrueAndDeletedFalse(PageRequest.of(query.getPage(), query.getSize(), sort))
                : repository.findByActiveFalseAndDeletedFalse(PageRequest.of(query.getPage(), query.getSize(), sort));
    }

    @Override
    public Page<BaseEntity> handle(FindTeamByNameQuery query) {
        Sort sort = query.getSortDirection().equals(SortDirection.ASC) ? Sort.by(query.getSortField().getField()).ascending()
                : Sort.by(query.getSortField().getField()).descending();
        return repository.findByNameContainingIgnoreCaseAndActiveAndDeletedFalse(query.getName(), query.isActive(), PageRequest.of(query.getPage(), query.getSize(), sort));
    }
}
