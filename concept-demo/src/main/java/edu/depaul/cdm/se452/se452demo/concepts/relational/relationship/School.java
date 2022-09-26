package edu.depaul.cdm.se452.se452demo.concepts.relational.relationship;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.apache.commons.lang3.builder.ToStringExclude;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToOne
    private Address address;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @ToString.Exclude
    private University university;   

}
