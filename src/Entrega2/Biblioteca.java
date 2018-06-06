package Entrega2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Biblioteca {

	public static void main(String[] args) throws IOException {					
		
		BufferedReader linea = new BufferedReader(new InputStreamReader(System.in)); 
		Indice coleccionLibros = new Indice();
		System.out.print("Ingrese el nombre del archivo (csv) y su ruta contando como raiz el c: ");
		coleccionLibros.cargarBusquedas("C:\\"+linea.readLine()+".csv");
		coleccionLibros.getGenerosAfines("drama");
		//coleccionLibros.getBuscadosPostGenero("viajes");
		//coleccionLibros.getMasBuscados("viajes",3);
		
		
		
		
//		coleccionLibros.cargarLibros("C:\\"+linea.readLine()+".csv");
//		String opcion = "y";
//		do {
//			if (opcion.equals("y")){
//				if (!coleccionLibros.isEmpty()) {
//					System.out.println("\nGeneros que contiene el indice\n");			
//					coleccionLibros.mostrarGeneros();
//					System.out.print("\nIngrese el nombre del genero que desea: ");
//					String genero = linea.readLine();
//					System.out.print("Ingrese el nombre del archivo de salida y su ruta contando como raiz el c: ");			
//					coleccionLibros.getLibrosGenero(genero,"C:\\"+linea.readLine()+".csv");
//					System.out.println("Desea generar otro archivo? y/n");
//					opcion = linea.readLine();
//				}
//				else {
//					System.out.println("No hay libros en memoria.");
//					opcion = "n";
//				}
//			} else {
//				System.out.println("Opcion invalida.");
//				System.out.println("Desea generar otro archivo? y/n");
//				opcion = linea.readLine();
//				System.out.println(opcion);
//			}
//		} while (!opcion.equals("n"));
					
	}

}
