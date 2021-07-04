package com.tkachuk.producer;

import com.tkachuk.producer.kafka.MessageProducer;
import com.tkachuk.producer.rest.services.ApiService;
import com.tkachuk.producer.rest.services.ApiServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ProducerApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ProducerApplication.class, args);

        MessageProducer producer = context.getBean(MessageProducer.class);
        ApiService service = context.getBean(ApiServiceImpl.class);

        service.getData(3).forEach(producer::sendMessage);
    }

}
