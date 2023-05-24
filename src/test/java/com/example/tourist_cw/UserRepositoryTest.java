package com.example.tourist_cw;



import com.example.tourist_cw.entities.Adopter;
import com.example.tourist_cw.repo.UserRep;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    private UserRep userRepository;

    @Test
    @DisplayName("UserRepository saving test")
    public void findByUsernameTest1(){
        Adopter adopter = new Adopter();
        adopter.setUsername("TESTUSER");
        adopter.setPassword("TESTPASS");
        adopter.setRepeated("TESTPASS");

        userRepository.save(adopter);

        Assertions.assertEquals("TESTUSER", userRepository.findByUsername("TESTUSER").getUsername());
    }

    @Test
    @DisplayName("UserRepository update test")
    public void findByUsernameTest2(){
        Adopter adopter = new Adopter();

        adopter.setUsername("TESTUSER");
        adopter.setPassword("pass1");
        adopter.setRepeated("pass1");

        userRepository.save(adopter);

        adopter.setPassword("pass2");
        adopter.setRepeated("pass2");

        userRepository.save(adopter);

        Assertions.assertEquals("pass2", userRepository.findByUsername("TESTUSER").getPassword());

        userRepository.delete(adopter);
    }
}

