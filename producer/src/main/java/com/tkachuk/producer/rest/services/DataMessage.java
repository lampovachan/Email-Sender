package com.tkachuk.producer.rest.services;

import com.tkachuk.dto.Data;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

import java.util.HashMap;
import java.util.Map;

public class DataMessage implements Message<Data> {
    private final MessageHeaders headers;
    private final Data email;

    private DataMessage(Builder builder) {
        this.headers = new MessageHeaders(builder.headers);
        this.email = builder.email;
    }

    @Override
    public Data getEmail() {
        return email;
    }

    @Override
    public MessageHeaders getHeaders() {
        return headers;
    }

    static class Builder {

        private Map<String, Object> headers;
        private Data email;

        private Builder(Data email) {
            this.email = email;
            this.headers = new HashMap<>();
        }

        static Builder withEmail(Data email) {
            if (email == null) {
                throw new IllegalArgumentException();
            }
            return new Builder(email);
        }

        Message<> build() {
            return new PersonMessage(this);
        }

    }
}
