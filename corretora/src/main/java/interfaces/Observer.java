package interfaces;

import entities.Acao;

public interface Observer {
    void receberAtualizacaoDeUmaAcao(Acao acao);
}
