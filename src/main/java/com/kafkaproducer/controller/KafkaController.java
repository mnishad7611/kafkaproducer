package com.kafkaproducer.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kafkaproducer.service.KafkaService;
import com.kafkaproducer.model.User;

@RestController
public class KafkaController {

    @Autowired
    private KafkaService kafkaservice;

    @PostMapping(value = "/createUser"
    // consumes = {
    //     MediaType.APPLICATION_JSON_VALUE,
    //     MediaType.APPLICATION_XML_VALUE
    // }
    )
    public String createUsers(@RequestBody List<User> userlists){
        return kafkaservice.createUserDetails(userlists);
    }

    @GetMapping(value = "/getUser")
    public String getUsers(){
        List<User> userlists = new ArrayList<>();
        User user = new User();
        user.setUserId("102");   
        userlists.add(user);
        return kafkaservice.createUserDetails(userlists);
    }
    
}
