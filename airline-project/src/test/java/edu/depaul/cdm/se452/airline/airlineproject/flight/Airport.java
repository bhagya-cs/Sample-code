package edu.depaul.cdm.se452.airline.airlineproject.flight;

import org.hamcrest.CoreMatchers;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

// Ensure there is no port conflict when running JUnit test
@SpringBootTest
@AutoConfigureMockMvc
public class Airport {
    private static final String URL = "/api/airports";

    @Autowired
    private AirportRepository repo;

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void getAll() throws Exception {
		// when - action
		ResultActions response = mockMvc.perform(MockMvcRequestBuilders.get(URL));


		var recordCount = (int) repo.count();
		
		// then - verify the output
		response.andExpect(MockMvcResultMatchers.status().isOk());
		response.andExpect(MockMvcResultMatchers.jsonPath("$.size()", CoreMatchers.is(recordCount)));
    }

	@Autowired
	private ObjectMapper objectMapper;

    

}
