package me.gonzager.ex.operaciones.mision;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import me.gonzager.ex.operaciones.dron.DronComercial;

class MisionTransporteTest {
    MisionTransporte mision = MisionTransporte.getInstance();
    DronComercial dron = new DronComercial(51, mision, 50);

    @Test
    void testEsDronAvanzado() {
        assertTrue(mision.esDronAvanzado(dron));
    }

    @Test
    void testExtra() {
        assertEquals(100, mision.extra(dron));
    }
}
