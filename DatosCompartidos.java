package practica2;

public class DatosCompartidos {
	double vector[];
	double matriz[][];
	double resultado[];
	
	// Aqui vamos a generar los datos que vamos a usar durante el programa
	public DatosCompartidos() {
		this.vector = new double[512];
		this.matriz = new double[512][512];
		this.resultado = new double [512];
	}
	
	//Generamos los getters and setters para poder utilizar los datos
	public double[] getVector() {
		return vector;
	}

	public void setVector(double[] vector) {
		this.vector = vector;
	}

	public double[][] getMatriz() {
		return matriz;
	}

	public void setMatriz(double[][] matriz) {
		this.matriz = matriz;
	}

	public double[] getResultado() {
		return resultado;
	}

	public void setResultado(double[] resultado) {
		this.resultado = resultado;
	}

	//Aqui vamos a rellenar vector y matriz
	public void rellenar() {
		for (int i = 0; i < vector.length; i++) {
			vector[i] = i + 1;
		}
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = (int) (Math.random() * 100);
			}
		}
	}
}
