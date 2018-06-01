package Entrega2;

public class ProximoGenero {
	
	//ESTA SERIA LA ARISTA DEL GRAFO
	
	private Genero proximoGenero;
	private int visitas;
	
	public ProximoGenero(Genero proximoGenero) {
		this.proximoGenero = proximoGenero;
		this.visitas = 1;
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
