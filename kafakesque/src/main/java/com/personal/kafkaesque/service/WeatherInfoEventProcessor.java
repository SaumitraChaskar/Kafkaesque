package com.personal.kafkaesque.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.personal.kafkaesque.event.WeatherInfoEvent;
import com.personal.kafkaesque.event.WeatherInfoEventListener;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class WeatherInfoEventProcessor {

     private final Logger logger = LoggerFactory.getLogger(getClass());
     private WeatherInfoEventListener listener;

     public void register(WeatherInfoEventListener listener) {
          this.listener = listener;
     }

     public void onEvent(WeatherInfoEvent event) {
          if (listener != null) {
               listener.onData(event);
          }
      }

     public void onComplete() {
         if (listener != null) {
              listener.processComplete();
         }
     }

     @KafkaListener(topics = "new_weather", groupId = "group_id")
     public void consume(WeatherInfoEvent message) throws IOException {
          logger.info(String.format("#### -> Consumed message -> %s", message));
          onEvent(message);
     }
}
