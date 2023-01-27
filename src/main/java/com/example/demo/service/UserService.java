package com.example.demo.service;

import com.example.demo.dto.UserDto;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @KafkaListener(id = "userGroup", topics = "user")
    public void createUser(UserDto userDto){
        try {
            System.out.println(userDto.getUsername());
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
