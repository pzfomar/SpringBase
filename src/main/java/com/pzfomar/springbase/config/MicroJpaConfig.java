package com.pzfomar.springbase.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableJpaRepositories(basePackages = "com.pzfomar.springbase.micro", entityManagerFactoryRef = "microEntityManager", transactionManagerRef = "microTransactionManager")
public class MicroJpaConfig {
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.micro")
	DataSource microDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean
	LocalContainerEntityManagerFactoryBean microEntityManager(EntityManagerFactoryBuilder entityManagerFactoryBuilder,
			@Qualifier("microDataSource") DataSource dataSource) {
		return entityManagerFactoryBuilder.dataSource(dataSource).packages("com.pzfomar.springbase")
				.persistenceUnit("micro").build();
	}

	@Bean
	PlatformTransactionManager microTransactionManager(
			@Qualifier("microEntityManager") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
}
