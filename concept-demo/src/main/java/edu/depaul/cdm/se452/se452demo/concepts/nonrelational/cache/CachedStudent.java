package edu.depaul.cdm.se452.se452demo.concepts.nonrelational.cache;

import java.io.Serializable;

import javax.persistence.Entity;

import org.springframework.data.redis.core.RedisHash;

import lombok.Data;

@Data
@RedisHash
public class CachedStudent implements Serializable {
    private String id;
    private String name;    
}
