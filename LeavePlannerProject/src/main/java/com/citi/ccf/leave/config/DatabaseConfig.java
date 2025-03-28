package com.citi.ccf.leave.config;


import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Bean
    @Primary
    @Profile("h2")
    @ConfigurationProperties("spring.datasource")
    public DataSourceProperties h2DataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    @Profile("h2")
    public DataSource h2DataSource() {
        return h2DataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean
    @Profile("oracle")
    @ConfigurationProperties("spring.datasource.oracle")
    public DataSourceProperties oracleDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Profile("oracle")
    public DataSource oracleDataSource() {
        return oracleDataSourceProperties().initializeDataSourceBuilder().build();
    }
}