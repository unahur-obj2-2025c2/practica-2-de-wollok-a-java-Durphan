package me.gonzager.ex.operaciones.dron;

import me.gonzager.ex.operaciones.mision.IMision;

public abstract class Dron {

    int autonomia;

    IMision misionActual;

    private final int nivelProcesamiento;

    int autonomiaExtra() {
        return 0;
    }

    public abstract boolean esAvanzado();

    public int eficiencia() {
        return autonomia * 10 + this.autonomiaExtra() + misionActual.extra(this);
    }

    public void setMision(IMision mision) {
        this.misionActual = mision;
    }

    public int getAutonomia() {
        return autonomia;
    }

    public void restarAutonomia(int autonomia) {
        this.autonomia -= autonomia;
    }

    public int getNivelProcesamiento() {
        return nivelProcesamiento;
    }

    protected Dron(int autonomia, IMision misionActual, int nivelProcesamiento) {
        this.autonomia = autonomia;
        this.misionActual = misionActual;
        this.nivelProcesamiento = nivelProcesamiento;
    }

}
