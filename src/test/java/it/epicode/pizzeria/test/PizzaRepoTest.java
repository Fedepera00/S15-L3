package it.epicode.pizzeria.test;

import it.epicode.pizzeria.entity.Pizza;
import it.epicode.pizzeria.repo.PizzaRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PizzaRepoTest {

    @Autowired
    private PizzaRepo pizzaRepo;

    @Test
    public void testSaveAndFindPizza() {
        Pizza pizza = new Pizza();
        pizza.setName("Margherita");
        pizza.setPrice(4.99);


        pizzaRepo.save(pizza);


        Pizza retrievedPizza = pizzaRepo.findById(pizza.getId()).orElse(null);


        assertNotNull(retrievedPizza, "La pizza dovrebbe essere salvata e recuperata correttamente");
        assertEquals("Margherita", retrievedPizza.getName(), "Il nome della pizza non è corretto");
    }
}