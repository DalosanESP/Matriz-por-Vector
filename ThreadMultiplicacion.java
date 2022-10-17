package practica2;

public class ThreadMultiplicacion extends Thread{//creamos el metodo constructor
	private double [][] matriz; //le pasamos la matriz (filas y columnas)
	private double [] vector; //y el vector por el cual vamos a multiplicar la matriz
	private int posicion;//un valor que será la posicion, para que los resultados salgan de manera ordenada
	
	
public ThreadMultiplicacion(double[][] matriz, double[] vector, int posicion ) {
	this.matriz = matriz;
	this.vector = vector;
	this.posicion = posicion;
	
}
	
public void run() {
	//multiplicamos la matriz por el vector
	for(int i = posicion; i < posicion + 1; i++){
			for(int j = 0; j < matriz[i].length; j ++) {
				matriz[i][j] = matriz[i][j] * vector[j];
			}
			i = i +1;
		}
	}
}
