package Entrega2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;

public class BuscadorGenero {
	
	//ESTA SERIA EL GRAFO

	private LinkedList<Genero> generos;
	private int cantidadGeneros;
	private HashMap<String,String> estado; 
	private HashMap<String,String> padre;

	public BuscadorGenero() {
		this.generos = new LinkedList<Genero>();
		this.cantidadGeneros = 0;
		this.estado = new HashMap<String,String>();
		this.padre = new HashMap<String,String>();
	}
	
	public void addGenero(String genero) {
		if (!this.hasGenero(genero)) {
			Genero g = new Genero(genero);
			estado.put(genero, "BLANCO");
			padre.put(genero, null);
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
	public LinkedList<Genero> getGeneros() {
		LinkedList <Genero> generos = new LinkedList<Genero>();
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

	public LinkedList<ProximoGenero> getProximos(String genero) {
		Genero g = this.getGenero(genero);
		if (g!=null)
			return g.obtenerGenerosVinculados();
		else
			return null;
	}
	
	public BuscadorGenero getGenerosAfines(String genero) {
		BuscadorGenero afines = new BuscadorGenero();
		this.recorridoGenero(genero);
		for (Entry<String, String>  e:this.estado.entrySet()) {
		    if (e.getValue()=="NEGRO") {
		    	afines.addGenero(e.getKey());
		    }
		}
		return afines;
	}
	
	public void recorridoGenero(String genero) {
		for (Genero g:this.getGeneros()) {
			estado.put(g.getNombre(), "BLANCO");
			padre.put(g.getNombre(), null);
		}
		Genero g = this.getGenero(genero);
		if (g!=null)
			visitarGeneros(g);				
	}
	
	public void visitarGeneros(Genero genero) {
		estado.put(genero.getNombre(), "AMARILLO");
		for (ProximoGenero g:genero.obtenerGenerosVinculados()) {
			if (estado.get(g.getProximoGenero().getNombre()) == "BLANCO") {
				padre.put(g.getProximoGenero().getNombre(), genero.getNombre());
				visitarGeneros(g.getProximoGenero());
			}
		}
		padre.put(genero.getNombre(), "NEGRO");
	}
	
	public 
	 
	public void mostrarBusqueda() {
		for (Genero genero:this.generos) {
			System.out.print(genero.getNombre()+" - ");
			genero.mostrarProximos();
			System.out.println("");
		}
	}
	
}
