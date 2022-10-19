package edu.depaul.cdm.se452.airline.airlineproject.flight;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;


import lombok.Data;

@Data
@RedisHash
public class Airport {
    @Id
    private String code;
    private String city;
    private String state; 
}
