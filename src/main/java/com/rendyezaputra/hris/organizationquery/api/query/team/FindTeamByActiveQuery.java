package com.rendyezaputra.hris.organizationquery.api.query.team;

import com.rendyezaputra.hris.hriswebresources.cqrs.query.BaseQuery;
import com.rendyezaputra.hris.hriswebresources.dto.SortDirection;
import com.rendyezaputra.hris.organizationquery.api.constant.TeamSortField;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FindTeamByActiveQuery extends BaseQuery {
    private boolean active;
    private int page;
    private int size;
    private TeamSortField sortField;
    private SortDirection sortDirection;
}
