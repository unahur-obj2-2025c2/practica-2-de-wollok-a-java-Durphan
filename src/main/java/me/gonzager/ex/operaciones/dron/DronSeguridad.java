package me.gonzager.ex.operaciones.dron;

import java.util.List;

import me.gonzager.ex.operaciones.mision.IMision;
import me.gonzager.ex.operaciones.sensor.Sensor;

public class DronSeguridad extends Dron {
    List<Sensor> sensores;

    @Override
    public boolean esAvanzado() {
        return this.nivelProcesamiento > 50 || misionActual.esDronAvanzado(this);
    }

    public List<Sensor> getSensores() {
        return sensores;
    }

    public DronSeguridad(int autonomia, IMision misionActual, int nivelProcesamiento, List<Sensor> sensores) {
        super(autonomia, misionActual, nivelProcesamiento);
        this.sensores = sensores;
    }
}
