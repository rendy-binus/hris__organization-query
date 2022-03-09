package com.rendyezaputra.hris.organizationquery.infrastructure.consumer;

import com.rendyezaputra.hris.hriswebresources.event.jobfunction.*;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;

public interface JobFunctionConsumer {
    void consume(@Payload JobFunctionCreatedEvent event, Acknowledgment ack);
    void consume(@Payload JobFunctionUpdatedEvent event, Acknowledgment ack);
    void consume(@Payload JobFunctionActivatedEvent event, Acknowledgment ack);
    void consume(@Payload JobFunctionDeactivatedEvent event, Acknowledgment ack);
    void consume(@Payload JobFunctionDeletedEvent event, Acknowledgment ack);
}
