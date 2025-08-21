package me.gonzager.ex.zona;

import me.gonzager.ex.Ciudad;
import me.gonzager.ex.operaciones.Escuadron;

public class Zona {

    private int tamanioTotal;
    private int cantidadOperaciones = 0;
    private Ciudad ciudad;

    public int getTamanioTotal() {
        return tamanioTotal;
    }

    public int getCantidadOperaciones() {
        return cantidadOperaciones;
    }

    public void incrementarOperaciones() {
        this.cantidadOperaciones++;
    }

    public Zona(int tamanioTotal) {
        this.tamanioTotal = tamanioTotal;
    }

    public Zona(int tamanioTotal, Ciudad ciudad) {
        this.tamanioTotal = tamanioTotal;
        this.ciudad = ciudad;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        if (this.ciudad != null) {
            throw new IllegalArgumentException("Esta zona ya pertenece a una ciudad");
        }
        this.ciudad = ciudad;
    }

    public boolean puedeEscuadronIngresar(Escuadron escuadron) {
        return escuadron.hayDronAvanzado() && escuadron.eficienciaTotal() > tamanioTotal * 2;
    }

}
