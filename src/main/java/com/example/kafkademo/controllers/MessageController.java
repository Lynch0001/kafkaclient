package com.example.kafkademo.controllers;

import com.example.kafkademo.domain.Message;
import com.example.kafkademo.services.MessageProducerService;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/message")
@RestController
public class MessageController {

  @Autowired
  private final MessageProducerService messageProducerService;

  public MessageController(MessageProducerService messageProducerService) {
    this.messageProducerService = messageProducerService;
  }

  @PostMapping
  public ResponseEntity<?> createMessage(@RequestBody Message message) throws ExecutionException, InterruptedException {
    messageProducerService.sendCreateMessageEvent(message);
    return new ResponseEntity<>(HttpStatus.OK);
  }

}
