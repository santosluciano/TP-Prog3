import java.util.LinkedList;

public class Indice {
	
	String genero;
	LinkedList<Libro> libros;
	Indice izq;
	Indice der;
	
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
		return this.libros;
	}
}
