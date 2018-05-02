import java.util.LinkedList;

public class Indice {
	
	private String genero;
	private LinkedList<Libro> libros;
	private Indice izq;
	private Indice der;
	
	public Indice() {
		this.genero = null;
		this.libros = new LinkedList<Libro>();
		this.izq = null;
		this.der = null;
	}
	
	public void insertLibro(Libro libro) {
		for (String genero:libro.getGeneros()) {
			insertLibro(libro,genero);
		}
	}
	
	private void insertLibro(Libro libro, String genero) {
		if (this.genero == null) {
			this.genero = genero;
			libros.add(libro);
		}else {
			if (this.genero.equals(genero)) {
				this.libros.add(libro);
			} else if (this.genero.compareTo(genero)>0) {
				if (this.izq != null)
					this.izq.insertLibro(libro,genero);
				else {
					this.izq = new Indice();
					this.izq.insertLibro(libro,genero);
				}
			} else {
				if (this.der != null)
					this.der.insertLibro(libro,genero);
				else {
					this.der = new Indice();
					this.der.insertLibro(libro,genero);
				}
			}
		}
	}
	
	public LinkedList<Libro> getLibros(String genero){
		if (this.genero.equals(genero)) {
			return this.libros;
		} else if (this.genero.compareTo(genero)>0) {
			if (this.izq != null) {
				return this.izq.getLibros(genero);
			} else {
				return null;
			}
		} else {
			if (this.der != null) {
				return this.der.getLibros(genero);
			} else {
				return null;
			}				
		}
	}
	
	public void mostrarGeneros() {
		if (this.izq != null) {
			izq.mostrarGeneros();
		}
		System.out.println(this.genero);
		if (this.der!=null) {
			der.mostrarGeneros();
		}
	}
}
