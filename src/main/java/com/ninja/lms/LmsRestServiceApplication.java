package com.ninja.lms;

import com.ninja.lms.exception.CustomExceptionHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
//@Import(CustomExceptionHandler.class)
public class LmsRestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LmsRestServiceApplication.class, args);
	}

}
