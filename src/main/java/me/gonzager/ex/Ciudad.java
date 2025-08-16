package me.gonzager.ex;

import java.util.ArrayList;
import java.util.List;

import me.gonzager.ex.operaciones.Escuadron;
import me.gonzager.ex.zona.Zona;

public class Ciudad {
    private int limiteDrones = 10;
    private List<Zona> zonas = new ArrayList<>();

    public int getLimiteDrones() {
        return limiteDrones;
    }

    public List<Zona> getZonas() {
        return zonas;
    }

    public void agregarZona(Zona zona) {
        zonas.add(zona);
    }

    public boolean puedeOperarEscuadron(Escuadron escuadron) {
        return escuadron.cantidadDeDrones() <= limiteDrones;
    }

    public Ciudad(int limiteDrones, List<Zona> zonas) {
        this.limiteDrones = limiteDrones;
        this.zonas = zonas;
    }

    public Ciudad(int limiteDrones) {
        this.limiteDrones = limiteDrones;
    }

}
