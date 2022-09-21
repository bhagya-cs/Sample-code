package edu.depaul.cdm.se452.airline.airlineproject.flight;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api/airports")
@Log4j2
public class AirportService {
    @Autowired
    private AirportRepository repo;

    @GetMapping
    public List<Airport> list() {
        log.traceEntry("Enter list");
        var retval = repo.findAll();
        log.traceExit("Exit list", retval);        
        return repo.findAll();
    }

    @PostMapping
    public void save(@RequestBody Airport Airport) {
        log.traceEntry("enter save", Airport);
        repo.save(Airport);
        log.traceExit("exit save", Airport);                
    }


    @DeleteMapping
    public void delete(String code) {
        log.traceEntry("Enter delete", code);
        repo.deleteById(code);
        log.traceExit("Exit delete");
    }
}
