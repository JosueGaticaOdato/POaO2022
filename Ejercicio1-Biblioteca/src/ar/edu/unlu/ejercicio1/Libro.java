package ar.edu.unlu.ejercicio1;

//Clase Libro
public class Libro {
	//Atributos del libro
	private Integer ISBN;
	
	private String titulo;

	private String autor;
	
	private Integer num_paginas;
	
	private Integer num_ejemplares;
	
	private Integer num_ejemplares_prestados;
	
	//Constructor con ISBN
	public Libro(Integer isbn, String tituloL, String autorL, Integer paginas,
			Integer ejemplares) {
		ISBN = isbn;
		titulo = tituloL;
		autor = autorL;
		num_paginas = paginas;
		num_ejemplares = ejemplares;
		num_ejemplares_prestados = 0;
	}
	
	//Constructor sin ISBN
	public Libro(String tituloL, String autorL, Integer paginas,
			Integer ejemplares) {
				titulo = tituloL;
				autor = autorL;
				num_paginas = paginas;
				num_ejemplares = ejemplares;
			}
	
	//Descripcion del libro como indica el enunciado
	public String mostrarDescripcion() {
		String s;
		s = "El libro " + titulo + " creado por el autor " + autor
				+ " tiene " + num_paginas + " páginas, "
				+ "quedan " + num_ejemplares + " disponibles y "
				+ "se prestaron " + num_ejemplares_prestados +".";
		return s;
	}
	
	//Getters
	public String getTitulo() {
		return titulo;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public Integer getnum_paginas() {
		return num_paginas;
	}
	
	public Integer getnum_Ejemplares() {
		return num_ejemplares;
	}
	
	public Integer getnum_ejemplares_prestados() {
		return num_ejemplares_prestados;
	}
	
	//Prestamo del libro, disminuye los ejemplares y aumenta la cantidad de prestamos
	public void prestamo() {
		num_ejemplares --;
		num_ejemplares_prestados ++;
	}
	
	//Devolucion del libro, aumentan los ejemplares disponibles
	public void desprestamo() {
		num_ejemplares ++;
	}
}
