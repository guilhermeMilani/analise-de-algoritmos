package entities;

public class Sedex  {

	public static double calcularFrete(double peso) throws Exception {
		if (peso <= 0 ) {
			throw new Exception("Não aceitamos pedidos sem pesagem!");
		}
		else if (peso <= 0.5) {
			return 12.50;
		}else if(peso <= 1 ) {
			return 20;
		}  else {
			 double pesoSobra = peso - 1;
			 double valorAdicional = (pesoSobra / 0.1) * 1.5;
            return 46.50 + valorAdicional;
		}
	}

}
