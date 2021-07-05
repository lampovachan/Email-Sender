//package com.tkachuk.consumer;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.stereotype.Component;
//
//@Component
//public class MailSender {
//    @Autowired
//    private JavaMailSender javaMailSender;
//
//    void sendEmail(String mail) {
//
//        SimpleMailMessage msg = new SimpleMailMessage();
//        msg.setTo(mail);
//        msg.setFrom("kafkamail@gmail.com");
//        msg.setSubject("Testing from Spring Boot");
//        msg.setText("Hello World \n Spring Boot Email");
//
//        javaMailSender.send(msg);
//    }
//}