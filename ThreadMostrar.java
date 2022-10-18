package practica2;


public class ThreadMostrar extends Thread{
		private double [] resultadoMatriz;
		
	public ThreadMostrar(double[] resultadoMatriz) {
		this.resultadoMatriz = resultadoMatriz;
	}
		
	public void run() {
		for(int i = 0; i < resultadoMatriz.length; i++) {
			resultadoMatriz[i] = resultadoMatriz[i] * resultadoMatriz[i];
		}
		double suma = 0;
		for(int i = 0; i < resultadoMatriz.length; i ++) {
			suma = suma + resultadoMatriz[i];
			System.out.println(suma);
		}
		double raiz = Math.sqrt(suma);
		System.out.println("modulo del vector: " + raiz);
	}

}
