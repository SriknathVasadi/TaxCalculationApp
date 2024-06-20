package com.test.tax.cal.taxcaliculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;


@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Employees Tax Cal API", version = "2.0", description = "Employees Tax Cal Information"))
public class TaxcaliculatorApp {

	public static void main(String[] args) {
		SpringApplication.run(TaxcaliculatorApp.class, args);
	}

}