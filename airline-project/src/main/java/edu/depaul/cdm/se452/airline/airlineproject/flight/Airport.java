package edu.depaul.cdm.se452.airline.airlineproject.flight;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString.Exclude;

@Data
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, 
                  property = "id")
public class Airport {
    @Id
    private String code;
    private String city;
    private String state; 
    
    @OneToMany(mappedBy = "origination")
    @Exclude
    private List<Flight> originationFlights;

    @OneToMany(mappedBy = "destination", fetch = FetchType.EAGER)
    @Exclude
    private List<Flight> destinationFlights;
}
