package com.pzfomar.springbase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * The Class SpringbaseApplication.
 */
@SpringBootApplication
@EnableJpaAuditing
public class SpringbaseApplication {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringbaseApplication.class, args);
	}

}
