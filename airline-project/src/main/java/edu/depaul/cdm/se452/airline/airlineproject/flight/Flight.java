package edu.depaul.cdm.se452.airline.airlineproject.flight;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

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
