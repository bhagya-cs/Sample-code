package edu.depaul.cdm.se452.airline.airlineproject.flight;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "airports", path = "airports")
public interface AirportRepository extends JpaRepository<Airport, String> {
    
}
