package com.rendyezaputra.hris.organizationquery.api.query.jobfunction;

import com.rendyezaputra.hris.hriswebresources.cqrs.query.BaseQuery;
import com.rendyezaputra.hris.hriswebresources.dto.SortDirection;
import com.rendyezaputra.hris.organizationquery.api.constant.JobFunctionSortField;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FindJobFunctionByNameQuery extends BaseQuery {
    private String name;
    private int page;
    private int size;
    private JobFunctionSortField sortField;
    private SortDirection sortDirection;
    private boolean active;
}
