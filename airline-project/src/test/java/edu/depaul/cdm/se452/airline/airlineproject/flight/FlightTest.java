package edu.depaul.cdm.se452.airline.airlineproject.flight;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.val;

@SpringBootTest
public class FlightTest {
    @Autowired
    private AirportRepository airportRepository;
    
    @Test
    public void testAddFlight() {
        val ohare = new Airport("ORD", "Chicago", "IL");
        val dal = new Airport("DAL", "Dallas", "TX");
        
        val b4 = airportRepository.count();
        airportRepository.save(ohare);
        airportRepository.save(dal);
   
        val after = airportRepository.count();

        assertEquals(b4 + 2, after);
    }
}
