package com.tkachuk.consumer.service;

import com.google.gson.Gson;
import com.tkachuk.dto.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/**
 * This class receives messages from Kafka and sends them via email.
 * @author Svitlana Tkachuk
 */

@RestController
@RequestMapping("rest/consumer")
public class KafkaConsumer {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    JavaMailSenderImpl mailSender;

    //for some reason it can't found this annotation through hystrix is in pom.xml
    @HystrixCommand(fallbackMethod = "fallback", groupKey = "consumer",
            commandKey = "consumer",
            threadPoolKey = "consumerThread"
    )
    public String consume() {
        String url = "http://producer/rest/producer/publish"; //not sure that's right url
        return restTemplate.getForObject(url, String.class); //not sure that i understand what's happening

        //Mail mail = new Gson().fromJson(message, Mail.class);
        //MailService mailService = new MailService();
        //mailService.creatingEmail(mail, mailSender);
    }

    public String fallback(Throwable hystrixCommand) {
        return "Fall Back Hello world";
    }
}
