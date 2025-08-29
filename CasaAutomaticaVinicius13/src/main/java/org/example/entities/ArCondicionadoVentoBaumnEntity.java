package org.example.entities;

import br.furb.analise.algoritmos.ArCondicionadoGellaKaza;
import br.furb.analise.algoritmos.ArCondicionadoVentoBaumn;
import org.example.interfaces.ArCondicionadoInterface;

public class ArCondicionadoVentoBaumnEntity implements ArCondicionadoInterface {
    private ArCondicionadoVentoBaumn arCondicionadoVentoBaumn;

    @Override
    public void desligar() {
        arCondicionadoVentoBaumn.desligar();
    }

    @Override
    public void ligar() {
        arCondicionadoVentoBaumn.ligar();
    }

    @Override
    public void diminuirTemperatura() {
        arCondicionadoVentoBaumn.definirTemperatura(arCondicionadoVentoBaumn.getTemperatura() - 1);

    }

    @Override
    public void aumentarTemperatura() {
        arCondicionadoVentoBaumn.definirTemperatura(arCondicionadoVentoBaumn.getTemperatura() + 1);
    }

    @Override
    public void definirTemperatura(int temperatura) {
        arCondicionadoVentoBaumn.definirTemperatura(temperatura);
    }
}
