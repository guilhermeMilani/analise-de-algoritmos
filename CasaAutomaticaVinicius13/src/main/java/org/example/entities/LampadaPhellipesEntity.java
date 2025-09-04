package org.example.entities;

import br.furb.analise.algoritmos.LampadaPhellipes;
import org.example.interfaces.LampadaInterface;

public class LampadaPhellipesEntity implements LampadaInterface {
    private LampadaPhellipes lampadaPhellipes;

    public LampadaPhellipesEntity(LampadaPhellipes lampadaPhellipes) {
        this.lampadaPhellipes = lampadaPhellipes;
    }

    @Override
    public void ligar() {
        if (lampadaPhellipes.getIntensidade() != 100)
            lampadaPhellipes.setIntensidade(100);
    }

    @Override
    public void desligar() {
        if (lampadaPhellipes.getIntensidade() != 0)
            lampadaPhellipes.setIntensidade(0);
    }
}
