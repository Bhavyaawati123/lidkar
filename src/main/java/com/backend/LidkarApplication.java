package com.backend;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LidkarApplication {

	public static void main(String[] args) {

		SpringApplication.run(LidkarApplication.class, args);
	}
	@Bean
	public ModelMapper modelMapper(){


		return new ModelMapper();
	}

}
