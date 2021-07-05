package com.tkachuk.consumer;

import com.google.gson.Gson;
import com.tkachuk.dto.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
    @Autowired
    JavaMailSender mailSender;

    @KafkaListener(topics = "NewTopic", groupId = "group_id")
    public String consume(String message)
    {
        Mail mail = new Gson().fromJson(message, Mail.class);

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(mail.getMail());
        msg.setFrom("kafkamail@gmail.com");
        msg.setSubject("Testing from Spring Boot");
        msg.setText("Hello World \n Spring Boot Email");


        mailSender.send(msg);
        System.out.println("message = " + message);
        return message;
    }
}
