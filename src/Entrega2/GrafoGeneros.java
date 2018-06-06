package Entrega2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;

public class GrafoGeneros {
	
	//ESTA SERIA EL GRAFO

	private LinkedList<Genero> generos;
	private int cantidadGeneros;
	private HashMap<String,String> estado;
	private HashMap<String,String> padre;
	private static String padreCiclo;
	private static String hijoCiclo;

	public GrafoGeneros() {
		this.generos = new LinkedList<Genero>();
		this.cantidadGeneros = 0;
		this.estado = new HashMap<String,String>();
		this.padre = new HashMap<String,String>();
	}
	
	public void addGenero(String genero) {
		if (!this.hasGenero(genero)) {
			Genero g = new Genero(genero);
			estado.put(genero, "BLANCO");
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

	public LinkedList<ArcoGenero> getProximos(String genero) {
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
	
	public GrafoGeneros getGenerosAfines(String genero) {
		this.initSets();
		LinkedList<ArcoGenero> adyacentes = this.getGenero(genero).obtenerGenerosVinculados();
		int i = 0;
		boolean hayCiclo = false;
		while (i < adyacentes.size() && !hayCiclo) {
			if (this.estado.get(adyacentes.get(i).getProximoGenero().getNombre()) == "BLANCO"){
				hayCiclo = hayCiclo(genero);
			}
			i++;
		}
		if (hayCiclo) {
			GrafoGeneros afines = new GrafoGeneros();
			this.padre.put(padreCiclo, hijoCiclo);
			afines.addGenero(padreCiclo);
			String gen = this.padre.get(padreCiclo);
			while (!gen.equals(padreCiclo)) {
				afines.addGenero(gen);
				gen = this.padre.get(gen);
			}
			return afines;
		}
		return null;
	}
	
	private boolean hayCiclo(String genero) {
		this.estado.put(genero,"AMARILLO");
		LinkedList<ArcoGenero> adyacentes = this.getGenero(genero).obtenerGenerosVinculados();		
		boolean hayCiclo = false;
		int i = 0;
		while (i < adyacentes.size() && !hayCiclo) {
			if (this.estado.get(adyacentes.get(i).getProximoGenero().getNombre()) == "BLANCO") {
				hayCiclo = hayCiclo(adyacentes.get(i).getProximoGenero().getNombre());
			}else if (this.estado.get(adyacentes.get(i).getProximoGenero().getNombre()) == "AMARILLO") {
					padreCiclo = adyacentes.get(i).getProximoGenero().getNombre();
					hijoCiclo = genero;
					hayCiclo = true;
				}
			this.padre.put(adyacentes.get(i).getProximoGenero().getNombre(), genero);
			i++;
		}
		this.estado.put(genero, "NEGRO");
//		System.out.println(genero);
		return hayCiclo;
	}
		
	private void initSets() {
		for (Genero g:this.getGeneros()) {
			estado.put(g.getNombre(), "BLANCO");
			padre.put(g.getNombre(), null);
		}
	}
	
	private void recorridoGenero(String genero) {
		this.initSets();
		Genero g = this.getGenero(genero);
		if (g!=null)
			visitarGeneros(g);				
	}
	
	private void visitarGeneros(Genero genero) {
		estado.put(genero.getNombre(), "AMARILLO");
		for (ArcoGenero g:genero.obtenerGenerosVinculados()) {
			if (estado.get(g.getProximoGenero().getNombre()) == "BLANCO") {
				visitarGeneros(g.getProximoGenero());
			}
		}
		estado.put(genero.getNombre(), "NEGRO");
	}
			 
	public void mostrarBusqueda() {
		for (Genero genero:this.generos) {
			System.out.print(genero.getNombre()+" - ");
			genero.mostrarProximos();
			System.out.println("");
		}
	}
	
}
