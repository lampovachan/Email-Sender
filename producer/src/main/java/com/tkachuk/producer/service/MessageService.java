package com.tkachuk.producer.service;

import com.tkachuk.dto.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * This service class contains functionality for sending message to Kafka.
 */
@Service
public class MessageService {
    private static final String TOPIC = "NewTopic";
    @Autowired
    KafkaTemplate<String, Mail> kafkaTemplate;

    public void sendMessage(Mail mail) {
        kafkaTemplate.send(TOPIC, mail);
    }
}
