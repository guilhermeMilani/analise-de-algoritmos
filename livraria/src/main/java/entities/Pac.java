package entities;

public class Pac implements TipoEnvio {

    @Override
    public double calcularFrete(double peso) throws Exception {
        if (peso <= 1 && peso > 0) {
            return 10;
        }
        if (peso <= 2) {
            return 15;
        }
        throw new Exception("Não aceitamos entregas maiores que 2kg e nem pedidos sem pesagem!");
    }
}
