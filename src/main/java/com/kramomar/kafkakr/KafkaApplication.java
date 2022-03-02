package com.kramomar.kafkakr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaApplication.class, args);
	}
	
	/*@Bean
	CommandLineRunner commandLineRunner(KafkaTemplate<String,String> kafkaTemplate) {
		return args -> {
			kafkaTemplate.send("nuevo-topic", "MENSAJE DESDE KAFKAAAAAA ::: AAAA");
		};
	}*/

}
