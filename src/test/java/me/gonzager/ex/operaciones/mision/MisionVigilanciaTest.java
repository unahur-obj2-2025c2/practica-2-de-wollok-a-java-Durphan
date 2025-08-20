package me.gonzager.ex.operaciones.mision;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import me.gonzager.ex.operaciones.dron.DronComercial;
import me.gonzager.ex.operaciones.dron.DronSeguridad;
import me.gonzager.ex.operaciones.sensor.Sensor;

class MisionVigilanciaTest {
    MisionVigilancia mision = MisionVigilancia.getInstance();
    DronComercial dronComercial = new DronComercial(50, mision, 0);
    List<Sensor> sensores = List.of(new Sensor(50, 20, false));
    DronSeguridad dronSeguridad = new DronSeguridad(50, mision, 0, sensores);

    @Test
    void testEsDronAvanzado() {
        assertThrowsExactly(IllegalArgumentException.class, () -> mision.esDronAvanzado(dronComercial));
        assertTrue(mision.esDronAvanzado(dronSeguridad));

    }

    @Test
    void testExtra() {
        assertThrowsExactly(IllegalArgumentException.class, () -> mision.extra(dronComercial));
        assertEquals(20, mision.extra(dronSeguridad));

    }

    @Test
    void testGetInstance() {
        assertNotNull(MisionVigilancia.getInstance());
    }
}
