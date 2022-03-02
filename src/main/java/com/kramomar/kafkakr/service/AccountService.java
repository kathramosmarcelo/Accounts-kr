package com.kramomar.kafkakr.service;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.kramomar.kafkakr.model.Accounts;
import com.kramomar.kafkakr.util.NameTopic;

@Service
public class AccountService {

	@Autowired
	public  KafkaTemplate<String, Accounts> kafkaTemplate;
	
	
	public String getsms( String sms) {
	    kafkaTemplate.send(NameTopic.NAMETOPIC, new Accounts("ACC-001",sms , 12000L,new Date()));
	    return "Connecting Successfully :)";
	}

	public Accounts publishEventAccounts(Accounts accounts){
	    kafkaTemplate.send(NameTopic.NAMETOPIC,accounts);
	    return accounts;
	}
	
	
	
	
	
	
	
}
