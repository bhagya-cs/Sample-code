package edu.depaul.cdm.se452.se452demo.concepts.security.jwt;

import jakarta.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class LoginRequest {
    @NotBlank
	private String username;

	@NotBlank
	private String password;    
}
