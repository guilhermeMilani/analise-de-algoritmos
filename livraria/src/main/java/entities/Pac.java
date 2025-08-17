package entities;


public class Pac {

	public static double calcularFrete(double peso) throws Exception {
		if (peso <= 1 && peso > 0) {
			return 10;
		}
		else if(peso <= 2){
			return 15;
		}
		else {
			throw new Exception("Não aceitamos entregas maiores que 2kg e nem pedidos sem pesagem!");
		}
	}

}
