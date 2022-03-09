package com.rendyezaputra.hris.organizationquery.api.dto.request.jobfunction;

import com.rendyezaputra.hris.hriswebresources.dto.SortDirection;
import com.rendyezaputra.hris.hriswebresources.validation.constraint.ValueOfEnum;
import com.rendyezaputra.hris.organizationquery.api.constant.JobFunctionSortField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobFunctionByNameRequest {
    @NotBlank
    @Size(max = 50)
    private String searchKey;

    @Min(1)
    private int page;

    @Min(5)
    @Max(50)
    private int size;

    @ValueOfEnum(enumClass = JobFunctionSortField.class, message = "{validation.sortBy.message}")
    private String sortBy = "name";

    @ValueOfEnum(enumClass = SortDirection.class, message = "{validation.direction.message}")
    private String direction = SortDirection.ASC.name();

    private boolean active = true;
}
