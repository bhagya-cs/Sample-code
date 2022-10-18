package edu.depaul.cdm.se452.se452demo.concepts.nonrelational.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NoInstructorRepoTest {
    @Autowired
    private NoInstructorRepo repo;
    
    @Test
    public void testList() {
        assertNotEquals(0, repo.count());
    }

    @Test
    public void testSave() {
        var b4 = repo.count();
        var ins1 = new NoInstructor();
        ins1.setName("Davey Crocket");
        repo.save(ins1);

        var after = repo.count();
        assertEquals(b4 + 1, after);
    }
}
