package com.tkachuk.producer.controller;

import com.tkachuk.dto.Mail;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "consumer", url = "localhost:9091/rest/consumer")
public interface FeignInterface {
    @PostMapping("/receive")
    public void consume(@RequestBody Mail mail);
}
