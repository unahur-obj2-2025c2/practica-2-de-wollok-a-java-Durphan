package me.gonzager.ex.operaciones;

import java.util.ArrayList;
import java.util.List;

import me.gonzager.ex.operaciones.dron.Dron;
import me.gonzager.ex.zona.Zona;

public class Escuadron {
    private List<Dron> drones = new ArrayList<>();

    private Zona zona;

    public Escuadron(Zona zona) {
        setZona(zona);
    }

    public Escuadron() {

    }

    public void agregarDron(Dron dron) {
        if (zona != null && zona.getCiudad().getLimiteDrones() <= cantidadDeDrones()) {
            throw new IllegalArgumentException(
                    "No se pueden agregar mas drones al escuadron, se alcanzo el limite de la ciudad");
        }
        drones.add(dron);
    }

    public Escuadron(List<Dron> drones, Zona zona) {
        this.drones = drones;
        setZona(zona);
    }

    public Escuadron(List<Dron> drones) {
        this.drones = drones;
    }

    public void setZona(Zona zona) {
        if (this.zona != null) {
            throw new IllegalArgumentException("El escuadron ya tiene una zona asignada");
        }
        if (!zona.getCiudad().puedeOperarEscuadron(this)) {
            throw new IllegalArgumentException("El escuadron no cumple los requerimientos para operar en la ciudad");
        }
        if (!zona.puedeEscuadronIngresar(this)) {
            throw new IllegalArgumentException(
                    "El escuadron no cumple los requerimientos para operar en la zona");
        }
        this.zona = zona;
        zona.incrementarOperaciones();
    }

    public int cantidadDeDrones() {
        return drones.size();
    }

    public boolean hayDronAvanzado() {
        return drones.stream().anyMatch(Dron::esAvanzado);
    }

    public int eficienciaTotal() {
        return drones.stream().mapToInt(Dron::eficiencia).sum();
    }

}
