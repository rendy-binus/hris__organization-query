package com.rendyezaputra.hris.organizationquery.api.handler;

import com.rendyezaputra.hris.hriswebresources.entity.BaseEntity;
import com.rendyezaputra.hris.organizationquery.api.query.jobfunction.FindJobFunctionByActiveQuery;
import com.rendyezaputra.hris.organizationquery.api.query.jobfunction.FindJobFunctionByIdQuery;
import com.rendyezaputra.hris.organizationquery.api.query.jobfunction.FindJobFunctionByLevelQuery;
import com.rendyezaputra.hris.organizationquery.api.query.jobfunction.FindJobFunctionByNameQuery;
import org.springframework.data.domain.Page;

public interface JobFunctionQueryHandler {
    Page<BaseEntity> handle(FindJobFunctionByIdQuery query);
    Page<BaseEntity> handle(FindJobFunctionByActiveQuery query);
    Page<BaseEntity> handle(FindJobFunctionByNameQuery query);
    Page<BaseEntity> handle(FindJobFunctionByLevelQuery query);
}
