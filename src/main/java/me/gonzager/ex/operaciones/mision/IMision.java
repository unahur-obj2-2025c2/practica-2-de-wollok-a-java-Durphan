package me.gonzager.ex.operaciones.mision;

import me.gonzager.ex.operaciones.dron.Dron;

public interface IMision {
    int extra(Dron dron);

    boolean esDronAvanzado(Dron dron);

}
