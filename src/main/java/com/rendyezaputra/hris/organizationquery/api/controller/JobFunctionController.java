package com.rendyezaputra.hris.organizationquery.api.controller;

import com.rendyezaputra.hris.hriswebresources.cqrs.query.QueryDispatcher;
import com.rendyezaputra.hris.hriswebresources.dto.BaseResponse;
import com.rendyezaputra.hris.organizationquery.api.dto.request.jobfunction.JobFunctionByActiveRequest;
import com.rendyezaputra.hris.organizationquery.api.dto.request.jobfunction.JobFunctionByLevelRequest;
import com.rendyezaputra.hris.organizationquery.api.dto.request.jobfunction.JobFunctionByNameRequest;
import com.rendyezaputra.hris.organizationquery.api.dto.response.JobFunctionResponse;
import com.rendyezaputra.hris.organizationquery.api.mapper.JobFunctionMapper;
import com.rendyezaputra.hris.organizationquery.domain.entity.JobFunctionEntity;
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
@RequestMapping(path = "/job-function")
public class JobFunctionController {

    private final QueryDispatcher queryDispatcher;
    private final JobFunctionMapper mapper;

    @GetMapping("/all")
    public ResponseEntity<BaseResponse> getJobFunctionByStatus(@Valid JobFunctionByActiveRequest request) {
        try {
            Page<JobFunctionEntity> jobFunctions = queryDispatcher.send(mapper.toQuery(request));

            if (jobFunctions == null || jobFunctions.getTotalElements() == 0) {
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.ok(JobFunctionResponse.builder()
                    .jobFunctionEntities(jobFunctions.getContent())
                    .build());
        } catch (Exception e) {
            log.error("Failed to complete the request with error: {}", e.getLocalizedMessage());
            BaseResponse response = new BaseResponse();
            response.setMessage(e.getLocalizedMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(response);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse> getJobFunctionById(@PathVariable("id") UUID id) {
        try {
            Page<JobFunctionEntity> jobFunctions = queryDispatcher.send(mapper.toQuery(id));

            if (jobFunctions == null || jobFunctions.getSize() == 0) {
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.ok(JobFunctionResponse.builder()
                    .jobFunction(jobFunctions.getContent().get(0))
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
    public ResponseEntity<BaseResponse> getJobFunctionByName(@Valid JobFunctionByNameRequest request) {
        try {
            Page<JobFunctionEntity> jobFunctions = queryDispatcher.send(mapper.toQuery(request));

            if (jobFunctions == null || jobFunctions.getTotalElements() == 0) {
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.ok(JobFunctionResponse.builder()
                    .jobFunctionEntities(jobFunctions.getContent())
                    .build());
        } catch (Exception e) {
            log.error("Failed to complete the request with error: {}", e.getLocalizedMessage());
            BaseResponse response = new BaseResponse();
            response.setMessage(e.getLocalizedMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(response);
        }
    }

    @GetMapping("/findByLevel")
    public ResponseEntity<BaseResponse> getJobFunctionByLevel(@Valid JobFunctionByLevelRequest request) {
        try {
            Page<JobFunctionEntity> jobFunctions = queryDispatcher.send(mapper.toQuery(request));

            if (jobFunctions == null || jobFunctions.getTotalElements() == 0) {
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.ok(JobFunctionResponse.builder()
                    .jobFunctionEntities(jobFunctions.getContent())
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
