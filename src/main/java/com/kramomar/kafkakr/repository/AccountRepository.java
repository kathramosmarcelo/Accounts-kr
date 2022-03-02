package com.kramomar.kafkakr.repository;

import org.springframework.data.redis.core.ReactiveHashOperations;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Component;

import com.kramomar.kafkakr.model.Accounts;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Component
public class AccountRepository {
		private final ReactiveRedisOperations<String, Accounts> redisOperations;
		  private final ReactiveHashOperations<String,String, Accounts> hashOperations;

		  public static final String KEY = "Accounts";
		  public AccountRepository(ReactiveRedisOperations<String, Accounts> redisOperations) {
		    this.redisOperations = redisOperations;
		    this.hashOperations = redisOperations.opsForHash();
		  }
		  
		  public Flux<Accounts> findall(){
			  return hashOperations.values(KEY);
		  }
		
		  
		  public Mono<Accounts> save(Accounts accounts){
			return hashOperations.put(KEY, accounts.getId(), accounts).map(isSaved -> accounts);
		  }
		  
		    public Mono<Accounts> save_user(Accounts accounts) {
		        hashOperations.put(KEY, accounts.getId(), accounts);
		        return save(accounts);
		    
}
}
