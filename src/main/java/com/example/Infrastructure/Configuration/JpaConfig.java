package com.example.Infrastructure.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.project.Domain.Repository")
@EnableTransactionManagement
public class JpaConfig {
    // Additional JPA configuration can be added if  i  need them later
}
