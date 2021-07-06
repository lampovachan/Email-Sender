package com.tkachuk.producer.controller;

import com.tkachuk.dto.Mail;
import com.tkachuk.producer.service.MessageService;
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

    @PostMapping("/publish")
    public String publishMessage(@RequestBody Mail mail) {
        MessageService messageService = new MessageService();
        messageService.sendMessage(kafkaTemplate, mail);
       return "Published Successfully!";
    }
}
