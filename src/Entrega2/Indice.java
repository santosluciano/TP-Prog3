package Entrega2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Indice {
	
	private String genero;
	private LinkedList<Libro> libros;
	private BuscadorGenero buscador;
	private Indice izq;
	private Indice der;
	
	public Indice() {
		this.genero = null;
		this.libros = new LinkedList<Libro>();
		this.izq = null;
		this.der = null;
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
	
	//Carga los libros de un archivo, y genera un indice con los generos que contiene
	public void cargarLibros(String csvFile) {

        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
        	//Salta la primer linea que contiene los titulos
        	br.readLine();
            while ((line = br.readLine()) != null) {
                String[] items = line.split(cvsSplitBy);
                //Genera un nuevo libro con titulo, autor, numero de paginas
                Libro libro = new Libro(items[0],items[1],items[2]);
                //Separa los generos
                String[] generos = items[3].split(" ");
                //Se los agrega al libro
                for (String genero:generos) {
                	libro.addGenero(genero);
                }
                //Agrega el libro a la lista de la coleccion de libros
            	//Referencia a los libros de la coleccion en el indice
                this.insertLibro(libro);
            }
            System.out.println("Se cargaron los libros.");
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void insertLibro(Libro libro) {		
		for (String genero:libro.getGeneros()) {
			insertLibro(libro,genero);
		}
	}
	
	private void insertLibro(Libro libro, String genero) {
		if (this.genero == null) {
			this.genero = genero;
			libros.add(libro);
		}else {
			if (this.genero.equals(genero)) {
				this.libros.add(libro);
			} else if (this.genero.compareTo(genero)>0) {
				if (this.izq != null) {
					this.izq.insertLibro(libro,genero);	
				}
				else {
					this.izq = new Indice();
					this.izq.insertLibro(libro,genero);
				}
			} else {
				if (this.der != null) {
					this.der.insertLibro(libro,genero);
				}
				else {
					this.der = new Indice();
					this.der.insertLibro(libro,genero);
				}
			}
		}
	}
	
	public void getLibrosGenero(String genre, String csvFile) {
		LinkedList<Libro> libros = this.getLibros(genre);
		BufferedWriter bw = null;
		try {
			File file = new File(csvFile);
			if (!file.exists()) {
				file.createNewFile();
			}
			
			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			
			// Escribo la primer linea del archivo
			bw.write("Titulo");
			bw.newLine();

			// Escribo la segunda linea del archivo
			if (libros != null) {
				for(Libro libro:libros) {
					bw.write(libro.getTitulo());
					bw.newLine();
				}
			}
			System.out.println("Se genero el archivo de salida con los libros del genero "+genre);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
			} catch (Exception ex) {
				System.out.println("Error cerrando el BufferedWriter" + ex);
			}
		}
	}
	
	public LinkedList<Libro> getLibros(String genero){
		if (this.genero.equals(genero)) {
			return this.libros;
		} else if (this.genero.compareTo(genero)>0) {
			if (this.izq != null) {
				return this.izq.getLibros(genero);
			} else {
				return null;
			}
		} else {
			if (this.der != null) {
				return this.der.getLibros(genero);
			} else {
				return null;
			}				
		}
	}	
	
	public void mostrarGeneros() {
		if (this.izq != null) {
			izq.mostrarGeneros();
		}
		System.out.println(this.genero);
		if (this.der!=null) {
			der.mostrarGeneros();
		}
	}
	
	public boolean isEmpty() {
		return (this.genero == null);
	}

}
