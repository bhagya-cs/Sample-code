package edu.depaul.cdm.se452.se452demo.concepts.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.depaul.cdm.se452.se452demo.concepts.nonrelational.data.NoInstructor;
import edu.depaul.cdm.se452.se452demo.concepts.nonrelational.data.NoInstructorRepo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api/noinstructor")
@Tag(name = "NoInstructor", description = "Everything about your Instructor")
@Log4j2
public class NoInstructorService {
    @Autowired
    private NoInstructorRepo repo;

    @GetMapping
    @Operation(summary = "Returns all the instructors")
    @ApiResponse(responseCode = "200", description = "valid response", 
        content = {@Content(mediaType="application/json", schema=@Schema(implementation=NoInstructor.class))})
    public List<NoInstructor> list() {
        log.traceEntry("Enter list");
        var retval = repo.findAll();
        log.traceExit("Exit list", retval);        
        return retval;
    }

    @PostMapping
    @Operation(summary = "Save the instructor and returns the  id")
    public String save(NoInstructor instructor) {
        instructor = repo.findById(instructor.getId()).orElse(new NoInstructor());

        log.traceEntry("enter save", instructor);
        repo.save(instructor);
        log.traceExit("exit save", instructor);        
        return instructor.getId();
    }

    @DeleteMapping
    @Operation(summary = "Remove the instructor")
    public void remove(String id) {
        log.traceEntry("Enter remove", id);
        repo.deleteById(id);
        log.traceExit("Exit remove");
    }

    
}
