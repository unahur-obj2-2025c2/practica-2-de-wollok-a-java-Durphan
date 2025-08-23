package me.gonzager.ex.operaciones.dron;

import me.gonzager.ex.operaciones.mision.IMision;

public class DronComercial extends Dron {

    @Override
    public boolean esAvanzado() {
        return misionActual.esDronAvanzado(this);
    }

    public DronComercial(int autonomia, IMision misionActual, int nivelProcesamiento) {
        super(autonomia, misionActual, nivelProcesamiento);
    }

    @Override
    public int autonomiaExtra() {
        return 15;
    }

}
