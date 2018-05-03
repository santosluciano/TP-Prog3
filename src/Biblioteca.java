import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Biblioteca {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Timer temporizador = new Timer();
		BufferedReader linea = new BufferedReader(new InputStreamReader(System.in)); 
		temporizador.start();
		Indice coleccionLibros = new Indice();
		coleccionLibros.cargarLibros("C:\\dataset1.csv");
		System.out.print("El tiempo de carga fue: ");
		System.out.println(temporizador.stop());
		coleccionLibros.mostrarGeneros();
		System.out.println("Ingrese el nombre del genero que desea: ");
		String genero = linea.readLine();
		coleccionLibros.getLibrosGenero(genero,"C:\\salida.csv");
	}

}
