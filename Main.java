package practica2;

//preguntar syncronizwe
public class Main {
	public static void main (String[] args) throws InterruptedException {
		double [] v = new double[2];//Generamos un vector con las dimensiones que queremos
		for(int i = 0; i < v.length; i ++) {//generamos un bucle para rellenar dicho vector
			v[i] = i+1;//por cada iteracion, se sumara 1 al vector
		}
		
		ThreadMultiplicacion[] Multiplicacion = new ThreadMultiplicacion[2];//creamos una lista de procesos  
		double[][] num = new double [2][2]; //y un vector bidimensional (las filas y las columnas)
		
		for(int i = 0; i < num.length; i ++) {//generamos este bucle para rellenar las filas y las columnas
			for(int j = 0; j < num[i].length; j++) {	
				num[i][j] = (int) (Math.random()*100);//rellenamos las casillas con numeros aleatorios
				System.out.println("//columna " + j + "///"+num[i][j]);//para mostrar las filas y columnas antes de la multiplicacion
			}
		}

		for(int i = 0; i < Multiplicacion.length; i ++) {//rellenamos la lista de los procesos con el ThreadMultiplicacion tantas veces como queramos
			Multiplicacion[i] = new ThreadMultiplicacion(num, v, i);//la llamamos y le pasamos los parametros
		}
		
		for(ThreadMultiplicacion threadMultiplicacion : Multiplicacion) {//iniciamos el proceso
			threadMultiplicacion.start();
		}
		
		try {//hacemos que el metodo main espere a que acaben todos los procesos
			for(ThreadMultiplicacion threadMultiplicacion : Multiplicacion) {
				threadMultiplicacion.join();
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
		System.out.println();//mostramos el resultado por pantalla
		for(int i = 0; i < num.length; i++) {
			for(int j = 0; j < num[i].length; j++) {
				System.out.println("//columna " + j + "///"+num[i][j]);
			}
		}
		
		ThreadMostrar Mostrar = new ThreadMostrar(num, v);
		Mostrar.start();
		Mostrar.join();
	}

}
