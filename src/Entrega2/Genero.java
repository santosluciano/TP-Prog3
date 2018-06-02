package Entrega2;

import java.util.ArrayList;
import java.util.LinkedList;

public class Genero {
	
	//ESTA SERIA EL VERTICE DEL GRAFO

	private String nombre;
	private LinkedList<ProximoGenero> generosVinculados;
	
	public Genero (String nombre) {
		this.nombre = nombre;
		generosVinculados = new LinkedList<ProximoGenero>();
	}
	
	public void addVisitado(Genero generoB) {
		ProximoGenero visitado = this.getProximo(generoB);
		if (visitado == null) {
			ProximoGenero proximo = new ProximoGenero(generoB);
			generosVinculados.add(proximo);	
		}
		else{
			visitado.setVisitas();
		}
	}
	
	public ProximoGenero getProximo(Genero genero) {
		for(ProximoGenero proximo: generosVinculados){
			if(proximo.getProximoGenero().equals(genero))
				return proximo;
		}
		return null;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Genero getGenero() {
		return this;
	}
	
	public boolean existeGenero (Genero siguiente){
		for (ProximoGenero genero : this.generosVinculados) {
			if (genero.getProximoGenero().equals(siguiente)) {
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<Genero> obtenerGenerosVinculados() {
		ArrayList<Genero> vinculados = new ArrayList<Genero>();
		for (ProximoGenero genero : generosVinculados) {
			vinculados.add(genero.getProximoGenero());
		}
		return vinculados;
	}
}