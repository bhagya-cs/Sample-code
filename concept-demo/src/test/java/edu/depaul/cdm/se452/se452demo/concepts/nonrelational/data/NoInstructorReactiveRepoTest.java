package edu.depaul.cdm.se452.se452demo.concepts.nonrelational.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import jakarta.annotation.Resource;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
public class NoInstructorReactiveRepoTest {
    @Resource
    private NoInstructorReactiveRepo repo;

    private NoInstructor instructor;

    private static String NAME = "Bill";

    @BeforeEach
    private void generateName() {
        instructor = new NoInstructor();
        instructor.setName(NAME);

        // Not ideal way to test but gurantees no lingering data
        repo.deleteAll().block();
    }


    @Test
    public void givenValue_whenFindAllByValue_thenFindAccount() {
        repo.save(instructor).block();
        Flux<NoInstructor> instructorFlux = repo.findByName("Bill");
    
        StepVerifier
          .create(instructorFlux)
          .assertNext(inst -> {
              assertEquals(NAME, inst.getName());
              assertNotNull(inst.getId());
          })
          .expectComplete()
          .verify();
    }
    
    
    @Test
    public void givenAccount_whenSave_thenSaveAccount() {
        Mono<NoInstructor> instructorMono = repo.save(instructor);
    
        StepVerifier
          .create(instructorMono)
          .assertNext(inst -> assertNotNull(inst.getId()))
          .expectComplete()
          .verify();
    }    
}
