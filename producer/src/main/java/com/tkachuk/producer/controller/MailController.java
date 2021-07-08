package com.tkachuk.producer.controller;

import com.tkachuk.dto.Mail;
import com.tkachuk.producer.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * This class contains endpoint for sending message using post method.
 * @author Svitlana Tkachuk
 */
@RestController
@RequestMapping("/rest/producer")
public class MailController {

    @Autowired
    KafkaTemplate<String, Mail> kafkaTemplate;

    @PostMapping("/publish")
    public String publishMessage(@RequestBody Mail mail) {
        //don't know how to make this logic for sending json to consumer

        //MessageService messageService = new MessageService();
        //messageService.sendMessage(kafkaTemplate, mail);
       return "Published Successfully!";
    }
}
