package practica2;

public class ThreadMostrar extends Thread{
		private int [][] resultadoMatriz;
		private double [] modulo;
		
	public ThreadMostrar(int[][] resultadoMatriz, double[] modulo) {
		this.resultadoMatriz = resultadoMatriz;
		this.modulo = modulo;
	}
		
	public void run() {
		for(int i = 0; i < resultadoMatriz.length; i++) {
			int v = 0;
			for(int j = 0; j < resultadoMatriz[i].length; j ++) {
				v = v + resultadoMatriz[i][j];
			}
			modulo[i] = v * v;
		}
		double suma = 0;
		for(int i = 0; i < modulo.length; i ++) {
			suma = suma + modulo[i];
		}
			System.out.println("modulo del vector: ");
	}

}

