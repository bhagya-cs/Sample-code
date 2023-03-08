package edu.depaul.cdm.se452.se452demo.concepts.relational.basic;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

/**
 * Additional setup with mapping between code and table/columns when they do not match  class/property
 */
@Data
@Entity
@Table(name = "Students")
@Builder
@AllArgsConstructor
@NoArgsConstructor
// @Jacksonized
public class Student {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "stu_id")
	private String studentId;

	@Column(name = "nm")
	private String name;

	@Email(regexp = ".+[@].+[\\.].+")
	private String email;

	@Min(value = 10, message = "Should be older than 10")
	// @Max(value = 30, message = "Should be younger than 30")	
	private long age;
	private Date admittedDate;
}