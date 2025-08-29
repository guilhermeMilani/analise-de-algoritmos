package org.example.entities;

import br.furb.analise.algoritmos.ArCondicionadoGellaKaza;
import org.example.interfaces.ArCondicionadoInterface;

public class ArCondicionadoGellaKazaEntity implements ArCondicionadoInterface {
    private ArCondicionadoGellaKaza arCondicionadoGellaKaza;

    @Override
    public void desligar() {
        arCondicionadoGellaKaza.desativar();
    }

    @Override
    public void ligar() {
        arCondicionadoGellaKaza.ativar();
    }

    @Override
    public void diminuirTemperatura() {
        arCondicionadoGellaKaza.diminuirTemperatura();

    }

    @Override
    public void aumentarTemperatura() {
        arCondicionadoGellaKaza.aumentarTemperatura();
    }

    @Override
    public void definirTemperatura(int temperatura) {
         while (temperatura != arCondicionadoGellaKaza.getTemperatura()){
            if(temperatura < arCondicionadoGellaKaza.getTemperatura()){
                arCondicionadoGellaKaza.diminuirTemperatura();
                continue;
            }
            arCondicionadoGellaKaza.aumentarTemperatura();
        }
    }
}
