package me.gonzager.ex.operaciones.mision;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import me.gonzager.ex.operaciones.dron.DronComercial;

class MisionExploracionTest {
    DronComercial dronComercial = new DronComercial(50, MisionExploracion.getInstance(), 0);

    @Test
    void testExtra() {
        assertEquals(0, MisionExploracion.getInstance().extra(dronComercial));
    }

    @Test
    void testDronAvanzado() {
        assertEquals(false, MisionExploracion.getInstance().esDronAvanzado(dronComercial));
    }

    @Test
    void testSingletonInstance() {
        MisionExploracion instance1 = MisionExploracion.getInstance();
        MisionExploracion instance2 = MisionExploracion.getInstance();
        assertEquals(instance1, instance2);
    }
}
