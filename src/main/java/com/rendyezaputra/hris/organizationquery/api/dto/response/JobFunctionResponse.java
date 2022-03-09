package com.rendyezaputra.hris.organizationquery.api.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.rendyezaputra.hris.hriswebresources.dto.BaseResponse;
import com.rendyezaputra.hris.organizationquery.domain.entity.JobFunctionEntity;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class JobFunctionResponse extends BaseResponse {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("jobFunctions")
    List<JobFunctionEntity> jobFunctionEntities;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("jobFunction")
    JobFunctionEntity jobFunction;

    @Builder
    public JobFunctionResponse(String message, List<JobFunctionEntity> jobFunctionEntities, JobFunctionEntity jobFunction) {
        super(message);
        this.jobFunctionEntities = jobFunctionEntities;
        this.jobFunction = jobFunction;
    }
}
