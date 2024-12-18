package it.epicode.pizzeria;

import it.epicode.pizzeria.configurations.AppConfig;
import it.epicode.pizzeria.entity.Menu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "it.epicode.pizzeria.entity")
@EnableJpaRepositories(basePackages = "it.epicode.pizzeria.repo")
public class PizzeriaApplication {

    public static void main(String[] args) {
        SpringApplication.run(PizzeriaApplication.class, args);

    }

}
