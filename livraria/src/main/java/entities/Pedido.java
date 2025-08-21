package entities;

import java.util.List;

public class Pedido {

    private List<Produto> produtos;
    private TipoEnvio tipoEnvio;
    
    
    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setTipoEnvio(TipoEnvio tipoEnvio){
        this.tipoEnvio = tipoEnvio;
    }
    
    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Pedido() {
    }

    public Pedido(List<Produto> produtos, TipoEnvio tipoEnvio) {
        this.produtos = produtos;
        this.tipoEnvio = tipoEnvio;
    }

    public double calcularPesoTotalPedido() {
        double pesoTotal = 0.0;
        
        for (Produto produto : this.produtos) {
            pesoTotal += produto.getPeso();
        }
        return pesoTotal;
    }

    public double calcularValorFrete() throws Exception {
        double pesoTotal = calcularPesoTotalPedido();
        return this.tipoEnvio.calcularFrete(pesoTotal);
    }
}
