package com.rendyezaputra.hris.organizationquery.infrastructure.handler;

import com.rendyezaputra.hris.hriswebresources.event.jobfunction.*;

public interface JobFunctionEventHandler {
    void on(JobFunctionCreatedEvent event);
    void on(JobFunctionUpdatedEvent event);
    void on(JobFunctionActivatedEvent event);
    void on(JobFunctionDeactivatedEvent event);
    void on(JobFunctionDeletedEvent event);
}
