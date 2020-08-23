package com.github._2kays.osu.lobsterapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class LobsterApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LobsterApiApplication.class, args);
	}

}
