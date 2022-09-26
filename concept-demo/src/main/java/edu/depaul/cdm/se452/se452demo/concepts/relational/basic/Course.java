package edu.depaul.cdm.se452.se452demo.concepts.relational.basic;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

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

}