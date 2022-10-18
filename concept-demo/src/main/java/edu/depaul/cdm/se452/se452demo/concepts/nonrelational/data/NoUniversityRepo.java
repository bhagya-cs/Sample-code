package edu.depaul.cdm.se452.se452demo.concepts.nonrelational.data;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface NoUniversityRepo extends MongoRepository<NoUniversity, String> {
   
}
