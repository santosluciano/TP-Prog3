package Entrega2;

import java.util.ArrayList;
import java.util.LinkedList;

public class BuscadorGenero {
	
	//ESTA SERIA EL GRAFO

	private LinkedList<Genero> generos;
	private int cantidadGeneros;
	
	public BuscadorGenero() {
		this.generos = new LinkedList<Genero>();
		this.cantidadGeneros = 0;
	}
	
	public void addGenero(Genero genero) {
		if (!this.hasGenero(genero)) {
			generos.add(genero);
			cantidadGeneros++;
		}
	}
	
	public boolean hasGenero(Genero generoB) {
		for (Genero genero:this.generos) {
			if (genero.equals(generoB))
				return true;
		}
		return false;
	}
	
	public void addProxGenero(Genero generoA, Genero generoB) {
		if (this.hasGenero(generoA) && this.hasGenero(generoB)) 
			generoA.addVisitado(generoB);
		else 
			System.out.println("Uno de los generos no existe");
	}

	public Genero getGenero(Genero g) {
		for (Genero genero : this.generos) {
			if (genero.equals(g)) {
				return genero;
			}
		}
		return null;
	}

	public ArrayList<Genero> getGeneros() {
		ArrayList <Genero> generos = new ArrayList<Genero>();
		for (Genero genero : this.generos) {
			generos.add(genero);
		}
		return generos;
	}

	public Integer getNumGeneros() {
		return this.cantidadGeneros;
	}

	public boolean existeProximoGenero(Genero generoA, Genero generoB) {
		return generoA.existeGenero(generoB);
	}

	public ArrayList<Genero> obtenerProximos(Genero genero) {
		return genero.obtenerGenerosVinculados();
	}

}
