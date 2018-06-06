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
		System.out.println("1.Buscar N generos mas buscados");
		System.out.println("2.Buscar generos buscados luego de Genero A");
		System.out.println("3.Buscar generos afines");
		System.out.println("4.Salir");
		System.out.print("Ingrese la opcion deseada: ");
		String opcion = linea.readLine();
		String genero = "";
		do {
			switch (opcion) {
	        	case "1":
	        		System.out.print("Ingrese el genero A: ");
	        		genero = linea.readLine();
	        		System.out.print("Ingrese N: ");
	        		int n = Integer.parseInt(linea.readLine());
	        		coleccionLibros.getMasBuscados(genero,n);
	        		System.out.println("");
	        		break;
	        	case "2":
	        		System.out.println("Ingrese el genero A: ");
	        		genero = linea.readLine();
	        		coleccionLibros.getBuscadosPostGenero(genero);
	        		System.out.println("");
	        		break;
	        	case "3":
	        		System.out.println("Ingrese el genero raiz: ");
	        		genero = linea.readLine();
	        		coleccionLibros.getGenerosAfines(genero);
	        		System.out.println("");
	        		break;
	        	case "4":
	        		System.exit(0);
	        	default:
	        		break;
				}			
				System.out.println("Presione enter para continuar...");
				linea.readLine();
    			System.out.println("1.Buscar N generos mas buscados");
    			System.out.println("2.Buscar generos buscados luego de Genero A");
    			System.out.println("3.Buscar generos afines");
    			System.out.println("4.Salir");
    			System.out.print("Ingrese la opcion deseada: ");
    			opcion = linea.readLine();
    			System.out.println("");
		}while(opcion != "4");
	}
}
