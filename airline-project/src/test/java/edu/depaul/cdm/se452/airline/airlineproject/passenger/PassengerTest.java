package edu.depaul.cdm.se452.airline.airlineproject.passenger;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles("test")
public class PassengerTest {
    @DisplayName("Test composition in Lombok")
    @Test
    public void testLombok() {
        Person person = new Person();
        person.setFirstName("Pat");
        person.setLastName("Sajak");
        Passenger passenger = Passenger.builder().person(person).build();

        String expectedError = "Person=(firstName=Pat, lastName=Sajak)";
        String expectedNoError = "Passenger(id=0, person=Person(firstName=Pat, lastName=Sajak))";
        assertEquals(expectedNoError, passenger.toString());       

    }    


    @Autowired
    private PassengerRepository passengerRepo;
    
    @DisplayName("Test adding flights")
    @Test
    public void testAddingPassengerAsComposition() {
        var person = new Person();
        person.setFirstName("Pat");
        person.setLastName("Sajak");
        var passenger = Passenger.builder().person(person).build();

        var b4Add = passengerRepo.count();
        passengerRepo.save(passenger);
        var afterAdd = passengerRepo.count();

        assertEquals(b4Add + 1, afterAdd);                

        var passengerList = passengerRepo.findByPersonLastName("Sajak");
        assertEquals(1, passengerList.size());
    }    
}
