package me.gonzager.ex.operaciones.mision;

import me.gonzager.ex.operaciones.dron.Dron;
import me.gonzager.ex.operaciones.dron.DronSeguridad;
import me.gonzager.ex.operaciones.sensor.Sensor;

public class MisionVigilancia implements IMision {

    private static MisionVigilancia mision = new MisionVigilancia();

    private MisionVigilancia() {
        // Constructor privado para implementar el patrón Singleton
    }

    @Override
    public int extra(Dron dron) throws IllegalArgumentException {
        DronSeguridad dronSeguridad = getDronSeguridad(dron);
        int acumulador = 0;
        for (Sensor sensor : dronSeguridad.getSensores()) {
            if (!sensor.tieneMejoras()) {
                acumulador += sensor.getCapacidad();
            } else {
                acumulador *= 2;
            }
        }
        return acumulador;
        /*
         * Uso de reduce (Para experimentar, en casos como estos usar reduce puede ser
         * sobreingenieria)
         * return dronSeguridad.getSensores().stream().reduce(0, (acumulador, sensor) ->
         * {
         * if (!sensor.tieneMejoras()) {
         * acumulador += sensor.getCapacidad();
         * } else {
         * acumulador *= 2;
         * }
         * return acumulador;
         * }, Integer::sum);
         */
    }

    @Override
    public boolean esDronAvanzado(Dron dron) {
        DronSeguridad dronSeguridad = getDronSeguridad(dron);
        return dronSeguridad.getSensores().stream().allMatch(Sensor::esDuradero);
    }

    private DronSeguridad getDronSeguridad(Dron dron) {
        if (dron instanceof DronSeguridad dronSeguridad) {
            return dronSeguridad;
        }
        throw new IllegalArgumentException("El dron no es de tipo DronSeguridad");
    }

    public static MisionVigilancia getInstance() {
        return mision;
    }
}
