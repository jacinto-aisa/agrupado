/**
 * Main application class for the API Gateway service.
 * <p>
 * This class serves as the entry point for the Spring Boot application,
 * responsible for bootstrapping and launching the API Gateway.
 * </p>
 * 
 * @author Securitas
 * @since 2025
 */
package com.securitas.api_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

}
