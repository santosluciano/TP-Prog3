package Entrega2;

public class ProximoGenero {
	
	//ESTA SERIA LA ARISTA DEL GRAFO
	
	private Genero destino;
	private int peso;
	
	public ProximoGenero(Genero destino, int peso) {
		this.destino = destino;
		this.peso = peso;
	}

	public Genero getDestino() {
		return destino;
	}

	public void setDestino(Genero destino) {
		this.destino = destino;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

}
