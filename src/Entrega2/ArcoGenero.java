package Entrega2;

public class ArcoGenero implements Comparable<ArcoGenero>{
	
	//ESTA SERIA LA ARISTA DEL GRAFO
	
	private Genero proximoGenero;
	private int visitas;
	
	public ArcoGenero(Genero proximoGenero) {
		this.proximoGenero = proximoGenero;
		this.visitas = 1;
	}
	
	public int compareTo(ArcoGenero pg) {
		return pg.getVisitas() - this.getVisitas();		
	}

	public Genero getProximoGenero() {
		return proximoGenero;
	}

	public void setProximoGenero(Genero proximoGenero) {
		this.proximoGenero = proximoGenero;
	}

	public int getVisitas() {
		return visitas;
	}

	public void setVisitas() {
		this.visitas++;
	}

}
