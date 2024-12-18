package it.epicode.pizzeria.repo;

import it.epicode.pizzeria.entity.Table;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableRepository extends JpaRepository<Table, Long> {
}