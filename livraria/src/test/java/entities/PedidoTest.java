package entities;

import enums.TipoEntrega;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {

    @Test
    void calcularPesoTotalPedido() {
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Notebook", 3500.00, 2.5));
        produtos.add(new Produto("Monitor", 900.00, 4.0));
        produtos.add(new Produto("Teclado Mecânico", 450.00, 1.2));

        Pedido pedido = new Pedido(produtos);

        assertEquals(7.7, pedido.calcularPesoTotalPedido(produtos));
    }

    @Test
    void calcularFretePac() throws Exception{
        List<Produto> produtos1 = new ArrayList<>();
        produtos1.add(new Produto("Notebook", 3500.00, 2.5));
        produtos1.add(new Produto("Monitor", 900.00, 4.0));
        produtos1.add(new Produto("Teclado Mecânico", 450.00, 1.2));

        Pedido pedido1 = new Pedido(produtos1);

        double pesoTotal1 = pedido1.calcularPesoTotalPedido(produtos1);
        Exception exception = assertThrows(Exception.class, () -> pedido1.calcularValorFrete(TipoEntrega.PAC, pesoTotal1));

        assertEquals("Não aceitamos entregas maiores que 2kg e nem pedidos sem pesagem!", exception.getMessage());

        List<Produto> produtos2 = new ArrayList<>();
        produtos2.add(new Produto("banana", 7, 0.5));
        produtos2.add(new Produto("papel higienico", 10.0, 0.2));

        Pedido pedido2 = new Pedido(produtos2);

        double pesoTotal2 = pedido2.calcularPesoTotalPedido(produtos2);

        assertEquals(10, pedido2.calcularValorFrete(TipoEntrega.PAC, pesoTotal2));

        List<Produto> produtos3 = new ArrayList<>();
        produtos3.add(new Produto("banana", 15, 1.0));
        produtos3.add(new Produto("papel higienico", 10.0, 0.2));

        Pedido pedido3 = new Pedido(produtos3);

        double pesoTotal3 = pedido3.calcularPesoTotalPedido(produtos3);

        assertEquals(15, pedido3.calcularValorFrete(TipoEntrega.PAC, pesoTotal3));
    }

    @Test
    void calcularFreteSedex() throws Exception {
        List<Produto> produtos1 = new ArrayList<>();
        produtos1.add(new Produto("Notebook", 3500.00, 0));
        produtos1.add(new Produto("Monitor", 900.00, 0));
        produtos1.add(new Produto("Teclado Mecânico", 450.00, 0));

        Pedido pedido1 = new Pedido(produtos1);

        double pesoTotal1 = pedido1.calcularPesoTotalPedido(produtos1);
        Exception exception = assertThrows(Exception.class, () -> pedido1.calcularValorFrete(TipoEntrega.SEDEX, pesoTotal1));
        assertEquals("Não aceitamos pedidos sem pesagem!", exception.getMessage());

        List<Produto> produtos2 = new ArrayList<>();
        produtos2.add(new Produto("banana", 7, 0.4));
        produtos2.add(new Produto("papel higienico", 10.0, 0.1));

        Pedido pedido2 = new Pedido(produtos2);

        double pesoTotal2 = pedido2.calcularPesoTotalPedido(produtos2);
        assertEquals(12.50, pedido2.calcularValorFrete(TipoEntrega.SEDEX, pesoTotal2));

        List<Produto> produtos3 = new ArrayList<>();
        produtos3.add(new Produto("banana", 15, 0.7));
        produtos3.add(new Produto("papel higienico", 10.0, 0.2));

        Pedido pedido3 = new Pedido(produtos3);

        double pesoTotal3 = pedido3.calcularPesoTotalPedido(produtos3);
        assertEquals(20, pedido3.calcularValorFrete(TipoEntrega.SEDEX, pesoTotal3));

        List<Produto> produtos4 = new ArrayList<>();
        produtos4.add(new Produto("item pesado", 100, 1.5));
        produtos4.add(new Produto("item extra", 50, 0.7));

        Pedido pedido4 = new Pedido(produtos4);

        double pesoTotal4 = pedido4.calcularPesoTotalPedido(produtos4);
        double frete4 = 46.50 + ((pesoTotal4 - 1) / 0.1) * 1.5;
        assertEquals(frete4, pedido4.calcularValorFrete(TipoEntrega.SEDEX, pesoTotal4));
    }

    @Test
    void calcularFreteRetirada() throws Exception{
        List<Produto> produtos1 = new ArrayList<>();
        produtos1.add(new Produto("Notebook", 3500.00, 2.5));
        produtos1.add(new Produto("Monitor", 900.00, 4.0));
        produtos1.add(new Produto("Teclado Mecânico", 450.00, 1.2));

        Pedido pedido1 = new Pedido(produtos1);

        double pesoTotal1 = pedido1.calcularPesoTotalPedido(produtos1);


        assertEquals(0, pedido1.calcularValorFrete(TipoEntrega.RETIRADA, pesoTotal1));

        List<Produto> produtos2 = new ArrayList<>();
        produtos2.add(new Produto("banana", 7, 0.5));
        produtos2.add(new Produto("papel higienico", 10.0, 0.2));

        Pedido pedido2 = new Pedido(produtos2);

        double pesoTotal2 = pedido2.calcularPesoTotalPedido(produtos2);

        assertEquals(0, pedido2.calcularValorFrete(TipoEntrega.RETIRADA, pesoTotal2));

        List<Produto> produtos3 = new ArrayList<>();
        produtos3.add(new Produto("banana", 15, 1.0));
        produtos3.add(new Produto("papel higienico", 10.0, 0.2));

        Pedido pedido3 = new Pedido(produtos3);

        double pesoTotal3 = pedido3.calcularPesoTotalPedido(produtos3);

        assertEquals(0, pedido3.calcularValorFrete(TipoEntrega.RETIRADA, pesoTotal3));
    }

    @Test
    public void testCalcularValorPedidoSemTipoEntrega() throws Exception {
        Produto p1 = new Produto("Livro", 20.0, 0.5);
        List<Produto> produtos = Arrays.asList(p1);
        Pedido pedido = new Pedido(produtos);
        double pesoTotal = pedido.calcularPesoTotalPedido(produtos);

        assertEquals(10, pedido.calcularValorFrete(TipoEntrega.PAC, pesoTotal));
        assertEquals(12.50, pedido.calcularValorFrete(TipoEntrega.SEDEX, pesoTotal));
        assertEquals(0, pedido.calcularValorFrete(TipoEntrega.RETIRADA, pesoTotal));

        Exception exception = assertThrows(Exception.class, () -> pedido.calcularValorFrete(null, pesoTotal));
        assertEquals("Forma de retirada invalida", exception.getMessage());
    }
}