package edu.depaul.cdm.se452.airline.airlineproject.flight;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import edu.depaul.cdm.se452.airline.airlineproject.passenger.Passenger;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDate departureDate;

    private LocalTime departureTime;

    @ManyToOne
    private Airport origination;

    @ManyToOne
    private Airport destination;

    @ManyToMany
    @JoinTable(name = "flight_passenger", 
      joinColumns = @JoinColumn(name = "flight_id", referencedColumnName = "id"), 
      inverseJoinColumns = @JoinColumn(name = "passenger_id", 
      referencedColumnName = "id"))    
    private List<Passenger> passengers;
    
}
