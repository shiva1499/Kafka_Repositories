package com.consumer.Configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfiguratoin {
 
    
 @Bean
    public NewTopic kafkaTopic() {
        return TopicBuilder
                .name("Consumer_Response")
                .build();
    }

}
