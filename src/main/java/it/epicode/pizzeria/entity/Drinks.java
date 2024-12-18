package it.epicode.pizzeria.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Entity
@NamedQuery(name = "Trova_tutto_Drinks", query = "SELECT a FROM Drinks a")
public class Drinks {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "calories")
    private Integer calories;

    @Column(name = "quantity")
    private String quantity;

    @Column(name = "price")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;

}
