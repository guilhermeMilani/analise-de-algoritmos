package entities;

import enums.TipoOrdem;
import interfaces.Observer;

import java.util.Optional;

public class Pessoa implements Observer {
    private String nome;

    public Pessoa() {
    }

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void registrarEmUmaAcao(Acao acao){
        acao.adicionarObservador(this);
    }

    public void removerRegistroDeUmaAcao(Acao acao){
        acao.removerObservador(this);
    }

    public void registrarOrdem(Acao acao, double valor, TipoOrdem tipoOrdem){
        processarOrdem(acao,valor,tipoOrdem);
    }

    public void processarOrdem(Acao acao, double valor, TipoOrdem tipoOrdem){
        Ordem ordem = new Ordem(nome, tipoOrdem, valor);
        Optional<Ordem> ordemEncontrada = acao.encontrarOrdem(ordem);
        if (ordemEncontrada.isPresent()){
            acao.setValor(valor);
            acao.excluirOrdem(tipoOrdem);
            acao.notificarObservadores();
        }else {
            acao.getOrdens().add(ordem);
        }
    }

    @Override
    public void receberAtualizacaoDeUmaAcao(Acao acao){
        System.out.println("A ação " + acao.getNome() + " recebeu uma atualização no seu valor, agora ela vale R$" + acao.getValor());
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
