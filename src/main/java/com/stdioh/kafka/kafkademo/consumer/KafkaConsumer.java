package com.stdioh.kafka.kafkademo.consumer;

import com.stdioh.kafka.kafkademo.producer.KafkaProducer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = {"my_topic", "abc"}, groupId = "my_group_id")
    public void getMessage(@Payload String message, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        System.out.println("Topic " + topic + ", Consumer Message: " + message);
    }
}
