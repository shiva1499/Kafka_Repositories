package com.producer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class KafkaProducerService {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

        private final Logger log = LoggerFactory.getLogger(KafkaProducerService.class);


    public void producerSenderService(String msg){
        kafkaTemplate.send("Producer_message",msg);
        log.info("message sended...:  "+msg); 
    }

    @KafkaListener(topics="Consumer_Response",groupId = "producerGroup")
    public void ConsumerConsumeService(String msg){

        log.info(msg); 
    }
    
}
