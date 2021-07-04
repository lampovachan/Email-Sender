package com.tkachuk.producer.kafka.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.std.StringSerializer;
import com.tkachuk.producer.kafka.MessageProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.messaging.Message;

import java.util.HashMap;
import java.util.Map;

/**
 * This class contains Kafka configuration.
 */

@Configuration
public class KafkaProducerConfig {
    @Value(value = "${kafka.bootstrapAddress}")
    private String bootstrapAddress;

    /**
     * Producer factory bean creaion
     * @return ProducerFactory bean
     */
    @Bean
    public ProducerFactory<String, Mail> mailProducerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, MailSerializer.class);
        return new DefaultKafkaProducerFactory<>(configProps);
    }

    /**
     * @return KafkaMailProducer bean
     */
    @Bean
    public MessageProducer messageProducer() {
        return new MessageProducer();
    }

    /**
     * @return kafka template used by producer to access kafka topics
     */
    @Bean
    public KafkaTemplate<String, Mail> mailKafkaTemplate() {
        return new KafkaTemplate<String, Mail>(mailProducerFactory());
    }
}
