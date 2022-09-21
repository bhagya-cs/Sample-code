package edu.depaul.cdm.se452.airline.airlineproject.passenger;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
}