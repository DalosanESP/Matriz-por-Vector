package practica2;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		DatosCompartidos dc = new DatosCompartidos();
		
		//Generamos una lista de threads para multiplicar la matriz por el vector
		ThreadMultiplicacion[] Multiplicacion = new ThreadMultiplicacion[16];
		
		//Con los datos de DatosCompartidos instanciamos el vector y la matriz
		dc.rellenar();
		
		//Creamos un numero de procesos que sea equivalente a la longitud del vector
		int posicionInicial = 0;
		int posicionFinal = 32;
		for (int i = 0; i < Multiplicacion.length; i++) {							
			Multiplicacion[i] = new ThreadMultiplicacion( dc, posicionInicial,posicionFinal);
			posicionInicial += 32;
			posicionFinal += 32;
		}
		
		//Iniciamos los threads
		for (ThreadMultiplicacion threadMultiplicacion : Multiplicacion) {
			threadMultiplicacion.start();
		}
		
		//Esperamos a que todo acaben para que el main continue
		for (ThreadMultiplicacion threadMultiplicacion : Multiplicacion) {
			threadMultiplicacion.join();
		} 

		//Instanciamos Mostrar, lo iniciamos y esperamos a que acabe para que el main continue
		ThreadModulo Modulo = new ThreadModulo(dc.resultado, Multiplicacion);
		Modulo.start();
		Modulo.join();
	}
}

