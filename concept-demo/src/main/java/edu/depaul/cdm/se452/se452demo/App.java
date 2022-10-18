package edu.depaul.cdm.se452.se452demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import edu.depaul.cdm.se452.se452demo.concepts.nonrelational.cache.CachedStudent;
import edu.depaul.cdm.se452.se452demo.concepts.nonrelational.cache.CachedStudentRepo;

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

	@Bean
	public CommandLineRunner showRedis(CachedStudentRepo repo) {
		return (args) -> {
			CachedStudent stu = new CachedStudent();
			stu.setName("Stu");
			repo.save(stu);
		};
	}


}
