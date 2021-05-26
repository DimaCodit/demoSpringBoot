package com.example.demospringboot.config;

import com.example.demospringboot.model.Product;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HibernateConfig {
    @Bean
    org.hibernate.cfg.Configuration config() {
        return new org.hibernate.cfg.Configuration()
                .addAnnotatedClass(Product.class);

    }
    @Bean
    SessionFactory sessionFactory() {
        return config().buildSessionFactory();
    }

}
