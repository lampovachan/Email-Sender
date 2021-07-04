package com.tkachuk.producer.rest.services;

import com.tkachuk.dto.Data;
import org.springframework.messaging.Message;

final class MessageGenerator {
    private MessageGenerator() {
        throw new UnsupportedOperationException();
    }

    static Message<Data> generateData() {
        Data data = new Data(
                randomEmail()
        );
        return DataMessage.Builder
                .withEmail(email)
                .build();
    }
}
