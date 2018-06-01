package Entrega2;

import java.util.ArrayList;
import java.util.LinkedList;

public class BuscadorGenero {
	
	//ESTA SERIA EL GRAFO


	private LinkedList<Genero> generos;
	private int cantidadGenerosVinculados;
	
	public BuscadorGenero() {
		this.generos = new LinkedList<Genero>();
		this.cantidadGenerosVinculados = 0;
	}
	
	public void agregarVertice(Genero vertice) {
		generos.add(vertice);
	}
	
	public void agregarArista(Genero generoA, Genero generoB) {
		Genero origen = this.obtenerVertice(generoA);
		Genero destino = this.obtenerVertice(generoB);
		
		if (origen != null && destino != null) {
			origen.addVisitado(destino);
			cantidadGenerosVinculados++;
		}
		else 
			System.out.println("Uno de los vertices no existe");
	}

	public Genero obtenerVertice(Genero v) {
		for (Genero vertice : this.generos) {
			if (vertice.equals(v)) {
				return vertice;
			}
		}
		return null;
	}

	public ArrayList<Genero> obtenerVertices() {
		ArrayList <Genero> vertices = new ArrayList<Genero>();
		for (Genero vertice : this.generos) {
			vertices.add(vertice);
		}
		return vertices;
	}

	public Integer getNumGeneros() {
		return this.generos.size();
	}

	public Integer getNumGenerosVinculados() {
		return this.cantidadGenerosVinculados;
	}

	public boolean existeArista(Genero generoA, Genero generoB) {
//		Vertice origen = this.obtenerVertice(verticeA);
//		Vertice destino = this.obtenerVertice(verticeB);
	//abria que verificar con un hasVertice por ejemplo, si existe el vertice en el grafo	
		if (generoA.existeGenero(generoB)) {
			return true;
		}
		return false;
	}

	public ArrayList<Genero> obtenerAdyacentes(Genero genero) {
		ArrayList<Genero> vinculados = new ArrayList<Genero>();
		//Vertice origen = this.obtenerVertice(vertice);
		//verificar si esta el vertice aca antes, creo q el if de si es null no se tendria q hacer
		if (genero != null) {
			vinculados.addAll(genero.obtenerGenerosVinculados());
		}
		return vinculados;
	}
}
