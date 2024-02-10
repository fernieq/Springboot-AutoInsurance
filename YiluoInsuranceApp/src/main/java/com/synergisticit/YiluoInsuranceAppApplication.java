package com.synergisticit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class YiluoInsuranceAppApplication {
	
	private static ConfigurableApplicationContext context;

	public static void main(String[] args) {
		context = SpringApplication.run(YiluoInsuranceAppApplication.class, args);
	}

}
