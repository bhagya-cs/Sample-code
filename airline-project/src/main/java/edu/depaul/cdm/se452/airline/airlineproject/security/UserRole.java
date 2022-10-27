package edu.depaul.cdm.se452.airline.airlineproject.security;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "UserRoles")
public class UserRole {
  @Id
  private Integer id;

  @Enumerated(EnumType.STRING)
  @Column(length = 20)
  private UserRoleType name;
}