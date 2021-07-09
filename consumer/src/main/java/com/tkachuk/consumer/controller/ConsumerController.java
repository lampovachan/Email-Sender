package com.tkachuk.consumer.controller;

import com.tkachuk.consumer.service.MailService;
import com.tkachuk.dto.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class receives messages from producer and sends them via email.
 * @author Svitlana Tkachuk
 */

@RestController
@RequestMapping("rest/consumer")
public class ConsumerController {
    @Autowired
    JavaMailSenderImpl mailSender;

    @PostMapping("/receive")
    public void consume(@RequestBody Mail mail) {
        MailService mailService = new MailService();
        mailService.creatingEmail(mail, mailSender);
    }
}
