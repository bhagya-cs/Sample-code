package edu.depaul.cdm.se452.se452demo;

import java.util.ArrayList;

import org.aspectj.apache.bcel.generic.Instruction;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DeadlockLoserDataAccessException;

import edu.depaul.cdm.se452.se452demo.concepts.relational.basic.CourseRepository;
import edu.depaul.cdm.se452.se452demo.concepts.relational.relationship.Address;
import edu.depaul.cdm.se452.se452demo.concepts.relational.relationship.AddressRepository;
import edu.depaul.cdm.se452.se452demo.concepts.relational.relationship.Instructor;
import edu.depaul.cdm.se452.se452demo.concepts.relational.relationship.InstructorRepository;
import edu.depaul.cdm.se452.se452demo.concepts.relational.relationship.School;
import edu.depaul.cdm.se452.se452demo.concepts.relational.relationship.SchoolRepository;
import edu.depaul.cdm.se452.se452demo.concepts.relational.relationship.University;
import edu.depaul.cdm.se452.se452demo.concepts.relational.relationship.UniversityRepository;
import edu.depaul.cdm.se452.se452demo.concepts.relational.relationship.UniversityService;
import lombok.val;
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
			System.out.println(env);
			log.debug("Debug");
			log.info("Info");
			log.warn("Warning");
			log.error("Error");
		};
	}

	@Bean
	public CommandLineRunner doItAllTogether(
			SchoolRepository schoolRepo,
			AddressRepository addressRepo) {
		return (args) -> {
			var kellstatAddr = new Address();
			kellstatAddr.setLocation("243 S. Wasbash");
			addressRepo.save(kellstatAddr);

			// Save school with the address
			var kellstat = new School();
			kellstat.setName("Kellstat");
			kellstat.setAddress(kellstatAddr);
			schoolRepo.save(kellstat);
		};
	}

	@Bean
	public CommandLineRunner createWithNoRelationship(
		SchoolRepository schoolRepo, 
		AddressRepository addressRepo) {
		return (args) -> {
			var underAddr = new Address();
			underAddr.setLocation("2400 W. Sheffield");
			addressRepo.save(underAddr);


			val schoolName = "Undergrad";
			var undergrad = new School();
			undergrad.setName(schoolName);
			schoolRepo.save(undergrad);
		};
	}

	@Bean
	public CommandLineRunner addRelationship(
		SchoolRepository schoolRepo, 
		AddressRepository addressRepo) {
		return (args) -> {
			val location = "2400 W. Sheffield";
			val schoolName = "Undergrad";

			var school = schoolRepo.findByName(schoolName);
			var address = addressRepo.findByLocation(location);
			school.setAddress(address);
			schoolRepo.save(school);
		};
	}

	@Bean
	public CommandLineRunner manyToManyDemo(
		InstructorRepository instructorRepo, 
		UniversityRepository uniRepo) {
		return (args) -> {
			var ken = instructorRepo.findByName("Ken");
			var james = instructorRepo.findByName("James");

			var universities = new ArrayList<University>();
			var depaul = uniRepo.findByName("DePaul");
			var loyola = uniRepo.findByName("Loyola");

			var instructors = new ArrayList<Instructor>();
			instructors.add(ken);

			depaul.setInstructors(instructors);	
			uniRepo.save(depaul);

			instructors.add(james);

			loyola.setInstructors(instructors);	
			uniRepo.save(loyola);

			log.info("Many To Many Demo");

		};
	}

	@Bean
	public CommandLineRunner uniInstructorDemo(
		UniversityService service) {
		return (args) -> {
			var depaul = service.findByName("DePaul");
			var instructors = service.findUniversityInstructors(depaul.getId());

			log.info("Many To Many Demo: DePaul instructors: " + instructors.size());

		};
	}



}
