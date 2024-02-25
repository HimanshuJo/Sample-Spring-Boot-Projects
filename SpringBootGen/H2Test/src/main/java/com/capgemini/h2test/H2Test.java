package com.capgemini.h2test;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
public class H2Test{

	public static void main(String[] args) throws Exception{
		SpringApplication.run(H2Test.class, args);
	}
}