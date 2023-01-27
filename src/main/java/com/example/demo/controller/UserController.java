package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaSendCallback;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/user")
public class UserController {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @PostMapping(value = "")
    public ResponseEntity<Object> createUser() {

        UserDto userDto = new UserDto();
        userDto.setUsername("dohv-1");
        userDto.setAddress("Thuong Tin, Ha Noi");


        for (int i = 0; i < 100; i++) {

            kafkaTemplate.send("user", userDto).addCallback(new ListenableFutureCallback<>() {
                @Override
                public void onFailure(Throwable ex) {
                    ex.printStackTrace();
                }

                @Override
                public void onSuccess(SendResult<String, Object> result) {
                    System.out.println(result.getProducerRecord().topic());
                }
            });
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
