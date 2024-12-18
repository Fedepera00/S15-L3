package it.epicode.pizzeria.repo;

import it.epicode.pizzeria.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}