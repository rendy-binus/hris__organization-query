package com.rendyezaputra.hris.organizationquery.api.mapper;

import com.rendyezaputra.hris.hriswebresources.dto.SortDirection;
import com.rendyezaputra.hris.organizationquery.api.constant.TeamSortField;
import com.rendyezaputra.hris.organizationquery.api.dto.request.team.TeamByActiveRequest;
import com.rendyezaputra.hris.organizationquery.api.dto.request.team.TeamByNameRequest;
import com.rendyezaputra.hris.organizationquery.api.query.team.FindTeamByActiveQuery;
import com.rendyezaputra.hris.organizationquery.api.query.team.FindTeamByIdQuery;
import com.rendyezaputra.hris.organizationquery.api.query.team.FindTeamByNameQuery;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TeamMapper {
    public FindTeamByActiveQuery toQuery(TeamByActiveRequest request) {
        return FindTeamByActiveQuery.builder()
                .active(request.isActive())
                .page(request.getPage() - 1)
                .size(request.getSize())
                .sortField(TeamSortField.valueOf(request.getSortBy().toUpperCase()))
                .sortDirection(SortDirection.valueOf(request.getDirection().toUpperCase()))
                .build();
    }

    public FindTeamByIdQuery toQuery(UUID id) {
        return FindTeamByIdQuery.builder()
                .id(id)
                .build();
    }

    public FindTeamByNameQuery toQuery(TeamByNameRequest request) {
        return FindTeamByNameQuery.builder()
                .active(request.isActive())
                .name(request.getSearchKey())
                .page(request.getPage() - 1)
                .size(request.getSize())
                .sortField(TeamSortField.valueOf(request.getSortBy().toUpperCase()))
                .sortDirection(SortDirection.valueOf(request.getDirection().toUpperCase()))
                .build();
    }
}
