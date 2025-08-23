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

    public void registrarOrdem(Acao acao, double valor, TipoOrdem tipoOrdem){
        if (tipoOrdem == TipoOrdem.COMPRA){
            Ordem ordem = new Ordem(nome, TipoOrdem.COMPRA, valor);
            Optional<Ordem> ordemEncontrada = acao.getOrdens().stream()
                    .filter(ordem1 -> ordem1.getValor() == ordem.getValor() && ordem1.getTipoOrdem() == ordem.getTipoOrdem())
                    .findFirst();
            if (ordemEncontrada.isPresent()){
                acao.setValor(valor);
            }else {
                acao.getOrdens().add(ordem);
            }
        }
        if (tipoOrdem == TipoOrdem.VENDA){
            Ordem ordem = new Ordem(nome, TipoOrdem.VENDA, valor);
            Optional<Ordem> ordemEncontrada = acao.getOrdens().stream()
                    .filter(ordem1 -> ordem1.getValor() == ordem.getValor() && ordem1.getTipoOrdem() == ordem.getTipoOrdem())
                    .findFirst();
            if (ordemEncontrada.isPresent()){
                acao.setValor(valor);
            }else {
                acao.getOrdens().add(ordem);
            }
        }
    }

    @Override
    public void receberAtualizacaoDeUmaAcao(Acao acao){
        System.out.println("A ação " + acao.getNome() + " recebeu uma atualização no seu valor, agora ela vale R$" + acao.getValor());
    }
}
