package practica2;

public class ThreadModulo extends Thread {
	private long start = System.currentTimeMillis();
	private double[] resultadoMatriz;
	private ThreadMultiplicacion[] multiplicacion ;
	/*
	 * Pre:---
	 * Post: Constructor del Thread Mostrar
	 */
	public ThreadModulo(double[] resultadoMatriz, ThreadMultiplicacion[] multiplicacion) {
		this.resultadoMatriz = resultadoMatriz;
		this.multiplicacion = multiplicacion;
	}
	
	/*
	 * Pre:---
	 * Post: Calculo del modulo del vector
	 */
	public void run() {
		for (int i = 0; i < resultadoMatriz.length; i++) {
			resultadoMatriz[i] = resultadoMatriz[i] * resultadoMatriz[i];
		}
		
		double suma = 0;
		for (int i = 0; i < resultadoMatriz.length; i++) {
			suma = suma + resultadoMatriz[i];
		}
		
		double raiz = Math.sqrt(suma);
		
		System.out.println("modulo del vector: " + raiz);
		
		long end = System.currentTimeMillis();
		long elapsedTime = end - start;
		
		
		long min = elapsedTime;
		long max = elapsedTime;
		for(int i = 0; i < multiplicacion.length; i ++) {
			if(min > multiplicacion[i].getTiempo()) {
				min = multiplicacion[i].getTiempo();
			}
			
			if(max < multiplicacion[i].getTiempo()) {
				max = multiplicacion[i].getTiempo();
			}
				
		}
		
		System.out.println("Tiempo de ejecucion del Modulo: " + elapsedTime + " mm");
		System.out.println("Thread mas lento: " + max + " mm");
		System.out.println("Thread mas rapido: " + min + " mm");
	}
	

}
