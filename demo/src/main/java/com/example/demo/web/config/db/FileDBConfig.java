package com.example.demo.web.config.db;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@PropertySource({ "classpath:application.properties" })
public class FileDBConfig {
	
    @Autowired
    private Environment env;
	
	public FileDBConfig() {
        super();
    }
	
    @Bean
    public DataSource fileDbDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name.filedb"));
        dataSource.setUrl(env.getProperty("spring.datasource.url.filedb"));
        return dataSource;
    }
    
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(fileDbDataSource());
        em.setPackagesToScan(new String[] { "com.example.demo.dbfield" });
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        em.setJpaPropertyMap(getJpaPropertyMap());
        return em;
    }
    
    private HashMap<String, Object> getJpaPropertyMap(){
    	HashMap<String, Object> properties = new HashMap<String, Object>();
        properties.put("hibernate.show_sql", env.getProperty("spring.jpa.show-sql.filedb"));
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("spring.jpa.hibernate.ddl-auto.filedb"));
        properties.put("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect.filedb"));
        return properties;
    }
    
    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }
	
}
