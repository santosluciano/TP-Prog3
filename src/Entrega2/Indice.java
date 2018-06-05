package Entrega2;
import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;

public class Indice {
	
	private BuscadorGenero buscador;
	
	public Indice() {
		this.buscador = new BuscadorGenero();
	}
	
	public void cargarBusquedas(String csvFile) {

        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
         	br.readLine();
            while ((line = br.readLine()) != null) {
                String[] generos = line.split(cvsSplitBy);
                if (generos.length != 1) {
	                for (int i=0;i<generos.length-1;i++) {
	                	buscador.addProxGenero(generos[i], generos[i+1]);
	                }
                }else
                	buscador.addGenero(generos[0]);                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public LinkedList<String> getMasBuscados(String genero, int cantidad) {
		LinkedList<ProximoGenero> buscados = this.buscador.getProximos(genero);
		LinkedList<String> retorno = new LinkedList<String>();
		if (buscados != null) {
			Collections.sort(buscados);
			for (int i = 0; i<cantidad && i<buscados.size(); i++) {	
				retorno.add(buscados.get(i).getProximoGenero().getNombre());
				System.out.println(buscados.get(i).getProximoGenero().getNombre());
			}
		}
		return retorno;
	}
	
	
	public LinkedList<String> getBuscadosPostGenero(String genero){
		LinkedList<String> generos = this.buscador.getPostGenero(genero); 
		for (String g:generos) {
			System.out.println(g);
		}
		return generos;
	}
	
	public LinkedList<String> getMasBuscados(String genero) {
		LinkedList<ProximoGenero> buscados = this.buscador.getProximos(genero);
		LinkedList<String> retorno = new LinkedList<String>();
		if (buscados != null) {
			for (ProximoGenero g:buscados){
				retorno.add(g.getProximoGenero().getNombre());
				System.out.println(g.getProximoGenero().getNombre()+":"+g.getVisitas());
			}
		}
		return retorno;
	}
	
	public LinkedList<String> getGenerosAfines(String genero) {
		BuscadorGenero grafoafines = this.buscador.getGenerosAfines(genero);
		LinkedList<Genero> afines = grafoafines.getGeneros();
		LinkedList<String> retorno = new LinkedList<String>();
		for (Genero g:afines) {
			retorno.add(g.getNombre());
			System.out.println(g.getNombre());			
		}
		return retorno;
	}
	
	
	public void mostrarGeneros() {

	}
	
	public boolean isEmpty() {
		return false;
	}

}
