package com.tkachuk.producer.controller;

import com.tkachuk.dto.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * This class contains endpoint for sending message using post method.
 *
 * @author Svitlana Tkachuk
 */
@RestController
@RequestMapping("/rest/producer")
public class ProducerController {
    @Autowired
    private FeignInterface feignInterface;

    @PostMapping("/publish")
    public String publishMessage(@RequestBody Mail mail) {
        feignInterface.consume(mail);
        return "Message was sent successfully!";
    }
}
