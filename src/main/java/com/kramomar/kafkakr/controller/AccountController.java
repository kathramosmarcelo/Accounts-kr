package com.kramomar.kafkakr.controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kramomar.kafkakr.model.Accounts;
import com.kramomar.kafkakr.repository.AccountRepository;
import com.kramomar.kafkakr.service.AccountService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/kafka")
public class AccountController {

	private final AccountService accountservice;
	
	private final AccountRepository accountrepository;
	
	@GetMapping("/mensaje/{sms}")
	public String mimsg(@PathVariable String sms) {
		return accountservice.getsms(sms);
	}
	

	/*
	@PostMapping("/mensaj/{sms}")
	public String mims(@PathVariable   Accounts accounts) {
		return accountservice.getsms(sms);
	}*/
	
	@GetMapping("/getall")
	public Flux<Accounts> all() {
	return accountrepository.findall();
	}
	    
	 
	@PostMapping
	Mono<Accounts> createUser(@RequestBody Accounts accounts) {
	return accountrepository.save(accounts);
	}
	
}
