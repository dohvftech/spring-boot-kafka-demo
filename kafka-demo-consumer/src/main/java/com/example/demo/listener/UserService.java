package com.example.demo.listener;

import com.example.demo.dto.UserDto;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @RetryableTopic(attempts = "5",backoff = @Backoff(delay = 2000, multiplier = 2))
    @KafkaListener(groupId = "userGroup-1", topics = "user", id = "createUser_1")
    public void createUser_1(UserDto userDto){
        try {
            System.out.println("id "+ 1);
            System.out.println(userDto.getUsername());
        }catch (Exception e){
            e.printStackTrace();
        }
        throw new RuntimeException();

    }

    @KafkaListener(groupId = "userGroup-1", topics = "user", id = "createUser_2")
    public void createUser_2(UserDto userDto){
        try {
            System.out.println("id "+ 2);
            System.out.println(userDto.getUsername());
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @KafkaListener(groupId = "userGroup-1", topics = "user", id = "createUser_3")
    public void createUser_3(UserDto userDto){
        try {
            System.out.println("id "+ 3);
            System.out.println(userDto.getUsername());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @KafkaListener(groupId = "dltGroup-1", topics = "user-dlt", id = "userDlt")
    public void deadLetterTopic(UserDto userDto){
        try {
            System.out.println("userDlt  receive " + userDto.getAddress());
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}
