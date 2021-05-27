package com.example.demospringboot;

import com.example.demospringboot.model.Product;
import com.example.demospringboot.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringBootApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(ProductRepository repository) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                repository.saveOrUpdate(Product.builder()
                    .title("Майонез")
                    .cost(33).build());

                System.out.println(repository.getById(1L));
            }
        };
    }

}
