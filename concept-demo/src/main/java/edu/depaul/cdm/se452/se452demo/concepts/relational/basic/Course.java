package edu.depaul.cdm.se452.se452demo.concepts.relational.basic;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import lombok.Data;

/**
 * Minimialist code to map against database when then table/column is same as the class/property
 */
@Data
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "course dept must be set")
    @Size(min= 2,max = 4, message = "dept must be between 2 and 4 characters")
    private String dept;

    @NotBlank
    @Size(min= 2,max = 7, message = "dept num must be between 2 and 6 characters")
    private String num;

    @NotBlank
    private String description;

    @Future
    private LocalDate nextAvailableDate;

    @Email
//    @Email(regexp = ".+[@].+[\\.].+", message = "email address must contain @ and .")
//    @Email(regexp = ".+[@].+[\\.].+", message = "{email.valid}")
    private String courseContactEmail;

}