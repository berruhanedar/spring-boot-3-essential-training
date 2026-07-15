package com.berru.room_web_app;

import com.berru.room_web_app.repository.RoomRepository;
import org.springframework.beans.factory.BeanRegistrarDslMarker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RoomWebAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(RoomWebAppApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(RoomRepository roomRepository) {
        return args -> {
            roomRepository.findAll().forEach(System.out::println);
        };
    }

}
