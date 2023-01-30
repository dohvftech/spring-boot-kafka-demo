package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
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

        kafkaTemplate.send("user", userDto);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
