package me.gonzager.ex.operaciones.mision;

import me.gonzager.ex.operaciones.dron.Dron;

public class MisionExploracion implements IMision {
    private static MisionExploracion mision = new MisionExploracion();

    @Override
    public int extra(Dron dron) {
        return 0;
    }

    @Override
    public boolean esDronAvanzado(Dron dron) {
        return dron.eficiencia() % 2 == 0;
    }

    private MisionExploracion() {
        // Constructor privado para evitar instanciación externa
    }

    public static MisionExploracion getInstance() {
        return mision;
    }
}
