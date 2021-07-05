package com.tkachuk.producer.controller;

import com.tkachuk.dto.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * This class contains endpoint for sending message using post method.
 * @author Svitlana Tkachuk
 */
@RestController
public class MailController {

    @Autowired
    KafkaTemplate<String, Mail> kafkaTemplate;

    private static final String TOPIC = "NewTopic";

    @PostMapping("/publish")
    public String publishMessage(@RequestBody Mail mail)
    {
        kafkaTemplate.send(TOPIC, mail);
        return "Published Successfully!";
    }
}
