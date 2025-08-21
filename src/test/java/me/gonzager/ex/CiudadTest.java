package me.gonzager.ex;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CiudadTest {
    Ciudad ciudad = new Ciudad();

    @Test
    void testGetLimiteDrones() {
        assertEquals(10, ciudad.getLimiteDrones());
    }

}
