package com.stdioh.kafka.kafkademo.controller;

import com.stdioh.kafka.kafkademo.producer.KafkaProducer;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController

public class KafkController {
    @Autowired
    private KafkaProducer kafkaProducer;
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Message published"),
    })
    @ApiOperation(value = "Publish message on Kafka")
    @GetMapping("publish/{message}")
    public ResponseEntity writeMessageToTopic(@PathVariable("message") String message, @RequestParam(value = "topic", defaultValue = "my_topic") String topic) {
        kafkaProducer.writeMessage(message, topic);
        return ResponseEntity.ok("Message successfully sent to topic " + topic);
    }

    @GetMapping("/")
    public ResponseEntity get(){
        return ResponseEntity.ok("ok");
    }

}
