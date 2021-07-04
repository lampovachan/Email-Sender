package com.tkachuk.producer;

import com.tkachuk.dto.Mail;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.Random;


/**
 * This class describes the process of writing data to Kafka.
 */
@Slf4j
@NoArgsConstructor
@Component
public class MessageProducer {
    private Logger LOGGER = LoggerFactory.getLogger(MessageProducer.class);

    @Autowired
    private KafkaTemplate<String, Mail> messageKafkaTemplate;

    @Value(value = "${kafka.mail.topic.name}")
    private String topicName;

    public void sendMessage(Mail message) {
        ListenableFuture<SendResult<String, Mail>> future = messageKafkaTemplate.send(topicName, new Random().nextLong() + "", message);
        future.addCallback(new ListenableFutureCallback<SendResult<String, Mail>>() {

            @Override
            public void onSuccess(SendResult<String, Mail> result) {
                LOGGER.info("Sent message=[" + message + "] with offset=[" + result.getRecordMetadata().offset() + "]");
            }

            @Override
            public void onFailure(Throwable ex) {
                LOGGER.info("Unable to send message=[" + message + "] due to : " + ex.getMessage());
            }
        });
    }
}
