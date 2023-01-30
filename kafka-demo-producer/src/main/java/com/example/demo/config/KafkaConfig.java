package com.example.demo.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.converter.JsonMessageConverter;

@Configuration
public class KafkaConfig {

    @Bean
    NewTopic user (){
        return new NewTopic("user", 1, (short) 3);
    }

    @Bean
    JsonMessageConverter jsonMessageConverter(){
        return new JsonMessageConverter();
    }

}
