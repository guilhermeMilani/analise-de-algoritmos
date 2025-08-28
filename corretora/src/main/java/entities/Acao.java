package entities;

import enums.TipoOrdem;
import interfaces.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Acao {
    private String nome;
    private double valor;
    private List<Ordem> ordens = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();

    public Acao(){}

    public Acao(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
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

    public List<Observer> getObservers() {
        return observers;
    }

    public void adicionarObservador(Observer observers) {
        this.observers.add(observers);
    }

    public void removerObservador(Observer observer) {
        this.observers.remove(observer);
    }

    public void notificarObservadores(){
        observers.forEach(observer -> observer.receberAtualizacaoDeUmaAcao(this));
    }

    public void excluirOrdem(TipoOrdem tipoOrdem){
        ordens.removeIf(ordem1 -> ordem1.getValor() == valor && ordem1.getTipoOrdem() != tipoOrdem);
    }

    public Optional<Ordem> encontrarOrdem(Ordem ordem){
        return ordens.stream()
                .filter(ordem1 -> ordem1.getValor() == ordem.getValor() && ordem1.getTipoOrdem() != ordem.getTipoOrdem())
                .findFirst();
    }

    @Override
    public String toString() {
        return "Acao{" +
                "nome='" + nome + '\'' +
                ", valor=" + valor +
                ", ordens=" + ordens +
                ", observers=" + observers +
                '}';
    }
}
