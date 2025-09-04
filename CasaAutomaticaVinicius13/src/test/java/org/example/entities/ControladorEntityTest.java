package org.example.entities;

import br.furb.analise.algoritmos.*;
import org.example.interfaces.ArCondicionadoInterface;
import org.example.interfaces.LampadaInterface;
import org.example.interfaces.PersianaInterface;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ControladorEntityTest {
    @org.junit.jupiter.api.Test
    void modoSono() throws Exception {
        ArCondicionadoGellaKaza arGellaKaza = new ArCondicionadoGellaKaza();
        ArCondicionadoVentoBaumn arVentoBaumn = new ArCondicionadoVentoBaumn();

        LampadaPhellipes lampadaPhellipes = new LampadaPhellipes();
        LampadaShoyuMi lampadaShoyuMi = new LampadaShoyuMi();

        PersianaSolarius persianaSolarius = new PersianaSolarius();
        PersianaNatLight persianaNatLight = new PersianaNatLight();

        ArCondicionadoGellaKazaEntity arGellaKazaEntity = new ArCondicionadoGellaKazaEntity(arGellaKaza);
        ArCondicionadoVentoBaumnEntity arVentoBaumnEntity = new ArCondicionadoVentoBaumnEntity(arVentoBaumn);

        LampadaPhellipesEntity lampadaPhellipesEntity = new LampadaPhellipesEntity(lampadaPhellipes);
        LampadaShoyuMiEntity lampadaShoyuMiEntity = new LampadaShoyuMiEntity(lampadaShoyuMi);

        PersianaSolariusEntity persianaSolariusEntity = new PersianaSolariusEntity(persianaSolarius);
        PersianaNatlightEntity persianaNatLightEntity = new PersianaNatlightEntity(persianaNatLight);

        ArrayList<ArCondicionadoInterface> arList = new ArrayList<>();
        arList.add(arGellaKazaEntity);
        arList.add(arVentoBaumnEntity);

        ArrayList<LampadaInterface> lampadaList = new ArrayList<>();
        lampadaList.add(lampadaPhellipesEntity);
        lampadaList.add(lampadaShoyuMiEntity);

        ArrayList<PersianaInterface> persianaList = new ArrayList<>();
        persianaList.add(persianaSolariusEntity);
        persianaList.add(persianaNatLightEntity);

        ControladorEntity controladorEntity = new ControladorEntity(persianaList, lampadaList, arList);
        controladorEntity.modoSono();

        assertFalse(arGellaKaza.estaLigado(), "O ar GellaKaza deveria estar ligado no modo sono");
        assertFalse(arVentoBaumn.estaLigado(), "O ar VentoBaumn deveria estar ligado no modo sono");
        assertFalse(persianaNatLight.estaPalhetaAberta(), "Deveria estar fechado");
        assertFalse(persianaSolarius.estaAberta(), "Deveria estar fechado");
        assertFalse(lampadaPhellipes.getIntensidade() != 0, "Deveria estar desligado");
        assertFalse(lampadaShoyuMi.estaLigada(), "Deveria estar desligado");

    }


        @org.junit.jupiter.api.Test
        void modoTrabalho() throws Exception {
            // Instâncias reais
            ArCondicionadoGellaKaza arGellaKaza = new ArCondicionadoGellaKaza();
            ArCondicionadoVentoBaumn arVentoBaumn = new ArCondicionadoVentoBaumn();

            LampadaPhellipes lampadaPhellipes = new LampadaPhellipes();
            LampadaShoyuMi lampadaShoyuMi = new LampadaShoyuMi();

            PersianaSolarius persianaSolarius = new PersianaSolarius();
            PersianaNatLight persianaNatLight = new PersianaNatLight();

            // Entities
            ArCondicionadoGellaKazaEntity arGellaKazaEntity = new ArCondicionadoGellaKazaEntity(arGellaKaza);
            ArCondicionadoVentoBaumnEntity arVentoBaumnEntity = new ArCondicionadoVentoBaumnEntity(arVentoBaumn);

            LampadaPhellipesEntity lampadaPhellipesEntity = new LampadaPhellipesEntity(lampadaPhellipes);
            LampadaShoyuMiEntity lampadaShoyuMiEntity = new LampadaShoyuMiEntity(lampadaShoyuMi);

            PersianaSolariusEntity persianaSolariusEntity = new PersianaSolariusEntity(persianaSolarius);
            PersianaNatlightEntity persianaNatlightEntity = new PersianaNatlightEntity(persianaNatLight);

            // Listas
            ArrayList<ArCondicionadoInterface> arList = new ArrayList<>();
            arList.add(arGellaKazaEntity);
            arList.add(arVentoBaumnEntity);

            ArrayList<LampadaInterface> lampadaList = new ArrayList<>();
            lampadaList.add(lampadaPhellipesEntity);
            lampadaList.add(lampadaShoyuMiEntity);

            ArrayList<PersianaInterface> persianaList = new ArrayList<>();
            persianaList.add(persianaSolariusEntity);
            persianaList.add(persianaNatlightEntity);

            // Controlador
            ControladorEntity controladorEntity = new ControladorEntity(persianaList, lampadaList, arList);

            controladorEntity.modoTrabalho();

            // Valida os ares-condicionados
            assertTrue(arGellaKaza.estaLigado(), "O ar GellaKaza deveria estar ligado no modo trabalho");
            assertTrue(arVentoBaumn.estaLigado(), "O ar VentoBaumn deveria estar ligado no modo trabalho");
            assertEquals(25, arGellaKaza.getTemperatura(), "O ar GellaKaza deveria estar ajustado para 25°C");
            assertEquals(25, arVentoBaumn.getTemperatura(), "O ar VentoBaumn deveria estar ajustado para 25°C");

            // Valida as persianas
            assertTrue(persianaNatLight.estaPalhetaAberta(), "A persiana NatLight deveria estar aberta no modo trabalho");
            assertTrue(persianaSolarius.estaAberta(), "A persiana Solarius deveria estar aberta no modo trabalho");

            // Valida as lâmpadas
            assertTrue(lampadaPhellipes.getIntensidade() > 0, "A lâmpada Phellipes deveria estar ligada no modo trabalho");
            assertTrue(lampadaShoyuMi.estaLigada(), "A lâmpada ShoyuMi deveria estar ligada no modo trabalho");
        }
}