package com.rendyezaputra.hris.organizationquery.infrastructure.handler;

import com.rendyezaputra.hris.hriswebresources.event.team.*;

public interface TeamEventHandler {
    void on(TeamCreatedEvent event);
    void on(TeamUpdatedEvent event);
    void on(TeamActivatedEvent event);
    void on(TeamDeactivatedEvent event);
    void on(TeamDeletedEvent event);
}
