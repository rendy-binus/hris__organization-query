package com.rendyezaputra.hris.organizationquery.infrastructure.consumer;

import com.rendyezaputra.hris.hriswebresources.event.team.*;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;

public interface TeamConsumer {
    void consume(@Payload TeamCreatedEvent event, Acknowledgment ack);
    void consume(@Payload TeamUpdatedEvent event, Acknowledgment ack);
    void consume(@Payload TeamActivatedEvent event, Acknowledgment ack);
    void consume(@Payload TeamDeactivatedEvent event, Acknowledgment ack);
    void consume(@Payload TeamDeletedEvent event, Acknowledgment ack);
}
