package com.kramomar.kafkakr.model;


import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@RedisHash("Accounts")
public class Accounts implements Serializable{
	    @Id
	    private String id;
	    private String number;
	    private double availableBalance;
	    private Date dateCreation;
}

