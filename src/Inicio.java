import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Inicio {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader linea = new BufferedReader(new InputStreamReader(System.in)); 
		ColeccionLibros biblioteca = new ColeccionLibros();
		biblioteca.cargarLibros("C:\\dataset1.csv");
		biblioteca.verGeneros();
		System.out.println("Ingrese el nombre del genero que desea: ");
		String genero = linea.readLine();
		biblioteca.getLibrosGenero(genero,"C:\\salida.csv");
	}

}
