package com.tkachuk.consumer.service;

import com.tkachuk.dto.Mail;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;


/**
 * This service class contains the process of creating email structure.
 */

public class MailService {

    public void creatingEmail(Mail mail, JavaMailSenderImpl mailSender) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(mail.getMail());
        msg.setFrom("svetamail@gmail.com");
        msg.setSubject("Testing from Spring Boot");
        msg.setText("Hello World \n Spring Boot Email");
        mailSender.send(msg);
    }
}
