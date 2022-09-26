package edu.depaul.cdm.se452.airline.airlineproject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import edu.depaul.cdm.se452.airline.airlineproject.flight.AirportRepository;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Bean
	public CommandLineRunner doItAllTogether(
			AirportRepository repo) {
		return (args) -> {
			var airports = repo.findAll();
			var firstAirport = airports.get(0);
			firstAirport.getCity();
			var destinationFlights = firstAirport.getDestinationFlights();
			// var arrivalFlights = firstAirport.getDestinationFlights();
			System.out.println(destinationFlights.size());
		};
	}
	

}
