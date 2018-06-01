package Entrega2;

import java.util.ArrayList;
import java.util.LinkedList;

public class Genero {
	
	//ESTA SERIA EL VERTICE DEL GRAFO

	
	private String nombre;
	private LinkedList<ProximoGenero> aristas;
	
	public Genero (String nombre) {
		this.nombre = nombre;
		aristas = new LinkedList<ProximoGenero>();
	}
	
	public void addArista(ProximoGenero arista) {
		aristas.add(arista);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Genero getVertice() {
		return this;
	}
	
	public boolean existeArista (Genero destino){
		for (ProximoGenero arista : this.aristas) {
			if (arista.getDestino().equals(destino)) {
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<Genero> obtenerAdyacentes() {
		ArrayList<Genero> adyacentes = new ArrayList<Genero>();
		for (ProximoGenero arista : aristas) {
			adyacentes.add(arista.getDestino());
		}
		return adyacentes;
	}
	
	public boolean equals(Genero v) {
		if(this.getNombre().equals(v.getNombre()))
			return true;
		else
			return false;		
	}

}
