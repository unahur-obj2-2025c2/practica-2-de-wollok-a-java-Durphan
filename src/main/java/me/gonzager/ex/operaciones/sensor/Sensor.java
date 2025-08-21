package me.gonzager.ex.operaciones.sensor;

public class Sensor {
    private final int durabilidad;

    private final int capacidad;

    private final boolean tieneMejoras;

    public Sensor(int durabilidad, int capacidad, boolean tieneMejoras) {
        this.durabilidad = durabilidad;
        this.capacidad = capacidad;
        this.tieneMejoras = tieneMejoras;
    }

    public int getDurabilidad() {
        return durabilidad;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public boolean tieneMejoras() {
        return tieneMejoras;
    }

    public boolean esDuradero() {
        return durabilidad > capacidad * 2;
    }

    public int getEficienciaOperativa() {
        return this.tieneMejoras ? capacidad * 2 : capacidad;
    }
}
