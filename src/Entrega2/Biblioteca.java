package Entrega2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Biblioteca {

	public static void main(String[] args) throws IOException {					
		
		BufferedReader linea = new BufferedReader(new InputStreamReader(System.in)); 
		Indice busqueda = new Indice();
		System.out.print("Ingrese el nombre del archivo (csv) y su ruta contando como raiz el c: ");
		busqueda.cargarBusquedas("C:\\"+linea.readLine()+".csv");
//		System.out.println("Mas buscados despues viajes: ");
//		System.out.println("");
//		
//		busqueda.getMasBuscados("viajes");
//		System.out.println("");
//		System.out.println("Mas buscado post viajes: ");
		System.out.println("");

		busqueda.getGenerosAfines("viajes");
		System.out.println("");

//		System.out.println("Los 3 Generos mas buscados luego de viajes: ");
//		System.out.println("");
		//busqueda.getMasBuscados("viajes",3);
		
		
//		String opcion = "y";
//		do {
//			if (opcion.equals("y")){
//				if (!busqueda.isEmptyBuscador()) {
//					System.out.println("\nGeneros que contiene el indice\n");			
//					busqueda.mostrarGeneros();
//					System.out.print("\nIngrese el nombre del genero que desea: ");
//					String genero = linea.readLine();
//					
//
//					//GENERAR RESULTADO DE BUSQUEDA SEGUN OPCIONES....
//					
//					
//					System.out.println("Desea realizar otra busqueda? y/n");
//					opcion = linea.readLine();
//				}
//				else {
//					System.out.println("No hay busquedas realizadas.");
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
