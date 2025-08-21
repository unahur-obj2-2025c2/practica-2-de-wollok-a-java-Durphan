package me.gonzager.ex;

import me.gonzager.ex.operaciones.Escuadron;

public class Ciudad {
    private int limiteDrones = 10;

    public int getLimiteDrones() {
        return limiteDrones;
    }

    public boolean puedeOperarEscuadron(Escuadron escuadron) {
        return escuadron.cantidadDeDrones() <= limiteDrones;
    }

    public Ciudad(int limiteDrones) {
        this.limiteDrones = limiteDrones;
    }

    public Ciudad() {
        // Constructor por defecto
    }

}
