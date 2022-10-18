package edu.depaul.cdm.se452.se452demo.concepts.nonrelational.cache;

import org.springframework.data.repository.CrudRepository;

public interface CachedStudentRepo extends CrudRepository<CachedStudent, String> {
    
}
