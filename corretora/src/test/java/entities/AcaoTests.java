package entities;

import enums.*;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class AcaoTests {

   
    @Test
    void testMatchOrdemDeCompraEVenda() {
        Pessoa investidorA = new Pessoa("Mariana");
        Pessoa investidorB = new Pessoa("Joaquim");
        Acao acaoBBAS3 = new Acao("BBAS3", 24.00);

        investidorA.registrarOrdem(acaoBBAS3, 24.00, TipoOrdem.VENDA);
        investidorB.registrarOrdem(acaoBBAS3, 24.00, TipoOrdem.COMPRA);

        assertTrue(acaoBBAS3.getOrdens().isEmpty(), "A lista de ordens deveria estar vazia após o match.");
    }


    @Test
    void testAtualizacaoValorAcaoAposMatch() {
        Pessoa investidorA = new Pessoa("Guilherme");
        Pessoa investidorB = new Pessoa("Nicoly");
        Acao acaoPETR4 = new Acao("PETR4", 30.00);

        investidorA.registrarOrdem(acaoPETR4, 32.50, TipoOrdem.VENDA);
        investidorB.registrarOrdem(acaoPETR4, 32.50, TipoOrdem.COMPRA);

        assertEquals(32.50, acaoPETR4.getValor(), "O valor da ação deveria ser 32.50 após o match.");
    }

    
    @Test
    void testOrdensSemMatchDeValores() {
        Pessoa investidorC = new Pessoa("Fabio");
        Pessoa investidorD = new Pessoa("Juliana");
        Acao acaoVALE3 = new Acao("VALE3", 75.00);

        investidorC.registrarOrdem(acaoVALE3, 76.00, TipoOrdem.VENDA); // Preço de venda maior
        investidorD.registrarOrdem(acaoVALE3, 75.50, TipoOrdem.COMPRA); // Preço de compra menor

        assertFalse(acaoVALE3.getOrdens().isEmpty(), "A lista de ordens não deveria estar vazia.");
        assertEquals(2, acaoVALE3.getOrdens().size(), "A lista de ordens deveria conter 2 ordens.");
    }
}
