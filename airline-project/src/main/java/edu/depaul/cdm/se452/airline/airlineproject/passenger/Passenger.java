package edu.depaul.cdm.se452.airline.airlineproject.passenger;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Demonstrate what I learned while researching Lombok, there were more features such as 
 * @see NoArgsContructor, AllArgsConstructor and Builder which is helpful to build out classes easier
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Passenger {
    private Person person;
}
