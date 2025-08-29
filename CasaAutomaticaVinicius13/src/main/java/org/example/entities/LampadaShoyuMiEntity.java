package org.example.entities;

import br.furb.analise.algoritmos.LampadaShoyuMi;
import org.example.interfaces.LampadaInterface;

public class LampadaShoyuMiEntity implements LampadaInterface {
    private LampadaShoyuMi lampadaShoyuMi;
    @Override
    public void ligar() {
        if (!lampadaShoyuMi.estaLigada())
            lampadaShoyuMi.ligar();
    }

    @Override
    public void desligar() {
        if (lampadaShoyuMi.estaLigada())
            lampadaShoyuMi.desligar();
    }
}
