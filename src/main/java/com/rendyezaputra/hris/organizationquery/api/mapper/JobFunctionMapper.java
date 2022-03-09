package com.rendyezaputra.hris.organizationquery.api.mapper;

import com.rendyezaputra.hris.hriswebresources.dto.ComparisonOperator;
import com.rendyezaputra.hris.hriswebresources.dto.SortDirection;
import com.rendyezaputra.hris.organizationquery.api.constant.JobFunctionSortField;
import com.rendyezaputra.hris.organizationquery.api.dto.request.jobfunction.JobFunctionByActiveRequest;
import com.rendyezaputra.hris.organizationquery.api.dto.request.jobfunction.JobFunctionByLevelRequest;
import com.rendyezaputra.hris.organizationquery.api.dto.request.jobfunction.JobFunctionByNameRequest;
import com.rendyezaputra.hris.organizationquery.api.query.jobfunction.FindJobFunctionByActiveQuery;
import com.rendyezaputra.hris.organizationquery.api.query.jobfunction.FindJobFunctionByIdQuery;
import com.rendyezaputra.hris.organizationquery.api.query.jobfunction.FindJobFunctionByLevelQuery;
import com.rendyezaputra.hris.organizationquery.api.query.jobfunction.FindJobFunctionByNameQuery;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class JobFunctionMapper {

    public FindJobFunctionByActiveQuery toQuery(JobFunctionByActiveRequest request) {
        return FindJobFunctionByActiveQuery.builder()
                .active(request.isActive())
                .page(request.getPage() - 1)
                .size(request.getSize())
                .sortField(JobFunctionSortField.valueOf(request.getSortBy().toUpperCase()))
                .sortDirection(SortDirection.valueOf(request.getDirection().toUpperCase()))
                .build();
    }

    public FindJobFunctionByIdQuery toQuery(UUID id) {
        return FindJobFunctionByIdQuery.builder()
                .id(id)
                .build();
    }

    public FindJobFunctionByLevelQuery toQuery(JobFunctionByLevelRequest request) {
        return FindJobFunctionByLevelQuery.builder()
                .active(request.isActive())
                .level(request.getLevel())
                .comparisonOperator(ComparisonOperator.valueOf(request.getOperator().toUpperCase()))
                .page(request.getPage() - 1)
                .size(request.getSize())
                .sortField(JobFunctionSortField.valueOf(request.getSortBy().toUpperCase()))
                .sortDirection(SortDirection.valueOf(request.getDirection().toUpperCase()))
                .build();
    }

    public FindJobFunctionByNameQuery toQuery(JobFunctionByNameRequest request) {
        return FindJobFunctionByNameQuery.builder()
                .active(request.isActive())
                .name(request.getSearchKey())
                .page(request.getPage() - 1)
                .size(request.getSize())
                .sortField(JobFunctionSortField.valueOf(request.getSortBy().toUpperCase()))
                .sortDirection(SortDirection.valueOf(request.getDirection().toUpperCase()))
                .build();
    }

}
