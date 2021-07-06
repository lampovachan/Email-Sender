package com.tkachuk.consumer.service;

import com.google.gson.Gson;
import com.tkachuk.dto.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * This class receives messages from Kafka and sends them via email.
 * @author Svitlana Tkachuk
 */

@Component
public class KafkaConsumer {
    @Autowired
    JavaMailSenderImpl mailSender;


    @KafkaListener(topics = "NewTopic", groupId = "group_id")
    public void consume(String message) {
        Mail mail = new Gson().fromJson(message, Mail.class);
        MailService mailService = new MailService();
        mailService.creatingEmail(mail, mailSender);
    }
}
