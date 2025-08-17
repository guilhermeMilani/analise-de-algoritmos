package entities;

import enums.TipoEntrega;

import java.util.List;

public class Pedido {
	private List<Produto> produtos;

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Pedido(){
	}

	public Pedido(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public double calcularPesoTotalPedido(List<Produto> produtos){
		double pesoTotal = 0.0;
		for(Produto produto : produtos){
			pesoTotal += produto.getPeso();
		}
		return pesoTotal;
	}
	
	public double calcularValorFrete(TipoEntrega tipoEntrega, double pesoPedido) throws Exception{
		if (tipoEntrega == tipoEntrega.PAC){
			return Pac.calcularFrete(pesoPedido);
		}
		if (tipoEntrega == TipoEntrega.RETIRADA) {
			return Retirada.calcularFrete(pesoPedido);
		}
		if (tipoEntrega == TipoEntrega.SEDEX) {
			return  Sedex.calcularFrete(pesoPedido);
		}
		else {
			throw new Exception("Forma de retirada invalida");
		}
	}

}
