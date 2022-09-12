package edu.depaul.cdm.se452.airline.airlineproject.passenger;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

import lombok.Data;

@Data
@Embeddable
public class Person {
    private String firstName;
    private String lastName;    
}
