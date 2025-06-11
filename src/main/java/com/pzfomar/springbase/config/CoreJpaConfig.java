package com.pzfomar.springbase.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableJpaRepositories(basePackages = "com.pzfomar.springbase.core", entityManagerFactoryRef = "coreEntityManager", transactionManagerRef = "coreTransactionManager")
public class CoreJpaConfig {
	@Primary
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.core")
	DataSource coreDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Primary
	@Bean
	LocalContainerEntityManagerFactoryBean coreEntityManager(EntityManagerFactoryBuilder entityManagerFactoryBuilder,
			@Qualifier("coreDataSource") DataSource dataSource) {
		return entityManagerFactoryBuilder.dataSource(dataSource).packages("com.pzfomar.springbase")
				.persistenceUnit("core").build();
	}

	@Bean
	PlatformTransactionManager coreTransactionManager(
			@Qualifier("coreEntityManager") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
}
