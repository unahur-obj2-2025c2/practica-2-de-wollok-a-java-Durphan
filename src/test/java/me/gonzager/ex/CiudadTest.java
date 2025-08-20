package me.gonzager.ex;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import me.gonzager.ex.zona.Zona;

public class CiudadTest {
    Ciudad ciudad = new Ciudad();
    Zona zona = new Zona(5);

    @Test
    void testAgregarZona() {
        ciudad.agregarZona(zona);
        assertTrue(ciudad.getZonas().contains(zona));
    }

    @Test
    void testGetLimiteDrones() {
        assertEquals(10, ciudad.getLimiteDrones());
    }

    @Test
    void testGetZonas() {
        ciudad.agregarZona(zona);
        assertEquals(1, ciudad.getZonas().size());
        assertTrue(ciudad.getZonas().contains(zona));

    }
}
