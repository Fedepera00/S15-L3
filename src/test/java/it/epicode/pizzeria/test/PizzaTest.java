package it.epicode.pizzeria.test;

import it.epicode.pizzeria.entity.Pizza;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

public class PizzaTest {

    @Test
    public void testPizzaCreation() {
        Pizza pizza = new Pizza();
        pizza.setName("Margherita");
        pizza.setCalories(1000);
        pizza.setPrice(4.99);
        pizza.setIngredients("tomato, cheese");

        assertNotNull(pizza);
        assertEquals("Margherita", pizza.getName());
        assertEquals(4.99, pizza.getPrice());
    }
}