package edu.depaul.cdm.se452.se452demo.concepts.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.depaul.cdm.se452.se452demo.concepts.nonrelational.cache.CachedStudent;
import edu.depaul.cdm.se452.se452demo.concepts.nonrelational.cache.CachedStudentRepo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api/cached-student")
@Tag(name = "CachedStudent", description = "Everything about your ")
@Log4j2
public class CachedStudentService {
    @Autowired
    private CachedStudentRepo repo;

    @GetMapping
    @Operation(summary = "Returns all the students")
    @ApiResponse(responseCode = "200", description = "valid response", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = CachedStudent.class)) })
    public List<CachedStudent> list() {
        log.traceEntry("Enter list");
        var retval = StreamSupport
                .stream(repo.findAll().spliterator(), false)
                .collect(Collectors.toList());
        log.traceExit("Exit list", retval);
        return retval;
    }

    @PostMapping
    @Operation(summary = "Save the student and returns the  id")
    public String save(CachedStudent student) {
        log.traceEntry("enter save", student);

        // If the id is empty then it is a new student so save what was passed and let the database generate the id
        var id = student.getId();
        if (id.isEmpty()) {
            repo.save(student);
        } else {
            // If the id is not empty then it is an update so update the value
            var lookedUpStudent = repo.findById(id).orElse(new CachedStudent());
            if (lookedUpStudent.getId().equals(id)) {
                lookedUpStudent.setName(student.getName());
                repo.save(lookedUpStudent);
            } else {
                // However, there is a chance that the id was incorrect and if so then create a new student
                repo.save(student);
            }
        }
        log.traceExit("exit save", student);
        return student.getId();
    }

    @DeleteMapping
    @Operation(summary = "Remove the student")
    public void remove(String id) {
        log.traceEntry("Enter remove", id);
        repo.deleteById(id);
        log.traceExit("Exit remove");
    }

}
