package com.tkachuk.consumer.service;

import com.tkachuk.dto.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * This service class contains the process of creating email structure.
 */
@Service
public class MailService {
    @Autowired
    JavaMailSender mailSender;

    public void creatingEmail(Mail mail) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(mail.getMail());
        msg.setFrom("kafkamail@gmail.com");
        msg.setSubject("Testing from Spring Boot");
        msg.setText("Hello World \n Spring Boot Email");
        mailSender.send(msg);
    }
}
