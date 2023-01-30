package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.converter.JsonMessageConverter;

@Configuration
public class KafkaConfig {

    // Global DeadLetter topic config
//    @Bean
//    DefaultErrorHandler defaultErrorHandler(KafkaOperations<String, Object> kafkaOperations){
//        return new DefaultErrorHandler(new DeadLetterPublishingRecoverer(kafkaOperations), new FixedBackOff(1000L, 2));
//    }

    @Bean
    JsonMessageConverter jsonMessageConverter(){
        return new JsonMessageConverter();
    }


}
