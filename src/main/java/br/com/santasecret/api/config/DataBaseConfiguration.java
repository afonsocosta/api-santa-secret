package br.com.santasecret.api.config;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class DataBaseConfiguration {

    private final Environment env;

    @Bean
    @Primary
    public DataSource scDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));
        return dataSource;
    }

    @Bean(name = "dsOAuth")
    public DataSource oAuthDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(env.getProperty("spring.datasource-oauth.driver-class-name"));
        dataSource.setUrl(env.getProperty("spring.datasource-oauth.url"));
        dataSource.setUsername(env.getProperty("spring.datasource-oauth.username"));
        dataSource.setPassword(env.getProperty("spring.datasource-oauth.password"));
        return dataSource;
    }

}
