package practica2;

//preguntar syncronizwe
public class Main {
	public static void main (String[] args) throws InterruptedException {
		double [] vector = new double[3];//Generamos un vector con las dimensiones que queremos
		double [] resultado = new double[3];
		for(int i = 0; i < vector.length; i ++) {//generamos un bucle para rellenar dicho vector
			vector[i] = i+1;
		}
		
		ThreadMultiplicacion[] Multiplicacion = new ThreadMultiplicacion[3];//creamos una lista de procesos  
		double[][] matriz = new double [3][3]; //y un vector bidimensional (las filas y las columnas)
		
		for(int i = 0; i < matriz.length; i ++) {//generamos este bucle para rellenar las filas y las columnas
			for(int j = 0; j < matriz[i].length; j++) {	
				matriz[i][j] = (int) (Math.random()*100);//rellenamos las casillas con numeros aleatorios
			}
		}

		for(int i = 0; i < Multiplicacion.length; i ++) {//rellenamos la lista de los procesos con el ThreadMultiplicacion tantas veces como queramos
			Multiplicacion[i] = new ThreadMultiplicacion(matriz, vector, i, resultado);//la llamamos y le pasamos los parametros
		}
		
		for(ThreadMultiplicacion threadMultiplicacion : Multiplicacion) {//iniciamos el proceso
			threadMultiplicacion.start();
		}
		
		for(ThreadMultiplicacion threadMultiplicacion : Multiplicacion) {
				threadMultiplicacion.join();
			}
		for(int i = 0; i < resultado.length; i++) {
		System.out.println(resultado[i]);
		}//multilicacion
		
		ThreadMostrar Mostrar = new ThreadMostrar(resultado);
		Mostrar.start();
		Mostrar.join();
	}

}
