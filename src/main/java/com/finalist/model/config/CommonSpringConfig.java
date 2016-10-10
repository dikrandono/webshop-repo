package com.finalist.model.config;


import javax.sql.DataSource;

import org.hibernate.cfg.AvailableSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.finalist", excludeFilters = @ComponentScan.Filter(value = SpringConfig.class, type = FilterType.ASSIGNABLE_TYPE))
public class CommonSpringConfig {

	@Bean
	@Autowired
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(@Qualifier("jpaProperties") Properties jpaProperties, JpaVendorAdapter jpaVendorAdapter, DataSource dataSource) {

		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource);
		em.setJpaDialect(jpaDialect());
		em.setJpaVendorAdapter(jpaVendorAdapter);

		em.setPackagesToScan("com.finalist.model.entities");
		em.setPersistenceUnitName("personPersistenceUnit");

		em.setJpaProperties(jpaProperties);
		return em;
	}

	@Configuration
	@Profile("hsql")
	public static class EmbeddedDatabaseJpaProperties {
		@Bean(name = "jpaProperties")
		public Properties jpaProperties() {
			Properties properties = new Properties();
			properties.setProperty(AvailableSettings.HBM2DDL_AUTO, "create");
			return properties;
		}
	}

	@Configuration
	@Profile("default")
	public static class MySqlJpaProperties {
		@Bean(name = "jpaProperties")
		public Properties jpaProperties() {
			Properties properties = new Properties();
			properties.setProperty(AvailableSettings.HBM2DDL_AUTO, "update");
			return properties;
		}
	}

	@Bean
	@Autowired
	public PlatformTransactionManager transactionManager(LocalContainerEntityManagerFactoryBean entityManagerFactory) {

		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory.getObject());

		return transactionManager;
	}

	public JpaDialect jpaDialect() {

		return new HibernateJpaDialect();
	}

}
