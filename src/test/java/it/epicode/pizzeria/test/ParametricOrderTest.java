package it.epicode.pizzeria.test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class ParametricOrderTest {

    @ParameterizedTest
    @CsvSource({
            "2, 5.99, 11.98", // 2 pizze da 5.99
            "3, 4.99, 14.97", // 3 pizze da 4.99
            "1, 8.99, 8.99"   // 1 pizza da 8.99
    })
    public void testOrderTotalParameterized(int quantity, double price, double expectedTotal) {
        double total = quantity * price;
        assertEquals(expectedTotal, total, "Il totale dell'ordine non è corretto");
    }
}