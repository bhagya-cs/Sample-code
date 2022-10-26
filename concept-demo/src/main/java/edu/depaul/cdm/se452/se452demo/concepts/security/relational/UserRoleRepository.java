package edu.depaul.cdm.se452.se452demo.concepts.security.relational;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
        Optional<UserRole> findByName(UserRoleType name);
}