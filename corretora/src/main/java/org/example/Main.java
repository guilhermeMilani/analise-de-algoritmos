package org.example;

import entities.Acao;
import entities.Pessoa;
import enums.TipoOrdem;

public class Main {
    public static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa("Guilherme");
        Pessoa pessoa2 = new Pessoa("Nicoly");

        Acao acao1 = new Acao("AAPL", 60.00);

        pessoa1.registrarEmUmaAcao(acao1);
        pessoa2.registrarEmUmaAcao(acao1);


        pessoa1.registrarOrdem(acao1,61, TipoOrdem.VENDA);
        System.out.println(acao1.getOrdens());
        pessoa2.registrarOrdem(acao1,61, TipoOrdem.COMPRA);
        System.out.println(acao1.getOrdens());
        System.out.println(acao1.getValor());

    }
}