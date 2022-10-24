package practica2;

public class ThreadMultiplicacion extends Thread {
	long start = System.currentTimeMillis();
	private int posicionInicial;
	private int posicionFinal;
	private DatosCompartidos dc;
	private long tiempo;

	/*
	 * Pre:---
	 * Post: Constructor de ThreadMultiplicacion
	 */
	public ThreadMultiplicacion( DatosCompartidos dc, int posicionInicial, int posicionFinal) {
		this.dc = dc;
		this.posicionInicial = posicionInicial;
		this.posicionFinal = posicionFinal;
	}

	/*
	 * Pre:---
	 * Post: Multiplicacion de la matriz por el vector
	 */
	public void run() {
		for (int i = posicionInicial; i < posicionFinal; i++) {
			for (int j = 0; j < dc.matriz[i].length; j++) {
				dc.resultado[i] = dc.matriz[i][j] * dc.vector[j] + dc.resultado[i];
			}
		}
		long end = System.currentTimeMillis();
		long elapsedTime = end - start;
		tiempo = elapsedTime;
	}
	
	//Getters and Setters
	public long getStart() {
		return start;
	}

	public void setStart(long start) {
		this.start = start;
	}

	public int getPosicionInicial() {
		return posicionInicial;
	}

	public void setPosicionInicial(int posicionInicial) {
		this.posicionInicial = posicionInicial;
	}

	public int getPosicionFinal() {
		return posicionFinal;
	}

	public void setPosicionFinal(int posicionFinal) {
		this.posicionFinal = posicionFinal;
	}

	public DatosCompartidos getDc() {
		return dc;
	}
	
	public void setDc(DatosCompartidos dc) {
		this.dc = dc;
	}

	public long getTiempo() {
		return tiempo;
	}

	public void setTiempo(long tiempo) {
		this.tiempo = tiempo;
	}

}
