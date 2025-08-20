
package me.gonzager.ex.operaciones.sensor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SensorTest {

    @Test
    void testConstructorAndGetters() {
        Sensor sensor = new Sensor(10, 5, true);
        assertEquals(10, sensor.getDurabilidad());
        assertEquals(5, sensor.getCapacidad());
        assertTrue(sensor.tieneMejoras());
    }

    @Test
    void testEsDuraderoTrue() {
        Sensor sensor = new Sensor(15, 5, false); // 15 > 5*2
        assertTrue(sensor.esDuradero());
    }

    @Test
    void testEsDuraderoFalse() {
        Sensor sensor = new Sensor(10, 5, false); // 10 == 5*2
        assertFalse(sensor.esDuradero());

        Sensor sensor2 = new Sensor(8, 5, false); // 8 < 5*2
        assertFalse(sensor2.esDuradero());
    }

    @Test
    void testTieneMejorasFalse() {
        Sensor sensor = new Sensor(10, 5, false);
        assertFalse(sensor.tieneMejoras());
    }
}