package me.gonzager.ex.zona;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import me.gonzager.ex.Ciudad;
import me.gonzager.ex.operaciones.Escuadron;
import me.gonzager.ex.operaciones.dron.Dron;
import me.gonzager.ex.operaciones.dron.DronComercial;
import me.gonzager.ex.operaciones.mision.MisionTransporte;

class ZonaTest {
    Ciudad ciudad = new Ciudad(4);
    Zona zona = new Zona(12, ciudad);
    MisionTransporte mision = MisionTransporte.getInstance();
    Escuadron escuadron = new Escuadron(new ArrayList<Dron>(List.of(new DronComercial(90, mision, 1))), zona);
    Escuadron escuadronSinZona = new Escuadron(new ArrayList<Dron>(List.of(new DronComercial(90, mision, 1))));

    @Test
    void testGetCantidadOperaciones() {
        assertEquals(1, zona.getCantidadOperaciones()); // Ya hay un escuadron operando en la zona (escuadron)
    }

    @Test
    void testGetCiudad() {
        assertEquals(ciudad, zona.getCiudad());
    }

    @Test
    void testGetTamanioTotal() {
        assertEquals(12, zona.getTamanioTotal());
    }

    @Test
    void testIncrementarOperaciones() {
        escuadronSinZona.setZona(zona);
        assertEquals(2, zona.getCantidadOperaciones());
    }

    @Test
    void testPuedeEscuadronIngresar() {
        Escuadron escuadronMalo = new Escuadron();
        escuadronMalo.agregarDron(new DronComercial(5, mision, 1));
        assertTrue(zona.puedeEscuadronIngresar(escuadron));
        assertFalse(zona.puedeEscuadronIngresar(escuadronMalo));
    }

    @Test
    void testSetCiudad() {
        Ciudad nuevaCiudad = new Ciudad(5);
        Zona nuevaZona = new Zona(10);
        assertThrows(IllegalArgumentException.class, () -> zona.setCiudad(nuevaCiudad));
        nuevaZona.setCiudad(nuevaCiudad);
        assertEquals(nuevaCiudad, nuevaZona.getCiudad());
    }
}
