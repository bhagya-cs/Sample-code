package edu.depaul.cdm.se452.airline.airlineproject.passenger;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {    
    /*
     * Define finder for finding a passenger based on last name, name is specific due to composition
     */
    List<Passenger> findByPersonLastName(String lastName);

    List<Passenger> findByPersonLastNameLike(String partialLastName);
}
