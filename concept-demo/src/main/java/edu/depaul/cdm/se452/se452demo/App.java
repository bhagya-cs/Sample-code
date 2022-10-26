package edu.depaul.cdm.se452.se452demo;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import edu.depaul.cdm.se452.se452demo.concepts.nonrelational.cache.CachedStudent;
import edu.depaul.cdm.se452.se452demo.concepts.nonrelational.cache.CachedStudentRepo;
import edu.depaul.cdm.se452.se452demo.concepts.security.relational.RegistrationService;
import edu.depaul.cdm.se452.se452demo.concepts.security.relational.SignupRequest;
import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootApplication
public class App {

	@Value("${environment}")
	private String env;

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Bean
	public CommandLineRunner showLogLevel() {
		return (args) -> {
			log.info(env);
			log.debug("Debug");
			log.info("Info");
			log.warn("Warning");
			log.error("Error");
		};
	}

//	@Bean
	public CommandLineRunner addUser(RegistrationService register) {
		return (args) -> {
			var request = new SignupRequest();
			request.setUsername("sql-user");
			request.setPassword("password");
			request.setEmail("sql-user@depaul.edu");
			var roles = new HashSet<String>();
			roles.add("ADMIN");
			request.setRole(roles);
			register.registerUser(request);
		};
	}


}
