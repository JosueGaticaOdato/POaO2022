package ar.edu.unlu.ejercicio1;

import java.util.ArrayList;


public class Biblioteca {
	//Atributo de la Clase Biblioteca, es un array de libros
	private ArrayList<Libro> listaLibros = new ArrayList<Libro>();
	
	//Comportamiento que agrega un libro a la biblioteca
	public void agregarLibro(int isbn, String titulo, String autor, int paginas,
			int ejemplares) {
		Libro nuevoLibro = new Libro(isbn,titulo,autor,paginas,ejemplares);
		listaLibros.add(nuevoLibro);
	}
	
	//Buscar libro por Titulo
	public int buscarLibroTitulo(String titulo) {
		boolean encontrado = false;
		int posicion = 0;
		while ((posicion < listaLibros.size()) & (!encontrado)) {
			if (listaLibros.get(posicion).getTitulo().equals(titulo)) {
				encontrado = true;
			} else
				posicion ++;			
		}
		if (!encontrado) {
			posicion = -1;
		}
		return posicion;
	};
	
	//Buscar libro por Autor
	public int buscarLibroAutor(String autor) {
		boolean encontrado = false;
		int posicion = 0;
		while ((posicion < listaLibros.size()) & (!encontrado)) {
			if (listaLibros.get(posicion).getAutor().equals(autor)) {
				encontrado = true;
			} else
				posicion ++;			
		}
		if (!encontrado) {
			posicion = -1;
		}
		return posicion;
	};
	
	//Mostrar descripcion de un libro especifico
	public String mostrarDescripcion(int Posicion) {
		return listaLibros.get(Posicion).mostrarDescripcion();
	}
	
	//Realiza el prestamo de un libro por titulo
	public boolean realizarPrestamoTitulo(String titulo){
		boolean hecho = false;
		int Posicion = buscarLibroTitulo(titulo);
		if (Posicion != -1) {
			if (listaLibros.get(Posicion).getnum_Ejemplares() > 1) {
				listaLibros.get(Posicion).prestamo();
				hecho = true;
			}
		}
		return hecho;
	}
	
	//Realiza el prestamo de un libro por autor
	public boolean realizarPrestamoAutor(String autor){
		boolean hecho = false;
		int Posicion = buscarLibroAutor(autor);
		if (Posicion != -1) {
			if (listaLibros.get(Posicion).getnum_Ejemplares() > 1) {
				listaLibros.get(Posicion).prestamo();
				hecho = true;
			}
		}
		return hecho;
	}
	
	//Devuelve el prestamo de un libro por titulo
	public boolean DevolverPrestamoTitulo(String titulo){
	boolean hecho = false;
	int Posicion = buscarLibroTitulo(titulo);
	if (Posicion != -1) {
		listaLibros.get(Posicion).desprestamo();
		hecho = true;
		}
	return hecho;
	}

	//Devuelve el prestamo de un libro por titulo
	public boolean DevolverPrestamoAutor(String autor){
	boolean hecho = false;
	int Posicion = buscarLibroAutor(autor);
	if (Posicion != -1) {
		listaLibros.get(Posicion).desprestamo();
		hecho = true;
		}
	return hecho;
	}
	
	//Devuelve los prestamos totales realizados en la biblioteca
	public int prestamosTotales() {
		int contador = 0;
		for (int i = 0; i < listaLibros.size(); i++) {
			contador = contador + listaLibros.get(i).getnum_ejemplares_prestados();
		}
		return contador;
	}
	
	//Comparacion entre 2 libros que me devuelve el libro con mas paginas
	public String masPaginas(String tituloLibro1, String tituloLibro2) {
		int Libro1, Libro2;
		String retorno;
		Libro1 = buscarLibroTitulo(tituloLibro1);
		Libro2 = buscarLibroTitulo(tituloLibro2);
		if (listaLibros.get(Libro1).getnum_paginas() > listaLibros.get(Libro2).getnum_paginas()) {
			retorno = tituloLibro1;
		} else retorno = tituloLibro2;
		return retorno;
	}
}
