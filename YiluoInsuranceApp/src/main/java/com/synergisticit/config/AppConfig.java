package com.synergisticit.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class AppConfig {

	@Bean
    DataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:3306/InsurancePlan?useSSL=false&serverTimezone=UTC");
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUsername("root");
		dataSource.setPassword("12345678");
		return dataSource;		
	}

    @Bean
    @Primary
    LocalContainerEntityManagerFactoryBean entityManagerFactory(){
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactory.setDataSource(dataSource());
		entityManagerFactory.setPackagesToScan("com.synergisticit.domain");
		entityManagerFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		entityManagerFactory.setJpaProperties(jpaProperties());
		
		return entityManagerFactory;
	}
	
	public Properties jpaProperties(){
		Properties jpaProperties = new Properties();
		jpaProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		jpaProperties.setProperty("hibernate.show_sql", "true");
		jpaProperties.setProperty("hibernate.generate-ddl", "true");
		jpaProperties.setProperty("hibernate.hbm2ddl.auto", "update"); 		
		return jpaProperties;
	}
	
	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
	
	
	
}