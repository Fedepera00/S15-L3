package it.epicode.pizzeria.configurations;

import it.epicode.pizzeria.entity.Drinks;
import it.epicode.pizzeria.entity.Menu;
import it.epicode.pizzeria.entity.Pizza;
import it.epicode.pizzeria.entity.Toppings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    public Pizza createPizzaMargherita() {
        Pizza pizza = new Pizza();
        pizza.setName("Pizza Margherita");
        pizza.setCalories(1104);
        pizza.setIngredients("tomato, cheese");
        pizza.setPrice(4.99);
        return pizza;
    }

    @Bean
    public Pizza createPizzaHawaiian() {
        Pizza pizza = new Pizza();
        pizza.setName("Hawaiian Pizza");
        pizza.setCalories(1024);
        pizza.setIngredients("tomato, cheese, ham, pineapple");
        pizza.setPrice(6.49);
        return pizza;
    }

    @Bean
    public Pizza createPizzaSalami() {
        Pizza pizza = new Pizza();
        pizza.setName("Salami Pizza");
        pizza.setCalories(1160);
        pizza.setIngredients("tomato, cheese, salami");
        pizza.setPrice(5.99);
        return pizza;
    }

    @Bean
    public List<Pizza> createListaPizze() {
        List<Pizza> listaPizze = new ArrayList<>();
        listaPizze.add(createPizzaMargherita());
        listaPizze.add(createPizzaHawaiian());
        listaPizze.add(createPizzaSalami());
        return listaPizze;
    }


    @Bean
    public Toppings createCheese() {
        Toppings toppings = new Toppings();
        toppings.setName("Cheese");
        toppings.setCalories(92);
        toppings.setPrice(0.69);
        return toppings;
    }

    @Bean
    public Toppings createHam() {
        Toppings toppings = new Toppings();
        toppings.setName("Ham");
        toppings.setCalories(35);
        toppings.setPrice(0.99);
        return toppings;
    }

    @Bean
    public Toppings createOnions() {
        Toppings toppings = new Toppings();
        toppings.setName("Onions");
        toppings.setCalories(22);
        toppings.setPrice(0.69);
        return toppings;
    }

    @Bean
    public Toppings createPineapple() {
        Toppings toppings = new Toppings();
        toppings.setName("Pineapple");
        toppings.setCalories(24);
        toppings.setPrice(0.79);
        return toppings;
    }

    @Bean
    public Toppings createSalami() {
        Toppings toppings = new Toppings();
        toppings.setName("Salami");
        toppings.setCalories(86);
        toppings.setPrice(0.99);
        return toppings;
    }

    @Bean
    public List<Toppings> createListaToppings() {
        List<Toppings> listaToppings = new ArrayList<>();
        listaToppings.add(createCheese());
        listaToppings.add(createHam());
        listaToppings.add(createPineapple());
        listaToppings.add(createOnions());
        listaToppings.add(createSalami());
        return listaToppings;
    }

    @Bean
    public Drinks createLemonade() {
        Drinks drinks = new Drinks();
        drinks.setName("Lemonade");
        drinks.setQuantity("0.33l");
        drinks.setCalories(128);
        drinks.setPrice(1.29);
        return drinks;
    }

    @Bean
    public Drinks createWater() {
        Drinks drinks = new Drinks();
        drinks.setName("Water");
        drinks.setQuantity("0.5l");
        drinks.setCalories(0);
        drinks.setPrice(1.29);
        return drinks;
    }

    @Bean
    public Drinks createWine() {
        Drinks drinks = new Drinks();
        drinks.setName("Wine");
        drinks.setQuantity("0.75l, 13%");
        drinks.setCalories(607);
        drinks.setPrice(7.49);
        return drinks;
    }

    @Bean
    public List<Drinks> createListaDrinks() {
        List<Drinks> listaDrinks = new ArrayList<>();
        listaDrinks.add(createLemonade());
        listaDrinks.add(createWater());
        listaDrinks.add(createWine());
        return listaDrinks;
    }


    @Bean
    public Menu createmenu() {

        Menu menu = new Menu();
        menu.setPizze(createListaPizze());
        menu.setToppings(createListaToppings());
        menu.setDrinks(createListaDrinks());
        return menu;
    }

}
