package com.company.kafka;

import com.company.kafka.domain.User;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.UUID;

@SpringBootApplication
public class KafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkaTemplate) {
        return args -> {
            for (int i=0;i<10;i++){
                User build = User.builder()
                        .id(UUID.randomUUID().toString())
                        .firstName("name"+i)
                        .lastName("last"+i)
                        .email("email"+i)
                        .password("password"+i)
                        .build();
                kafkaTemplate.send("kafkaTopic", build.toString());
            }
        };
    }

}
