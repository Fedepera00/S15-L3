package it.epicode.pizzeria.entity;

import it.epicode.pizzeria.enumeration.statoOrdine;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Data
@Entity
@jakarta.persistence.Table(name = "custom_order")
@NamedQuery(name = "Trova_tutto_Order", query = "SELECT a FROM Order a")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pizze")
    private List<Pizza> pizzas = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "toppings")
    private List<Toppings> toppings = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "drinks")
    private List<Drinks> drinks = new ArrayList<>();

    @ManyToOne
    private Table table;

    @Enumerated
    @Column(name = "stato_ordine")
    private statoOrdine statoOrdine;

    @Column(name = "numero_coperti")
    private Integer numeroCoperti;

    @Column(name = "ora_aquisizione")
    private LocalDate oraAquisizione;

    @Column(name = "tot_costo")
    private double totCosto;

    // Metodo per calcolare il totale
    public void calculateTotalCost() {
        double total = 0.0;

        // Somma il costo delle pizze
        if (pizzas != null) {
            total += pizzas.stream().mapToDouble(Pizza::getPrice).sum();
        }

        // Somma il costo dei topping
        if (toppings != null) {
            total += toppings.stream().mapToDouble(Toppings::getPrice).sum();
        }

        // Somma il costo delle bevande
        if (drinks != null) {
            total += drinks.stream().mapToDouble(Drinks::getPrice).sum();
        }

        // Somma il costo dei coperti (se numero coperti è impostato)
        if (numeroCoperti != null) {
            total += numeroCoperti * 2.0; // supponiamo che il costo del coperto sia 2.0 per ogni persona
        }

        // Imposta il totale
        this.totCosto = total;
    }
}