package com.rendyezaputra.hris.organizationquery.infrastructure.consumer.implementation;

import com.rendyezaputra.hris.hriswebresources.event.jobfunction.*;
import com.rendyezaputra.hris.organizationquery.infrastructure.consumer.JobFunctionConsumer;
import com.rendyezaputra.hris.organizationquery.infrastructure.handler.JobFunctionEventHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class JobFunctionConsumerImpl implements JobFunctionConsumer {
    private final JobFunctionEventHandler eventHandler;

    @KafkaListener(topics = "JobFunctionCreatedEvent",
            clientIdPrefix = "JobFunctionCreatedEvent",
            groupId = "${spring.kafka.consumer.group-id}")
    @Override
    public void consume(JobFunctionCreatedEvent event, Acknowledgment ack) {
        eventHandler.on(event);
        ack.acknowledge();
    }

    @KafkaListener(topics = "JobFunctionUpdatedEvent",
            clientIdPrefix = "JobFunctionUpdatedEvent",
            groupId = "${spring.kafka.consumer.group-id}")
    @Override
    public void consume(JobFunctionUpdatedEvent event, Acknowledgment ack) {
        eventHandler.on(event);
        ack.acknowledge();
    }

    @KafkaListener(topics = "JobFunctionActivatedEvent",
            clientIdPrefix = "JobFunctionActivatedEvent",
            groupId = "${spring.kafka.consumer.group-id}")
    @Override
    public void consume(JobFunctionActivatedEvent event, Acknowledgment ack) {
        eventHandler.on(event);
        ack.acknowledge();
    }

    @KafkaListener(topics = "JobFunctionDeactivatedEvent",
            clientIdPrefix = "JobFunctionDeactivatedEvent",
            groupId = "${spring.kafka.consumer.group-id}")
    @Override
    public void consume(JobFunctionDeactivatedEvent event, Acknowledgment ack) {
        eventHandler.on(event);
        ack.acknowledge();
    }

    @KafkaListener(topics = "JobFunctionDeletedEvent",
            clientIdPrefix = "JobFunctionDeletedEvent",
            groupId = "${spring.kafka.consumer.group-id}")
    @Override
    public void consume(JobFunctionDeletedEvent event, Acknowledgment ack) {
        eventHandler.on(event);
        ack.acknowledge();
    }
}
