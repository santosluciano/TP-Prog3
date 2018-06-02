package Entrega2;
import java.util.LinkedList;

public class Libro {
	
	private String titulo;
	private String autor;
	private String cantidadPaginas;
	private LinkedList<Genero> generos;
	
	public Libro (String titulo, String autor, String cP) {
		this.titulo = titulo;
		this.autor = autor;
		this.cantidadPaginas = cP;
		this.generos = new LinkedList<Genero>();
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

	public String getCantidadPaginas() {
		return cantidadPaginas;
	}

	public void setCantidadPaginas(String cantidadPaginas) {
		this.cantidadPaginas = cantidadPaginas;
	}

	public LinkedList<Genero> getGeneros() {
		return generos;
	}

	public void addGenero(Genero genero) {
		this.generos.add(genero);
	}
}
