package com.company.kafka.listener;

import org.springframework.stereotype.Component;

@Component
public class KafkaListener {
    @org.springframework.kafka.annotation.KafkaListener(topics = "kafkaTopic", groupId = "groupId")
    void listener(String data) {
        System.out.printf("Data received : %s %s%n", data,"😃" );
    }
}
