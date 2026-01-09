package com.aurelius.tech.servicea;

import com.aurelius.tech.servicea.Repository.UserRepository;
import com.aurelius.tech.servicea.entity.UserEntity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServiceAApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceAApplication.class, args);
    }

    @Bean
    CommandLineRunner run(UserRepository repo) {
        return args -> {
            UserEntity u = new UserEntity();
            u.setName("Dilan");
            u.setEmail("dilan@example.com");
            repo.save(u);

            System.out.println(repo.findAll().get(0).getName());
        };
    }

}
