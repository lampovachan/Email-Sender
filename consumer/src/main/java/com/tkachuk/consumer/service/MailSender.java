package com.tkachuk.consumer.service;

import com.google.gson.Gson;
import com.tkachuk.dto.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

//public class MailSender {
//
//    @KafkaListener(topics = "NewTopic", groupId = "group_id")
//    public void creatingEmail(String message) {
//        Mail mail = new Gson().fromJson(message, Mail.class);
//        SimpleMailMessage msg = new SimpleMailMessage();
//        msg.setTo(mail.getMail());
//        msg.setFrom("kafkamail@gmail.com");
//        msg.setSubject("Testing from Spring Boot");
//        msg.setText("Hello World \n Spring Boot Email");
//        mailSender.send(msg);
//    }
//
//}
