package edu.depaul.cdm.se452.se452demo.concepts.nonrelational.data;
import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import reactor.core.publisher.Flux;

public interface NoInstructorReactiveRepo extends ReactiveMongoRepository<NoInstructor, String> {
    @Query("{ 'skills': { $all: ?0 } }")
    Flux<NoInstructor> findBySkillsAll(List<String> skills);

    Flux<NoInstructor> findBySkillsIn(List<String> skills);    

    Flux<NoInstructor> findByName(String name);
}
