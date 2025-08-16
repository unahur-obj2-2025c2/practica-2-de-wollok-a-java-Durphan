package me.gonzager.ex.operaciones.mision;

import me.gonzager.ex.operaciones.dron.Dron;

public class MisionTransporte implements IMision {
    private static MisionTransporte mision = new MisionTransporte();

    public int extra(Dron dron) {
        return 100;
    }

    @Override
    public boolean esDronAvanzado(Dron dron) {
        return dron.getAutonomia() > 50;
    }

    private MisionTransporte() {
        // Constructor privado para implementar el patrón Singleton
    }

    public static MisionTransporte getInstance() {
        return mision;
    }
}
