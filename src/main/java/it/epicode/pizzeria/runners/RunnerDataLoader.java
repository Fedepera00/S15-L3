package it.epicode.pizzeria.runners;

import it.epicode.pizzeria.entity.Drinks;
import it.epicode.pizzeria.entity.Menu;
import it.epicode.pizzeria.entity.Pizza;
import it.epicode.pizzeria.entity.Toppings;
import it.epicode.pizzeria.repo.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Order(1)
public class RunnerDataLoader implements CommandLineRunner {

    private final PizzaRepo pizzaRepo;
    private final DrinksRepository drinksRepository;
    private final ToppingsRepository toppingsRepository;
    private final OrderRepository orderRepositor;
    private final TableRepository tableRepository;
    private final MenuRepository menuRepository;


    public RunnerDataLoader(PizzaRepo pizzaRepo, DrinksRepository drinksRepository, ToppingsRepository toppingsRepository, OrderRepository orderRepositor, TableRepository tableRepository, MenuRepository menuRepository) {
        this.pizzaRepo = pizzaRepo;
        this.drinksRepository = drinksRepository;
        this.toppingsRepository = toppingsRepository;
        this.orderRepositor = orderRepositor;
        this.tableRepository = tableRepository;
        this.menuRepository = menuRepository;
    }

    @Autowired
    Menu menu;

    @Autowired
    @Qualifier("createListaPizze")
    List<Pizza> createListaPizze;

    @Autowired
    @Qualifier("createListaDrinks")
    List<Drinks> createListaDrinks;

    @Autowired
    @Qualifier("createListaToppings")
    List<Toppings> createListaToppings;

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        // Salva le pizze
        pizzaRepo.saveAll(createListaPizze);
        System.out.println("Pizze salvate nel database!");

        // Salva i toppings
        toppingsRepository.saveAll(createListaToppings);
        System.out.println("Toppings salvati nel database!");


        // Salva le bevande
        drinksRepository.saveAll(createListaDrinks);
        System.out.println("Bevande salvate nel database!");

//         Salva il menu
        menuRepository.save(menu);
        System.out.println("Menu salvato nel database!");

    }
}
