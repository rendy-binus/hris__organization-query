package com.rendyezaputra.hris.organizationquery.api.controller;

import com.rendyezaputra.hris.hriswebresources.cqrs.query.QueryDispatcher;
import com.rendyezaputra.hris.hriswebresources.dto.BaseResponse;
import com.rendyezaputra.hris.organizationquery.api.dto.request.team.TeamByActiveRequest;
import com.rendyezaputra.hris.organizationquery.api.dto.request.team.TeamByNameRequest;
import com.rendyezaputra.hris.organizationquery.api.dto.response.TeamResponse;
import com.rendyezaputra.hris.organizationquery.api.mapper.TeamMapper;
import com.rendyezaputra.hris.organizationquery.domain.entity.TeamEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RestController
@Validated
@RequestMapping(path = "/team")
public class TeamController {

    private final QueryDispatcher queryDispatcher;
    private final TeamMapper mapper;

    @GetMapping("/all")
    public ResponseEntity<BaseResponse> getTeamByStatus(@Valid TeamByActiveRequest request) {
        try {
            Page<TeamEntity> teams = queryDispatcher.send(mapper.toQuery(request));

            log.info("teams: {}", teams);

            if (teams == null || teams.getTotalElements() == 0) {
                return ResponseEntity.noContent().build();
            }

            ResponseEntity<BaseResponse> response = ResponseEntity.ok(TeamResponse.builder()
                    .teamEntities(teams.getContent())
                    .build());

            log.info("response: {}", response);

            return response;
        } catch (Exception e) {
            log.error("Failed to complete the request with error: {}", e.getLocalizedMessage());
            BaseResponse response = new BaseResponse();
            response.setMessage(e.getLocalizedMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(response);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse> getTeamById(@PathVariable("id") UUID id) {
        try {
            Page<TeamEntity> teams = queryDispatcher.send(mapper.toQuery(id));

            if (teams == null || teams.getSize() == 0) {
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.ok(TeamResponse.builder()
                    .team(teams.getContent().get(0))
                    .build());
        } catch (Exception e) {
            log.error("Failed to complete the request with error: {}", e.getLocalizedMessage());
            BaseResponse response = new BaseResponse();
            response.setMessage(e.getLocalizedMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(response);
        }
    }

    @GetMapping("/findByName")
    public ResponseEntity<BaseResponse> getTeamByName(@Valid TeamByNameRequest request) {
        try {
            Page<TeamEntity> teams = queryDispatcher.send(mapper.toQuery(request));

            if (teams == null || teams.getTotalElements() == 0) {
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.ok(TeamResponse.builder()
                    .teamEntities(teams.getContent())
                    .build());
        } catch (Exception e) {
            log.error("Failed to complete the request with error: {}", e.getLocalizedMessage());
            BaseResponse response = new BaseResponse();
            response.setMessage(e.getLocalizedMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(response);
        }
    }
}
