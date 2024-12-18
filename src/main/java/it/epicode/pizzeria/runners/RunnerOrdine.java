package it.epicode.pizzeria.runners;

import it.epicode.pizzeria.configurations.AppConfig;
import it.epicode.pizzeria.entity.Menu;
import it.epicode.pizzeria.entity.Order;
import it.epicode.pizzeria.entity.Pizza;
import it.epicode.pizzeria.entity.Table;
import it.epicode.pizzeria.enumeration.Stato;
import it.epicode.pizzeria.enumeration.statoOrdine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;


@Component
@org.springframework.core.annotation.Order(2)
public class RunnerOrdine implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(RunnerOrdine.class);

    private final Menu menu;


    @Autowired
    public RunnerOrdine(Menu menu) {
        this.menu = menu;

    }

    @Value("${application.coperto}")
    double costoCoperto;

    @Override
    public void run(String... args) throws Exception {


        // Recuperiamo il bean Menu
        menu.printMenu();


        logger.info("sto creando l'ordine");


        Table table = new Table();
        table.setStato(Stato.LIBERO);
        table.setNumeroCopertiMassimo(30);


        Order order = new Order();
        order.setPizzas(Arrays.asList(menu.getPizze().get(0), menu.getPizze().get(1)));
        order.setDrinks(Arrays.asList(menu.getDrinks().get(2)));
        order.setToppings(Arrays.asList(menu.getToppings().get(3)));
        order.setStatoOrdine(statoOrdine.IN_CORSO);
        order.setOraAquisizione(LocalDate.now());
        order.setTable(table);
        order.setNumeroCoperti(12);
        double tot = (costoCoperto * 12) + (menu.getPizze().get(0).getPrice() + menu.getPizze().get(1).getPrice() + menu.getDrinks().get(2).getPrice()) + menu.getToppings().get(3).getPrice();
        order.setTotCosto(tot);

        logger.info(String.valueOf(order));
        logger.info("ordine creato");


    }
}
