package com.example.kafkademo.kafkacontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.kafkademo.message.repository.MessageRepository;
import com.example.kafkademo.sender.MessageProducer;

@Controller
public class KafkaDemoRestController {

      @Autowired
      private MessageProducer producer;

      @Autowired
      private MessageRepository messageRepo;

      //Send message to kafka
      @GetMapping("/send")
      public String sendMsg(
      @RequestParam("msg") String message) {
          producer.sendMessage(message);
          return "" +"'+message +'" + " sent successfully!";
      }

      //Read all messages
      @GetMapping("/getAll")
      public String getAllMessages() {
         return messageRepo.getAllMessages() ;
      }
}
