package com.kramomar.kafkakr.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaconfigTopic {
	
	@Bean
public NewTopic nuevotopic() {
	return TopicBuilder.name("nuevo-topic").build();
}
}
