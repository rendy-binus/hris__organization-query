package com.rendyezaputra.hris.organizationquery.api.query.jobfunction;

import com.rendyezaputra.hris.hriswebresources.cqrs.query.BaseQuery;
import com.rendyezaputra.hris.hriswebresources.dto.ComparisonOperator;
import com.rendyezaputra.hris.hriswebresources.dto.SortDirection;
import com.rendyezaputra.hris.organizationquery.api.constant.JobFunctionSortField;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FindJobFunctionByLevelQuery extends BaseQuery {
    private short level;
    private int page;
    private int size;
    private ComparisonOperator comparisonOperator;
    private JobFunctionSortField sortField;
    private SortDirection sortDirection;
    private boolean active;
}
