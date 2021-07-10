package com.stdioh.kafka.kafkademo.producer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    public static final String TOPIC = "my_topic";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void writeMessage(String message, String topic) {
        if(topic == null) topic = TOPIC;
        System.out.println("Topic " + topic + ", Producer Message: " + message);
        kafkaTemplate.send(topic, message);
    }
}
