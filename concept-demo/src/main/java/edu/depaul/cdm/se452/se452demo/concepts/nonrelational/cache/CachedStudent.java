package edu.depaul.cdm.se452.se452demo.concepts.nonrelational.cache;

import java.io.Serializable;

import jakarta.persistence.Entity;

import org.springframework.data.redis.core.RedisHash;

import lombok.Data;

// Time to live in seconds and so 3600 is 1 hour
@Data
@RedisHash(timeToLive = 3600)
public class CachedStudent implements Serializable {
    private String id;
    private String name;    
}
