package com.rendyezaputra.hris.organizationquery.api.handler;

import com.rendyezaputra.hris.hriswebresources.entity.BaseEntity;
import com.rendyezaputra.hris.organizationquery.api.query.team.FindTeamByActiveQuery;
import com.rendyezaputra.hris.organizationquery.api.query.team.FindTeamByIdQuery;
import com.rendyezaputra.hris.organizationquery.api.query.team.FindTeamByNameQuery;
import org.springframework.data.domain.Page;

public interface TeamQueryHandler {
    Page<BaseEntity> handle(FindTeamByIdQuery query);
    Page<BaseEntity> handle(FindTeamByActiveQuery query);
    Page<BaseEntity> handle(FindTeamByNameQuery query);
}
