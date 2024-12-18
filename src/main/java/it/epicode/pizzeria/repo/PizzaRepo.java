package it.epicode.pizzeria.repo;

import it.epicode.pizzeria.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepo extends JpaRepository<Pizza, Long> {
}