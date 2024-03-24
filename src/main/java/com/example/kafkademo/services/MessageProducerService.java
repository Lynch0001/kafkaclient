package com.example.kafkademo.services;

import com.example.kafkademo.domain.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class MessageProducerService {

  private static final Logger log = LoggerFactory.getLogger(MessageProducerService.class);

  private final KafkaTemplate<String, Message> createMessageKafkaTemplate;

  private final String createMessageTopic;

  public MessageProducerService(KafkaTemplate<String, Message> createMessageKafkaTemplate,
                                @Value("${spring.kafka.message.topic.produce}") String createMessageTopic) {
    this.createMessageKafkaTemplate = createMessageKafkaTemplate;
    this.createMessageTopic = createMessageTopic;
  }

  public boolean sendCreateMessageEvent(Message Message) throws ExecutionException, InterruptedException {
    SendResult<String, Message> sendResult = createMessageKafkaTemplate.send(createMessageTopic, Message).get();
    log.info("Create Message {} event sent via Kafka", Message);
    log.info(sendResult.toString());
    return true;
  }
}
