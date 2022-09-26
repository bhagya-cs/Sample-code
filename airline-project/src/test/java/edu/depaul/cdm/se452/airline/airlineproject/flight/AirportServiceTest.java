package edu.depaul.cdm.se452.airline.airlineproject.flight;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.val;

@SpringBootTest
public class AirportServiceTest {
    @Autowired
    private AirportRepository airportRepository;
    
    @Test
    public void testAddFlight() {
        val ohare = new Airport();
        val dal = new Airport();
        
        ohare.setCode("TRD");
        ohare.setCity("Chicago");
        ohare.setState("IL");
        dal.setCode("TAL");
        dal.setCity("Dallas");
        dal.setState("TX");

        val b4 = airportRepository.count();
        airportRepository.save(ohare);
        airportRepository.save(dal);
   
        val after = airportRepository.count();

        assertEquals(b4 + 2, after);
    }
}
