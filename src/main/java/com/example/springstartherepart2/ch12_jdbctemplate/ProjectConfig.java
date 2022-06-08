package com.example.springstartherepart2.ch12_jdbctemplate;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Custom configuration DataSource. Some scenarios in which you need to define the bean yourself are as follows:
 * - You need to use a specific DataSource implementation based on a condition you can
 * only get at runtime.
 * - Your app connects to more than one database, so you have to create multiple data
 * sources and distinguish them using qualifiers.
 * - You have to configure specific parameters of the DataSource object in certain
 * conditions your app has only at runtime. For example, depending on the environment
 * where you start the app, you want to have more or fewer connections in the connection
 * pool for performance optimizations.
 * - Your app uses Spring framework but not Spring Boot.
 */
@Configuration
public class ProjectConfig {
    /*Some parameters can be used from application.properties through @Value*/
    @Value("${spring.datasource.url}")
    private String datasourceUrl;

    @Value("${spring.datasource.username}")
    private String datasourceUsername;

    @Value("${spring.datasource.password}")
    private String datasourcePassword;

    @Bean
    public DataSource dataSource(){
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(datasourceUrl);
        dataSource.setUsername(datasourceUsername);
        dataSource.setPassword(datasourcePassword);
        dataSource.setConnectionTimeout(1000); //we can set additional parameters
        return dataSource;
    }
}
