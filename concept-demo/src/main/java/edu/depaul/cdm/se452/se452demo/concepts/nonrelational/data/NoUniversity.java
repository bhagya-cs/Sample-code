package edu.depaul.cdm.se452.se452demo.concepts.nonrelational.data;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class NoUniversity {
    @Id
    private String id;

    private String name;

    @DBRef
    private NoInstructor chair;
}
