package com.tkachuk.consumer.service;

import com.google.gson.Gson;
import com.tkachuk.dto.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

/**
 * This class receives messages from Kafka and sends them via email.
 * @author Svitlana Tkachuk
 */

@Component
public class KafkaConsumer {

    @KafkaListener(topics = "NewTopic", groupId = "group_id")
    public void consume(String message)
    {
        //This magic trick was found on https://stackoverflow.com/questions/1688099/converting-json-data-to-java-object
        Mail mail = new Gson().fromJson(message, Mail.class);
        MailService mailService = new MailService();
        mailService.creatingEmail(mail);
    }
}
