package edu.depaul.cdm.se452.airline.airlineproject.passenger;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PassengerTest {
    @DisplayName("Test composition in Lombok")
    @Test
    public void testLombok() {
        Person person = new Person();
        person.setFirstName("Pat");
        person.setLastName("Sajak");
        Passenger passenger = Passenger.builder().person(person).build();

        String expectedError = "Person=(firstName=Pat, lastName=Sajak)";
        String expectedNoError = "Passenger(person=Person(firstName=Pat, lastName=Sajak))";
        assertEquals(expectedNoError, passenger.toString());       

    }    
}
