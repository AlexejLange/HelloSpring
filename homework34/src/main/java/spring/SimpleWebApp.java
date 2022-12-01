package spring;

/**
 * Spring Boot (Spring Boot + h2 database + tests)
 * @author Alexej Lange
 * @version 29 Nov 2022
 *
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimpleWebApp {

	public static void main(String[] args) {
		SpringApplication.run(SimpleWebApp.class, args);
	}
}
