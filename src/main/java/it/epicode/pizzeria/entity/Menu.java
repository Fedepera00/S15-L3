package it.epicode.pizzeria.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Data
@Entity
@NamedQuery(name = "Trova_tutto_Menu", query = "SELECT a FROM Menu a")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
    private List<Pizza> pizze;

    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
    private List<Drinks> drinks;

    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
    private List<Toppings> toppings;


    @Override
    public String toString() {
        return "Menu " +
                ", pizze=" + pizze +
                ", toppings=" + toppings +
                ", drinks=" + drinks +
                '}';
    }

    public void printMenu() {
        System.out.println("### PIZZAS ###");
        pizze.forEach(System.out::println);

        System.out.println("\n### TOPPINGS ###");
        toppings.forEach(System.out::println);

        System.out.println("\n### DRINKS ###");
        drinks.forEach(System.out::println);
    }
}
