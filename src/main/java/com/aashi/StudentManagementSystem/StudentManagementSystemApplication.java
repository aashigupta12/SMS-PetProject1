package com.aashi.StudentManagementSystem;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StudentManagementSystemApplication{

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
		System.out.println("hi");
	}

	/**
	 * This will store the manually created object as a bean in spring container
	 * */
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
}
