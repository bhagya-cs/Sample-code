package edu.depaul.cdm.se452.airline.airlineproject.passenger;

import java.util.List;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

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
    @GeneratedValue
    private long id;

    @Embedded
    private Person person;
}