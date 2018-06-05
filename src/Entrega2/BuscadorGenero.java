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
	
	public LinkedList<String> getPostGenero(String genero) {
		LinkedList<String> postGeneros = new LinkedList<String>();
		this.recorridoGenero(genero);
		for (Entry<String, String>  e:this.estado.entrySet()) {
		    if (e.getValue()=="NEGRO") {
		    	postGeneros.add(e.getKey());
		    }
		}
		return postGeneros;
	}
	
	private void recorridoGenero(String genero) {
		for (Genero g:this.getGeneros()) {
			estado.put(g.getNombre(), "BLANCO");
		//	padre.put(g.getNombre(), null);
		}
		Genero g = this.getGenero(genero);
		if (g!=null)
			visitarGeneros(g);				
	}
	
	private void visitarGeneros(Genero genero) {
		estado.put(genero.getNombre(), "AMARILLO");
		for (ProximoGenero g:genero.obtenerGenerosVinculados()) {
			if (estado.get(g.getProximoGenero().getNombre()) == "BLANCO") {
			  //padre.put(g.getProximoGenero().getNombre(), genero.getNombre());
				visitarGeneros(g.getProximoGenero());
			}
		}
		estado.put(genero.getNombre(), "NEGRO");
	}
	
	public BuscadorGenero
	
	DFS_Ciclo(grafo G)
	PARA CADA vértice v HACER
	estado[v] = BLANCO
	padre[v] = NULO
	adyacentes ← Vecinos[v]
	MIENTRAS i<adyacentes.size Y NO hayCiclo
	SI estado[adyacentes[i]] = BLANCO ENTONCES
	hayCiclo = Hay_Ciclo(v)
	Hay_Ciclo(nodo v)
	estado[v] = AMARILLO
	adyacentes = Vecinos[v]
	hayCiclo = NO
	MIENTRAS i<adyacentes.size Y NO nayCiclo HACER
	SI estado[v] = BLANCO
	hayCiclo = Hay_Ciclo(adyacente[i])
	SINO
	SI estado[v] = AMARILLO
	hayCilco = SI

	estado[v] = NEGRO
	RETURN hayCiclo
		 
	public void mostrarBusqueda() {
		for (Genero genero:this.generos) {
			System.out.print(genero.getNombre()+" - ");
			genero.mostrarProximos();
			System.out.println("");
		}
	}
	
}
