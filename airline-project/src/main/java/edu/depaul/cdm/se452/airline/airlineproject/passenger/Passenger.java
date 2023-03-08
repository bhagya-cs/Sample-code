package edu.depaul.cdm.se452.airline.airlineproject.passenger;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

import edu.depaul.cdm.se452.airline.airlineproject.flight.Flight;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;

/**
 * Demonstrate what I learned while researching Lombok, there were more features such as 
 * @see NoArgsContructor, AllArgsConstructor and Builder which is helpful to build out classes easier
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Embedded
    private Person person;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "flight_passenger", 
      joinColumns = @JoinColumn(name = "passenger_id", referencedColumnName = "id"), 
      inverseJoinColumns = @JoinColumn(name = "flight_id", 
      referencedColumnName = "id"))
    private List<Flight> flights;
    
}