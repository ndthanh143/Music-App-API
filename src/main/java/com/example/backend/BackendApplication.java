package com.example.backend;

import com.example.backend.model.User;
import com.example.backend.repository.UserRepository;
import com.example.backend.utils.ERole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.Arrays;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
//@SpringBootApplication
public class BackendApplication implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if(userRepository.count()==1) {
            User taiKhoan = new User("Le Hai", "haile2002@gmail.com", "123456", "034789456", Arrays.asList(ERole.ROLE_USER.name()));
            userRepository.save(taiKhoan);
        }
    }

}
