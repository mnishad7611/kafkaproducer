package com.kafkaproducer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.kafkaproducer.model.User;
import com.kafkaproducer.util.KafkaConstants;

@Service
public class KafkaService {

    @Autowired
    private KafkaTemplate<String,User> kafkTemplate;

    public String createUserDetails(List<User> users){
        if(!users.isEmpty()){
            for (User c : users) {
                kafkTemplate.send(KafkaConstants.TOPIC, c);       // (topic, obj)    
            }
        }
       
        return " User Record added to Kafka Server Successfully !!";

    }
    
}




// Important Point :
// Kafka.send :-  to send the data to the particular topic 
// @KafkaListener : used to get the data from the particular topic