package it.epicode.pizzeria.test;

import it.epicode.pizzeria.entity.Order;
import it.epicode.pizzeria.entity.Pizza;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {

    @Test
    public void testOrderTotalCalculation() {

        Pizza pizza1 = new Pizza();
        pizza1.setPrice(5.99);

        Pizza pizza2 = new Pizza();
        pizza2.setPrice(4.99);


        Order order = new Order();
        order.setPizzas(Arrays.asList(pizza1, pizza2));
        order.setNumeroCoperti(2);


        order.calculateTotalCost();


        double expectedTotal = 5.99 + 4.99 + 2 * 2.0; // Totale : 10.98 (per pizze) + 4.0 (per i coperti)
        assertEquals(expectedTotal, order.getTotCosto(), "Il totale dell'ordine non è corretto");
    }
}