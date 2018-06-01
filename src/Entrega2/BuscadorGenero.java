package Entrega2;

import java.util.ArrayList;
import java.util.LinkedList;

public class BuscadorGenero {
	
	//ESTA SERIA EL GRAFO


	private LinkedList<Genero> vertices;
	private int cantidadAristas;
	
	public BuscadorGenero() {
		this.vertices = new LinkedList<Genero>();
		this.cantidadAristas = 0;
	}
	
	public void agregarVertice(Genero vertice) {
		vertices.add(vertice);
	}
	
	public void agregarArista(Genero verticeA, Genero verticeB, int peso) {
		Genero origen = this.obtenerVertice(verticeA);
		Genero destino = this.obtenerVertice(verticeB);
		
		if (origen != null && destino != null) {
			ProximoGenero arista = new ProximoGenero(destino, peso);
			origen.addArista(arista);
			cantidadAristas++;
		}
		else 
			System.out.println("Uno de los vertices no existe");
	}

	public Genero obtenerVertice(Genero v) {
		for (Genero vertice : this.vertices) {
			if (vertice.equals(v)) {
				return vertice;
			}
		}
		return null;
	}

	public ArrayList<Genero> obtenerVertices() {
		ArrayList <Genero> vertices = new ArrayList<Genero>();
		for (Genero vertice : this.vertices) {
			vertices.add(vertice);
		}
		return vertices;
	}

	public Integer getNumVertices() {
		return this.vertices.size();
	}

	public Integer getNumAristas() {
		return this.cantidadAristas;
	}

	public boolean existeArista(Genero verticeA, Genero verticeB) {
//		Vertice origen = this.obtenerVertice(verticeA);
//		Vertice destino = this.obtenerVertice(verticeB);
	//abria que verificar con un hasVertice por ejemplo, si existe el vertice en el grafo	
		if (verticeA.existeArista(verticeB)) {
			return true;
		}
		return false;
	}

	public ArrayList<Genero> obtenerAdyacentes(Genero vertice) {
		ArrayList<Genero> adyacentes = new ArrayList<Genero>();
		//Vertice origen = this.obtenerVertice(vertice);
		//verificar si esta el vertice aca antes, creo q el if de si es null no se tendria q hacer
		if (vertice != null) {
			adyacentes.addAll(vertice.obtenerAdyacentes());
		}
		return adyacentes;
	}
}
