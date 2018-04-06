package com.epam.adok.jpaproject.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.epam.adok.jpaproject.repository")
@Import(DataBaseConfiguration.class)
@ComponentScan("com.epam.adok.jpaproject")
public class RootApplicationContextConfiguration {

}
