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
public class FindJobFunctionByActiveQuery extends BaseQuery {
    private boolean active;
    private int page;
    private int size;
    private JobFunctionSortField sortField;
    private SortDirection sortDirection;
}
