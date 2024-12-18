package it.epicode.pizzeria.test;

import it.epicode.pizzeria.entity.Table;
import it.epicode.pizzeria.enumeration.Stato;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TableTest {

    @Test
    public void testInvalidTableCreation() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Table table = new Table();
            table.setNumeroCopertiMassimo(-5);
            table.setStato(Stato.OCCUPATO);
        });


        assertEquals("Numero coperti massimo non valido", exception.getMessage());
    }
}