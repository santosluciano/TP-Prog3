
public class Inicio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ColeccionLibros biblioteca = new ColeccionLibros();
		biblioteca.cargarLibros("C:\\dataset4.csv");
		biblioteca.getLibrosGenero("terror","C:\\salida.csv");
	}

}
