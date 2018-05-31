package Entrega1;
import java.util.LinkedList;

public class Libro {
	
	private String titulo;
	private String autor;
	private String cantidadPaginas;
	private LinkedList<String> generos;
	
	public Libro (String titulo, String autor, String cP) {
		this.titulo = titulo;
		this.autor = autor;
		this.cantidadPaginas = cP;
		this.generos = new LinkedList<String>();
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

	public LinkedList<String> getGeneros() {
		return generos;
	}

	public void addGenero(String genero) {
		this.generos.add(genero);
	}
}
