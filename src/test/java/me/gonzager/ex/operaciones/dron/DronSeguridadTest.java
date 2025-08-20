package me.gonzager.ex.operaciones.dron;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import me.gonzager.ex.operaciones.mision.MisionVigilancia;
import me.gonzager.ex.operaciones.sensor.Sensor;

class DronSeguridadTest {

    List<Sensor> sensores = List.of(new Sensor(50, 10, true));
    DronSeguridad dronSeguridad = new DronSeguridad(50, MisionVigilancia.getInstance(), 10, sensores);

    @Test
    void getSensores() {
        assertEquals(sensores, dronSeguridad.getSensores());
    }

    @Test
    void esAvanzado() {
        assertTrue(dronSeguridad.esAvanzado());
    }
}
