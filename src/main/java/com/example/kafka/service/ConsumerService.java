package com.example.kafka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.kafka.model.SuperHero;


@Service
public class ConsumerService {

    private final Logger logger = LoggerFactory.getLogger(getClass());


    @KafkaListener(topics = {"${spring.kafka.topic}"}, containerFactory = "kafkaListenerStringFactory", groupId = "group_id")
    public void consumeMessage(String message) {
        logger.info("**** -> Consumed message -> {}", message);
    }


    @KafkaListener(topics = {"${spring.kafka.superhero-topic}"}, containerFactory = "kafkaListenerJsonFactory", groupId = "group_id")
    public void consumeSuperHero(SuperHero superHero) {
        logger.info("**** -> Consumed Super Hero :: {}", superHero);
    }

}
