package com.empresa.course.config;

import com.empresa.course.entities.User;
import com.empresa.course.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    private UserRepository userRepository;

    public TestConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User(null, "Maria Brown", "maria@gmail.com", "32523523", "123456");
        User user2 = new User(null, "Alex Green", "alex@gmail.com", "21423522", "123456");

        userRepository.saveAll(Arrays.asList(user1, user2));
    }
}
