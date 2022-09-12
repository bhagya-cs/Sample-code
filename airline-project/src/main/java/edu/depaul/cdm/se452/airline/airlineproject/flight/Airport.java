package edu.depaul.cdm.se452.airline.airlineproject.flight;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Airport {
    @Id
    private String code;
    private String city;
    private String state;    
}
