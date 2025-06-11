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

/**
 * The Class CoreJpaConfig.
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.pzfomar.springbase.core", entityManagerFactoryRef = "coreEntityManager", transactionManagerRef = "coreTransactionManager")
public class CoreJpaConfig {

	/**
	 * Core data source.
	 *
	 * @return the data source
	 */
	@Primary
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.core")
	DataSource coreDataSource() {
		return DataSourceBuilder.create().build();
	}

	/**
	 * Core entity manager.
	 *
	 * @param entityManagerFactoryBuilder the entity manager factory builder
	 * @param dataSource                  the data source
	 * @return the local container entity manager factory bean
	 */
	@Primary
	@Bean
	LocalContainerEntityManagerFactoryBean coreEntityManager(EntityManagerFactoryBuilder entityManagerFactoryBuilder,
			@Qualifier("coreDataSource") DataSource dataSource) {
		return entityManagerFactoryBuilder.dataSource(dataSource).packages("com.pzfomar.springbase")
				.persistenceUnit("core").build();
	}

	/**
	 * Core transaction manager.
	 *
	 * @param entityManagerFactory the entity manager factory
	 * @return the platform transaction manager
	 */
	@Bean
	PlatformTransactionManager coreTransactionManager(
			@Qualifier("coreEntityManager") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
}
