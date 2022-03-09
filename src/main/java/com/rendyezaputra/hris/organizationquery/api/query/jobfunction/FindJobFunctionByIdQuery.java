package com.rendyezaputra.hris.organizationquery.api.query.jobfunction;

import com.rendyezaputra.hris.hriswebresources.cqrs.query.BaseQuery;
import lombok.*;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FindJobFunctionByIdQuery extends BaseQuery {
    private UUID id;
}
