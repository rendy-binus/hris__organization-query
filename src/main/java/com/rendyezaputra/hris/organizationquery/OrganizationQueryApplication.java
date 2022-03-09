package com.rendyezaputra.hris.organizationquery;

import com.rendyezaputra.hris.hriswebresources.cqrs.query.QueryDispatcher;
import com.rendyezaputra.hris.organizationquery.api.handler.JobFunctionQueryHandler;
import com.rendyezaputra.hris.organizationquery.api.handler.TeamQueryHandler;
import com.rendyezaputra.hris.organizationquery.api.query.jobfunction.FindJobFunctionByActiveQuery;
import com.rendyezaputra.hris.organizationquery.api.query.jobfunction.FindJobFunctionByIdQuery;
import com.rendyezaputra.hris.organizationquery.api.query.jobfunction.FindJobFunctionByLevelQuery;
import com.rendyezaputra.hris.organizationquery.api.query.jobfunction.FindJobFunctionByNameQuery;
import com.rendyezaputra.hris.organizationquery.api.query.team.FindTeamByActiveQuery;
import com.rendyezaputra.hris.organizationquery.api.query.team.FindTeamByIdQuery;
import com.rendyezaputra.hris.organizationquery.api.query.team.FindTeamByNameQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableDiscoveryClient
@RequiredArgsConstructor
public class OrganizationQueryApplication {
    private final QueryDispatcher queryDispatcher;
    private final JobFunctionQueryHandler jobFunctionQueryHandler;
    private final TeamQueryHandler teamQueryHandler;

    public static void main(String[] args) {
        SpringApplication.run(OrganizationQueryApplication.class, args);
    }

    @PostConstruct
    public void registerHandlers() {
        queryDispatcher.registerHandler(FindJobFunctionByActiveQuery.class, jobFunctionQueryHandler::handle);
        queryDispatcher.registerHandler(FindJobFunctionByIdQuery.class, jobFunctionQueryHandler::handle);
        queryDispatcher.registerHandler(FindJobFunctionByLevelQuery.class, jobFunctionQueryHandler::handle);
        queryDispatcher.registerHandler(FindJobFunctionByNameQuery.class, jobFunctionQueryHandler::handle);

        queryDispatcher.registerHandler(FindTeamByActiveQuery.class, teamQueryHandler::handle);
        queryDispatcher.registerHandler(FindTeamByIdQuery.class, teamQueryHandler::handle);
        queryDispatcher.registerHandler(FindTeamByNameQuery.class, teamQueryHandler::handle);
    }

}
