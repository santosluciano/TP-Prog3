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
	
	public void addGenero(String genero) {
		if (!this.hasGenero(genero)) {
			Genero g = new Genero(genero);
			generos.add(g);
			cantidadGeneros++;
		}
	}
	
	public boolean hasGenero(String generoB) {
		for (Genero genero:this.generos) {
			if (genero.getNombre().equals(generoB))
				return true;
		}
		return false;
	}
	
	public void addProxGenero(String generoA, String generoB) {
		Genero gA = this.returnGenero(generoA); 
		Genero gB = this.returnGenero(generoB);
		gA.addVisitado(gB);
	}

	public Genero returnGenero(String g) {
		for (Genero genero : this.generos) {
			if (genero.getNombre().equals(g)) {
				return genero;
			}
		}
		Genero nuevoGenero = new Genero(g);
		this.generos.add(nuevoGenero);
		return nuevoGenero;
	}
	
	public Genero getGenero(String g) {
		for (Genero genero : this.generos) {
			if (genero.getNombre().equals(g)) {
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

	public ArrayList<ProximoGenero> getProximos(String genero) {
		Genero g = this.getGenero(genero);
		if (g!=null)
			return g.obtenerGenerosVinculados();
		else
			return null;
	}
	
	public void mostrarBusqueda() {
		for (Genero genero:this.generos) {
			System.out.print(genero.getNombre()+" - ");
			genero.mostrarProximos();
			System.out.println("");
		}
	}

}
