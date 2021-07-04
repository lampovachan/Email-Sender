package com.tkachuk.producer.kafka.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

/**
 * This class contains Kafka configuration for topics.
 */

@ConfigurationProperties(prefix = "kafka")
public class KafkaProducerProperties {
    private String bootstrapServers;
    private Topics topics;

    public void setBootstrapServers(String bootstrapServers) {
        this.bootstrapServers = bootstrapServers;
    }

    public String getBootstrapServers() {
        return bootstrapServers;
    }

    public Topics getTopics() {
        return topics;
    }

    public void setTopics(Topics topics) {
        this.topics = topics;
    }

    public static class Topics {

        private String create;

        public String getCreate() {
            return create;
        }

        public void setCreate(String create) {
            this.create = create;
        }
    }
}
