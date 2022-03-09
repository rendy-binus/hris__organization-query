package com.rendyezaputra.hris.organizationquery.api.handler.implementation;

import com.rendyezaputra.hris.hriswebresources.dto.SortDirection;
import com.rendyezaputra.hris.hriswebresources.entity.BaseEntity;
import com.rendyezaputra.hris.organizationquery.api.handler.JobFunctionQueryHandler;
import com.rendyezaputra.hris.organizationquery.api.query.jobfunction.FindJobFunctionByActiveQuery;
import com.rendyezaputra.hris.organizationquery.api.query.jobfunction.FindJobFunctionByIdQuery;
import com.rendyezaputra.hris.organizationquery.api.query.jobfunction.FindJobFunctionByLevelQuery;
import com.rendyezaputra.hris.organizationquery.api.query.jobfunction.FindJobFunctionByNameQuery;
import com.rendyezaputra.hris.organizationquery.domain.entity.JobFunctionEntity;
import com.rendyezaputra.hris.organizationquery.domain.repository.JobFunctionRepository;
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
public class JobFunctionQueryHandlerImpl implements JobFunctionQueryHandler {
    private final JobFunctionRepository repository;

    @Override
    public Page<BaseEntity> handle(FindJobFunctionByIdQuery query) {
        List<BaseEntity> entities = new ArrayList<>();
        JobFunctionEntity entity = repository.findById(query.getId())
                .orElse(null);

        if (entity == null) {
            return null;
        }

        entities.add(entity);

        return new PageImpl<>(entities);
    }

    @Override
    public Page<BaseEntity> handle(FindJobFunctionByActiveQuery query) {
        Sort sort = query.getSortDirection().equals(SortDirection.ASC) ? Sort.by(query.getSortField().getField()).ascending()
                : Sort.by(query.getSortField().getField()).descending();
        return query.isActive() ? repository.findByActiveTrueAndDeletedFalse(PageRequest.of(query.getPage(), query.getSize(), sort))
            : repository.findByActiveFalseAndDeletedFalse(PageRequest.of(query.getPage(), query.getSize(), sort));
    }

    @Override
    public Page<BaseEntity> handle(FindJobFunctionByNameQuery query) {
        Sort sort = query.getSortDirection().equals(SortDirection.ASC) ? Sort.by(query.getSortField().getField()).ascending()
                : Sort.by(query.getSortField().getField()).descending();
        return repository.findByNameContainingIgnoreCaseAndActiveAndDeletedFalse(query.getName(), query.isActive(), PageRequest.of(query.getPage(), query.getSize(), sort));
    }

    @Override
    public Page<BaseEntity> handle(FindJobFunctionByLevelQuery query) {
        Sort sort = query.getSortDirection().equals(SortDirection.ASC) ? Sort.by(query.getSortField().getField()).ascending()
                : Sort.by(query.getSortField().getField()).descending();

        switch (query.getComparisonOperator()) {
            case EQ:
                return repository.findByLevelEqualsAndActiveAndDeletedFalse(query.getLevel(), query.isActive(), PageRequest.of(query.getPage(), query.getSize(), sort));
            case GT:
                return repository.findByLevelGreaterThanAndActiveAndDeletedFalse(query.getLevel(), query.isActive(), PageRequest.of(query.getPage(), query.getSize(), sort));
            case GE:
                return repository.findByLevelGreaterThanEqualAndActiveAndDeletedFalse(query.getLevel(), query.isActive(), PageRequest.of(query.getPage(), query.getSize(), sort));
            case LT:
                return repository.findByLevelLessThanAndActiveAndDeletedFalse(query.getLevel(), query.isActive(), PageRequest.of(query.getPage(), query.getSize(), sort));
            case LE:
                return repository.findByLevelLessThanEqualAndActiveAndDeletedFalse(query.getLevel(), query.isActive(), PageRequest.of(query.getPage(), query.getSize(), sort));
            default:
                return Page.empty();
        }
    }
}
