package com.rendyezaputra.hris.organizationquery.api.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.rendyezaputra.hris.hriswebresources.dto.BaseResponse;
import com.rendyezaputra.hris.organizationquery.domain.entity.TeamEntity;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class TeamResponse extends BaseResponse {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("teams")
    List<TeamEntity> teamEntities;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("team")
    TeamEntity team;

    @Builder
    public TeamResponse(String message, List<TeamEntity> teamEntities, TeamEntity team) {
        super(message);
        this.teamEntities = teamEntities;
        this.team = team;
    }
}
