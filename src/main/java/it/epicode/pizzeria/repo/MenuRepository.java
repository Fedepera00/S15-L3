package it.epicode.pizzeria.repo;

import it.epicode.pizzeria.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}