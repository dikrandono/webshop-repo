package com.finalist.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import com.finalist.model.config.CommonSpringConfig;
import com.finalist.model.config.SpringConfig;

//@ImportResource(locations = {"/common-config.xml"})
//@Import(value={CommonSpringConfig.class})  With auto wiring its working good without import
@Configuration
@ComponentScan(basePackages = "com.finalist", excludeFilters = @ComponentScan.Filter(value = { SpringConfig.class,
		TestSpringConfig.class }, type = FilterType.ASSIGNABLE_TYPE))
@Lazy
public class TestSpringConfig {

	@Bean
	public DataSource dataSource() {
		System.out.println("hsqlDataSource hsqlDataSource hsqlDataSource hsqlDataSource");
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = builder.setType(EmbeddedDatabaseType.HSQL).build();
		return db;
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {

		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setDatabase(Database.HSQL);
		hibernateJpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.HSQLDialect");

		return hibernateJpaVendorAdapter;
	}

}
