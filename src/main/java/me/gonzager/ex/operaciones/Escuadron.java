package me.gonzager.ex.operaciones;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import me.gonzager.ex.operaciones.dron.Dron;
import me.gonzager.ex.zona.Zona;

public class Escuadron {
    private Set<Dron> drones = new HashSet<>();

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
        dron.restarAutonomia(2);
        drones.add(dron);
    }

    public Escuadron(List<Dron> drones, Zona zona) {
        setDrones(drones);
        setZona(zona);
    }

    public Escuadron(List<Dron> drones) {
        setDrones(drones);
    }

    public void setDrones(List<Dron> drones) {
        for (Dron dron : drones) {
            if (dron.getAutonomia() > 0) {
                dron.restarAutonomia(2);
            } else {
                throw new IllegalArgumentException(
                        "El dron " + dron.getClass().getSimpleName() + " no tiene autonomia suficiente");
            }
        }
        this.drones = new HashSet<>(drones);
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
