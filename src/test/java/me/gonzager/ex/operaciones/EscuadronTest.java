package me.gonzager.ex.operaciones;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import me.gonzager.ex.operaciones.dron.DronComercial;
import me.gonzager.ex.operaciones.mision.MisionTransporte;
import me.gonzager.ex.operaciones.mision.MisionVigilancia;

class EscuadronTest {

    @Test
    void testAgregarDron() {
        Escuadron escuadron = new Escuadron();
        escuadron.agregarDron(new DronComercial(90, MisionVigilancia.getInstance(), 1));
        assertEquals(1, escuadron.cantidadDeDrones());
    }

    @Test
    void testHayDronAvanzado() {
        Escuadron escuadron = new Escuadron();
        escuadron.agregarDron(new DronComercial(90, MisionTransporte.getInstance(), 1));
        assertTrue(escuadron.hayDronAvanzado());
    }

    @Test
    void testEficienciaTotal() {
        Escuadron escuadron = new Escuadron();
        escuadron.agregarDron(new DronComercial(90, MisionTransporte.getInstance(), 1));
        escuadron.agregarDron(new DronComercial(80, MisionTransporte.getInstance(), 2));
        assertEquals(1890, escuadron.eficienciaTotal());
    }
}
