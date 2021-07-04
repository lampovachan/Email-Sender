package com.tkachuk.producer.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tkachuk.dto.Mail;
import org.apache.kafka.common.serialization.Serializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class MailSerializer implements Serializer<Mail> {
    private Logger LOGGER = LoggerFactory.getLogger(MailSerializer.class);

    /* (non-Javadoc)
     * @see org.apache.kafka.common.serialization.Serializer#configure(java.util.Map, boolean)
     */
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        // TODO Auto-generated method stub
    }

    /* (non-Javadoc)
     * @see org.apache.kafka.common.serialization.Serializer#serialize(java.lang.String, java.lang.Object)
     */
    @Override
    public byte[] serialize(String topic, Mail data) {
        ObjectMapper mapper = new ObjectMapper();
        byte[] mail=null;
        try {
            mail = mapper.writeValueAsString(data).getBytes();
        }catch (Exception e) {
            LOGGER.error("Error in serialisation of mail object");
            e.printStackTrace();
        }
        return mail;
    }

    /* (non-Javadoc)
     * @see org.apache.kafka.common.serialization.Serializer#close()
     */
    @Override
    public void close() {
        // TODO Auto-generated method stub
    }
}
