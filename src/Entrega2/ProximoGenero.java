package Entrega2;

public class ProximoGenero implements Comparable<ProximoGenero>{
	
	//ESTA SERIA LA ARISTA DEL GRAFO
	
	private Genero proximoGenero;
	private int visitas;
	
	public ProximoGenero(Genero proximoGenero) {
		this.proximoGenero = proximoGenero;
		this.visitas = 1;
	}
	
	public int compareTo(ProximoGenero pg) {
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
