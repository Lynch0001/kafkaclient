package com.example.kafkademo.services;

import com.example.kafkademo.domain.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumerService {

  private static final Logger log = LoggerFactory.getLogger(MessageConsumerService.class);

  @KafkaListener(topics = "${spring.kafka.message.topic.consume}", containerFactory="NotificationContainerFactory")
  public void createMessageListener(@Payload Message message, Acknowledgment ack) {
    log.info("Notification service received message {} ", message);
    ack.acknowledge();
  }
}
