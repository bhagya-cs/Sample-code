package edu.depaul.cdm.se452.airline.airlineproject.flight;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api/flights")
@Log4j2
public class FlightService {
    @Autowired
    private FlightRepository repo;

    @Autowired
    private AirportRepository airportRepo;

    @GetMapping
    public List<Flight> list() {
        log.traceEntry("Enter list");
        var retval = StreamSupport
                .stream(repo.findAll().spliterator(), false)
                .collect(Collectors.toList());        
        log.traceExit("Exit list", retval);        
        return retval;
    }

    @GetMapping("{code}")
    public Flight findById(@PathVariable("code") Long code)  {
        log.traceEntry("Enter find");
        var flight = repo.findById(code).orElse(new Flight());
        flight.setDestAirport(airportRepo.findById(flight.getDestinationCode()).orElse(new Airport()));
        flight.setOriginAirport(airportRepo.findById(flight.getOriginationCode()).orElse(new Airport()));
        log.traceExit("Exit find", flight);        
        return flight;
    }

    @PostMapping
    public void save(@RequestBody Flight flight) {
        log.traceEntry("enter save", flight);
        repo.save(flight);
        log.traceExit("exit save", flight);                
    }




    @DeleteMapping("{code}")
    public void delete(Long code) {
        log.traceEntry("Enter delete", code);
        repo.deleteById(code);
        log.traceExit("Exit delete");
    }
    
}
