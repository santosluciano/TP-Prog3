import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class ColeccionLibros {
	
	Indice librosXGenero;
	LinkedList<Libro> listaLibros;
	
	public ColeccionLibros() {
		this.librosXGenero = new Indice();
		this.listaLibros = new LinkedList<Libro>();
	}
	
	public void getLibrosGenero() {
		LinkedList<Libro> libros = this.librosXGenero.getLibros("");
		BufferedWriter bw = null;
		try {
			File file = new File("C:\\salida.csv");
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
			for(Libro libro:libros) {
				String contenidoLinea = libro.getTitulo()+","+libro.getAutor()+","+libro.getCantidadPaginas()+",";
				for (String genero:libro.getGeneros()) {
					contenidoLinea += genero+"-";
				}
				bw.write(contenidoLinea);
				bw.newLine();
			}
			
			/*
			 *
			 * ... 
			 * 
			*/

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
	
	public void cargarLibros() {
        String csvFile = "C:\\dataset4.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
        	br.readLine();
            while ((line = br.readLine()) != null) {

                String[] items = line.split(cvsSplitBy);
                Libro libro = new Libro(items[0],items[1],items[2]);
                String[] generos = items[3].split(" ");
                for (String genero:generos) {
                	libro.addGenero(genero);
                }
                this.listaLibros.add(libro);
            	this.librosXGenero.insertLibro(libro);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
