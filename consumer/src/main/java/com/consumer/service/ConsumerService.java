package com.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

            private final Logger log = LoggerFactory.getLogger(ConsumerService.class);


    @KafkaListener(topics="Producer_message",groupId = "consumerGroup")
    public void ConsumerConsumeService(String msg){

       
        log.info("response received from producer.. :   "+ msg);

        consumerSenderService("message received successfull");

    }

    private void consumerSenderService(String msg){

        kafkaTemplate.send("Consumer_Response",msg);

        log.info("response sent from consumer.. :   "+ msg);
    }
    
}
