package org.example.entities;

import org.example.interfaces.ArCondicionadoInterface;
import org.example.interfaces.LampadaInterface;
import org.example.interfaces.PersianaInterface;

import java.util.List;

public class ControladorEntity {
    private List<PersianaInterface> persianas;
    private List<LampadaInterface>  lampadas;
    private  List<ArCondicionadoInterface> arCondicionados;

    public void AbrirPersianas() throws Exception {
        for(PersianaInterface persiana : persianas){
            persiana.abrir();
        }
    }

    public void FecharPersianas() throws Exception {
        for(PersianaInterface persiana : persianas){
            persiana.fechar();
        }
    }

    public void addLampada(LampadaInterface lampada){
        lampadas.add(lampada);
    }

    public void ligarLampadas() throws Exception {
        for(LampadaInterface lampada : lampadas){
            lampada.ligar();
        }
    }

    public void desligarLampadas() throws Exception {
        for(LampadaInterface lampada : lampadas){
            lampada.desligar();
        }
    }

    public void desligarArCondicionados() throws Exception {
        for(ArCondicionadoInterface arCondicionado : arCondicionados){
            arCondicionado.desligar();
        }
    }
    public void ligarArCondicionados() throws Exception {
        for(ArCondicionadoInterface arCondicionado : arCondicionados){
            arCondicionado.ligar();
        }
    }

    public void aumentarTemperaturaArCondicionados() throws Exception {
        for(ArCondicionadoInterface arCondicionado : arCondicionados){
            arCondicionado.aumentarTemperatura();
        }
    }

    public void diminuirTemperaturaArCondicionados() throws Exception {
        for(ArCondicionadoInterface arCondicionado : arCondicionados){
            arCondicionado.diminuirTemperatura();
        }
    }

    public void definirTemperaturaArCondicionados(int temperatura) throws Exception {
        for(ArCondicionadoInterface arCondicionado : arCondicionados){
            arCondicionado.definirTemperatura(temperatura);
        }
    }


}
