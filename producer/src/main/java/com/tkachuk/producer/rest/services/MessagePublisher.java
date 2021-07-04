package com.tkachuk.producer.rest.services;

import com.tkachuk.dto.Data;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class MessagePublisher {
    private final KafkaTemplate<String, Message<?>> kafkaTemplate;

    public MessagePublisher(KafkaTemplate<String, Message<?>> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Scheduled(fixedRate = 2000)
    void publishPerson() {
        Message<Data> personMessage = MessageGenerator.generateData();
        kafkaTemplate.send(personMessage);
    }
}
