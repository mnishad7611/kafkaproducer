package com.kafkaproducer.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.kafkaproducer.util.KafkaConstants;
import com.kafkaproducer.model.User;


@Configuration
public class KafkaConfiguration{


@Bean
public ProducerFactory<String, User> producerFactory(){

    Map<String, Object> configprops = new HashMap<>();
    configprops.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,KafkaConstants.HOST);
    configprops.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG  ,StringSerializer.class);
    configprops.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG , JsonSerializer.class);
    configprops.put(JsonSerializer.TYPE_MAPPINGS, "User:com.kafkaproducer.model.User");
    return new DefaultKafkaProducerFactory<>(configprops);
}


@Bean(name = "KafkaTemplate")
public KafkaTemplate<String,User> kafkaTemplate(){
    ProducerFactory<String, User> value = producerFactory();
    return new KafkaTemplate<String,User>(value);

}    
}
