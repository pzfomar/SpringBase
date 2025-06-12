package com.pzfomar.springbase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.pzfomar.springbase.service.GenerateSqlService;

/**
 * The Class SpringbaseApplication.
 */
@SpringBootApplication
@EnableJpaAuditing
public class SpringbaseApplication implements CommandLineRunner {
	@Autowired
	private GenerateSqlService generateSqlService;

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringbaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.generateSqlService.process();
	}
}
