package com.tkachuk.producer.controller;

import com.tkachuk.dto.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


/**
 * This class contains endpoint for sending message using post method.
 *
 * @author Svitlana Tkachuk
 */
@RestController
@RequestMapping("/rest/producer")
public class ProducerController {
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/publish")
    public String publishMessage(@RequestBody Mail mail) {
        String url = "http://localhost:9091/rest/consumer/receive";
        HttpEntity<Mail> requestBody = new HttpEntity<>(mail);
        restTemplate.postForEntity(url, requestBody, Mail.class);
        return "Request resend to consumer!";
    }
}
