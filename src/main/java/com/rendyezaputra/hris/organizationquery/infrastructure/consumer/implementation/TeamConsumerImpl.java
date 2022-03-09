package com.rendyezaputra.hris.organizationquery.infrastructure.consumer.implementation;

import com.rendyezaputra.hris.hriswebresources.event.team.*;
import com.rendyezaputra.hris.organizationquery.infrastructure.consumer.TeamConsumer;
import com.rendyezaputra.hris.organizationquery.infrastructure.handler.TeamEventHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TeamConsumerImpl implements TeamConsumer {
    private final TeamEventHandler eventHandler;

    @KafkaListener(topics = "TeamCreatedEvent",
            clientIdPrefix = "TeamCreatedEvent",
            groupId = "${spring.kafka.consumer.group-id}")
    @Override
    public void consume(TeamCreatedEvent event, Acknowledgment ack) {
        eventHandler.on(event);
        ack.acknowledge();
    }

    @KafkaListener(topics = "TeamUpdatedEvent",
            clientIdPrefix = "TeamUpdatedEvent",
            groupId = "${spring.kafka.consumer.group-id}")
    @Override
    public void consume(TeamUpdatedEvent event, Acknowledgment ack) {
        eventHandler.on(event);
        ack.acknowledge();
    }

    @KafkaListener(topics = "TeamActivatedEvent",
            clientIdPrefix = "TeamActivatedEvent",
            groupId = "${spring.kafka.consumer.group-id}")
    @Override
    public void consume(TeamActivatedEvent event, Acknowledgment ack) {
        eventHandler.on(event);
        ack.acknowledge();
    }

    @KafkaListener(topics = "TeamDeactivatedEvent",
            clientIdPrefix = "TeamDeactivatedEvent",
            groupId = "${spring.kafka.consumer.group-id}")
    @Override
    public void consume(TeamDeactivatedEvent event, Acknowledgment ack) {
        eventHandler.on(event);
        ack.acknowledge();
    }

    @KafkaListener(topics = "TeamDeletedEvent",
            clientIdPrefix = "TeamDeletedEvent",
            groupId = "${spring.kafka.consumer.group-id}")
    @Override
    public void consume(TeamDeletedEvent event, Acknowledgment ack) {
        eventHandler.on(event);
        ack.acknowledge();
    }
}
