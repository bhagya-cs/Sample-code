package edu.depaul.cdm.se452.airline.airlineproject.passenger;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PersonTest {
    @DisplayName("Test simple Lombok")
    @Test
    public void testLombok() {
        Person pat = new Person();
        pat.setFirstName("Pat");
        pat.setLastName("Sajak");
        String expectedWithError = "Pat Sajak";
        String expectedNoError = "Person(firstName=Pat, lastName=Sajak)";
        assertEquals(expectedNoError, pat.toString());
    }       
}
