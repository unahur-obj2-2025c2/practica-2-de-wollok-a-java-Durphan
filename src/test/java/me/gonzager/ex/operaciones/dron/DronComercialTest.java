package me.gonzager.ex.operaciones.dron;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import me.gonzager.ex.operaciones.mision.MisionExploracion;

class DronComercialTest {
    DronComercial dronComercial = new DronComercial(50, MisionExploracion.getInstance(), 0);

    @Test
    void testEficiencia() {
        assertEquals(515, dronComercial.eficiencia());
    }

    @Test
    void testEsAvanzado() {
        assertFalse(dronComercial.esAvanzado());
    }

    @Test
    void testAutonomiaExtra() {
        assertEquals(15, dronComercial.autonomiaExtra());
    }

    @Test
    void testConstructor() {
        assertEquals(50, dronComercial.getAutonomia());
        assertEquals(0, dronComercial.getNivelProcesamiento());
        assertEquals(MisionExploracion.getInstance(), dronComercial.misionActual);
    }

    @Test
    void testEficienciaConDronDiferente() {
        DronComercial dron = new DronComercial(100, MisionExploracion.getInstance(), 10);

        assertEquals(1015, dron.eficiencia());
    }
}
