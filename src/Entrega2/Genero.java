package Entrega2;

import java.util.ArrayList;
import java.util.LinkedList;

public class Genero {
	
	//ESTA SERIA EL VERTICE DEL GRAFO

	private String nombre;
	private LinkedList<ArcoGenero> generosVinculados;
	
	public Genero (String nombre) {
		this.nombre = nombre;
		generosVinculados = new LinkedList<ArcoGenero>();
	}
	
	public void addVisitado(Genero generoB) {
		ArcoGenero visitado = this.getProximo(generoB);
		if (visitado == null) {
			ArcoGenero proximo = new ArcoGenero(generoB);
			generosVinculados.add(proximo);	
		}
		else{
			visitado.setVisitas();
		}
	}
	
	public ArcoGenero getProximo(Genero genero) {
		for(ArcoGenero proximo: generosVinculados){
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
		for (ArcoGenero genero : this.generosVinculados) {
			if (genero.getProximoGenero().equals(siguiente)) {
				return true;
			}
		}
		return false;
	}
	
	public LinkedList<ArcoGenero> obtenerGenerosVinculados() {
		LinkedList<ArcoGenero> vinculados = new LinkedList<ArcoGenero>();
		for (ArcoGenero genero : generosVinculados) {
			vinculados.add(genero);
		}
		return vinculados;
	}
	
	public void mostrarProximos(){
		for (ArcoGenero genero:this.generosVinculados) {
			System.out.print(genero.getProximoGenero().getNombre()+":"+genero.getVisitas()+ " - ");
		}
	}
}
