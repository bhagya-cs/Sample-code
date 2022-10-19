package edu.depaul.cdm.se452.airline.airlineproject.flight;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    
}
