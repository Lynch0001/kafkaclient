package com.example.kafkademo.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class Message {

  @Getter
  @Setter
  private String messageID;

  @Getter
  @Setter
  private Date dateOfCreation;

  @Getter
  @Setter
  private String content;

}
