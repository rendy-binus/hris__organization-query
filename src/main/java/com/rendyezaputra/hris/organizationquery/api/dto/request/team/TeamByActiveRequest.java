package com.rendyezaputra.hris.organizationquery.api.dto.request.team;

import com.rendyezaputra.hris.hriswebresources.dto.SortDirection;
import com.rendyezaputra.hris.hriswebresources.validation.constraint.ValueOfEnum;
import com.rendyezaputra.hris.organizationquery.api.constant.TeamSortField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeamByActiveRequest {
    private boolean active;

    @Min(1)
    private int page;

    @Min(5)
    @Max(50)
    private int size;

    @ValueOfEnum(enumClass = TeamSortField.class, message = "{validation.sortBy.message}")
    private String sortBy = "created_date";

    @ValueOfEnum(enumClass = SortDirection.class, message = "{validation.direction.message}")
    private String direction = SortDirection.ASC.name();
}
