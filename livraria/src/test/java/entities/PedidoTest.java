package entities;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {

    @Test
    void calcularPesoTotalPedido() {
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Notebook", 3500.00, 2.5));
        produtos.add(new Produto("Monitor", 900.00, 4.0));
        produtos.add(new Produto("Teclado Mecânico", 450.00, 1.2));

        Pedido pedido = new Pedido(produtos, new Pac());

        assertEquals(7.7, pedido.calcularPesoTotalPedido());
    }

    @Test
    void calcularFretePacErro() throws Exception {
        List<Produto> produtos1 = new ArrayList<>();
        produtos1.add(new Produto("Notebook", 3500.00, 2.5));
        produtos1.add(new Produto("Monitor", 900.00, 4.0));
        produtos1.add(new Produto("Teclado Mecânico", 450.00, 1.2));

        Pedido pedido1 = new Pedido(produtos1, new Pac());

        Exception exception = assertThrows(Exception.class, () -> pedido1.calcularValorFrete());

        assertEquals("Não aceitamos entregas maiores que 2kg e nem pedidos sem pesagem!", exception.getMessage());
    }

    @Test
    void calcularFretePacSucesso10Reais() throws Exception{

        List<Produto> produtos2 = new ArrayList<>();
        produtos2.add(new Produto("banana", 7, 0.5));
        produtos2.add(new Produto("papel higienico", 10.0, 0.2));

        Pedido pedido2 = new Pedido(produtos2, new Pac());

        assertEquals(10, pedido2.calcularValorFrete());
    }

    @Test
    void calcularFretePacSucesso15Reis() throws Exception{
        List<Produto> produtos3 = new ArrayList<>();
        produtos3.add(new Produto("banana", 15, 1.0));
        produtos3.add(new Produto("papel higienico", 10.0, 0.2));

        Pedido pedido3 = new Pedido(produtos3, new Pac());

        assertEquals(15, pedido3.calcularValorFrete());
    }

    @Test
    void calcularFreteSedexErro() throws Exception {
        List<Produto> produtos1 = new ArrayList<>();
        produtos1.add(new Produto("Notebook", 3500.00, 0));
        produtos1.add(new Produto("Monitor", 900.00, 0));
        produtos1.add(new Produto("Teclado Mecânico", 450.00, 0));

        Pedido pedido1 = new Pedido(produtos1, new Sedex());

        Exception exception = assertThrows(Exception.class, () -> pedido1.calcularValorFrete());
        assertEquals("Não aceitamos pedidos sem pesagem!", exception.getMessage());
    }
    
    @Test
    void calcularFreteSedexSucesso1250() throws Exception {
    List<Produto> produtos2 = new ArrayList<>();
        produtos2.add(new Produto("banana", 7, 0.4));
        produtos2.add(new Produto("papel higienico", 10.0, 0.1));

        Pedido pedido2 = new Pedido(produtos2, new Sedex());

        assertEquals(12.50, pedido2.calcularValorFrete());
    }
    
    
    @Test
    void calcularFreteSedexSucesso20() throws Exception {
        List<Produto> produtos3 = new ArrayList<>();
        produtos3.add(new Produto("banana", 15, 0.7));
        produtos3.add(new Produto("papel higienico", 10.0, 0.2));

        Pedido pedido3 = new Pedido(produtos3, new Sedex());

        assertEquals(20, pedido3.calcularValorFrete());
    }
    
        
    @Test
    void calcularFreteSedexSucessoValorExtra() throws Exception {
        List<Produto> produtos4 = new ArrayList<>();
        produtos4.add(new Produto("item pesado", 100, 1.5));
        produtos4.add(new Produto("item extra", 50, 0.7));

        Pedido pedido4 = new Pedido(produtos4, new Sedex());

        double pesoTotal4 = pedido4.calcularPesoTotalPedido();
        double frete4 = 46.50 + ((pesoTotal4 - 1) / 0.1) * 1.5;
        assertEquals(frete4, pedido4.calcularValorFrete());
    }

    @Test
    void calcularFreteRetirada() throws Exception {
        List<Produto> produtos1 = new ArrayList<>();
        produtos1.add(new Produto("Notebook", 3500.00, 2.5));
        produtos1.add(new Produto("Monitor", 900.00, 4.0));
        produtos1.add(new Produto("Teclado Mecânico", 450.00, 1.2));

        Pedido pedido1 = new Pedido(produtos1, new Retirada());

        assertEquals(0, pedido1.calcularValorFrete( ));
    }
}
