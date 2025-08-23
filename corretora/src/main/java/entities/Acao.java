package entities;

import enums.TipoOrdem;
import interfaces.Observer;

import java.util.ArrayList;
import java.util.List;

public class Acao {
    private String nome;
    private double valor;
    private List<Ordem> ordens;
    private List<Observer> observers = new ArrayList<>();

    public Acao(){}

    public Acao(String nome, double valor, List<Ordem> ordens) {
        this.nome = nome;
        this.valor = valor;
        this.ordens = ordens;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public List<Ordem> getOrdens() {
        return ordens;
    }

    public void setOrdens(List<Ordem> ordens) {
        this.ordens = ordens;
    }
}
