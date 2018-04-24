import java.util.ArrayList;

public class Libro {
	
	private String titulo;
	private String autor;
	private int cantidadPaginas;
	private ArrayList<String> generos;
	
	public Libro (String titulo, String autor, int cP) {
		this.titulo = titulo;
		this.autor = autor;
		this.cantidadPaginas = cP;
		this.generos = new ArrayList<String>();
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getCantidadPaginas() {
		return cantidadPaginas;
	}

	public void setCantidadPaginas(int cantidadPaginas) {
		this.cantidadPaginas = cantidadPaginas;
	}

	public ArrayList<String> getGeneros() {
		return generos;
	}

	public void addGenero(String genero) {
		this.generos.add(genero);
	}
}
