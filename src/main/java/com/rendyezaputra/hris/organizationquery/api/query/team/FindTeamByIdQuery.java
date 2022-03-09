package com.rendyezaputra.hris.organizationquery.api.query.team;

import com.rendyezaputra.hris.hriswebresources.cqrs.query.BaseQuery;
import lombok.*;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FindTeamByIdQuery extends BaseQuery {
    private UUID id;
}
