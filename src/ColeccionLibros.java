import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class ColeccionLibros {
	
	private Indice librosXGenero;
	private LinkedList<Libro> listaLibros;
	
	public ColeccionLibros() {
		this.librosXGenero = new Indice();
		this.listaLibros = new LinkedList<Libro>();
	}
	
	public void verGeneros() {
		this.librosXGenero.mostrarGeneros();
	}
	
	public void getLibrosGenero(String genre, String csvFile) {
		LinkedList<Libro> libros = this.librosXGenero.getLibros(genre);
		BufferedWriter bw = null;
		try {
			File file = new File(csvFile);
			if (!file.exists()) {
				file.createNewFile();
			}
			
			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			
			// Escribo la primer linea del archivo
			String contenidoLinea1 = "Titulo,Autor,Paginas,Generos";
			bw.write(contenidoLinea1);
			bw.newLine();

			// Escribo la segunda linea del archivo
			if (libros != null) {
				for(Libro libro:libros) {
					String contenidoLinea = libro.getTitulo()+","+libro.getAutor()+","+libro.getCantidadPaginas()+",";
					for (String genero:libro.getGeneros()) {
						contenidoLinea += genero+" ";
					}
					bw.write(contenidoLinea);
					bw.newLine();
				}
			}
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
                this.listaLibros.add(libro);
            	//Referencia a los libros de la coleccion en el indice
                this.librosXGenero.insertLibro(libro);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
