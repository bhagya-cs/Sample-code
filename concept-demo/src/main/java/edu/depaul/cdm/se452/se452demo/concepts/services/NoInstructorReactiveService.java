package edu.depaul.cdm.se452.se452demo.concepts.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.depaul.cdm.se452.se452demo.concepts.nonrelational.data.NoInstructor;
import edu.depaul.cdm.se452.se452demo.concepts.nonrelational.data.NoInstructorReactiveRepo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/reactive-instructor")
@Tag(name = "ReactiveInstructor", description = "Everything about your Instructor in Reactive way")
@Log4j2
public class NoInstructorReactiveService {
    @Autowired
    private NoInstructorReactiveRepo repo;

    @GetMapping
    @Operation(summary = "Returns all the instructors")
    @ApiResponse(responseCode = "200", description = "valid response", 
        content = {@Content(mediaType="application/json", schema=@Schema(implementation=NoInstructor.class))})
    public Flux<NoInstructor> list() {
        log.traceEntry("Enter list");
        var retval = repo.findAll();
        log.traceExit("Exit list", retval);        
        return retval;
    }
    
}
