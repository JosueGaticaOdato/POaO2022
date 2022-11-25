package ar.edu.unlu.ejercicio1;

import java.util.ArrayList;

public class Biblioteca {

	private ArrayList<Publicacion> publicaciones;

	//Constructor que crea el array de publicaciones
	public Biblioteca() {
		super();
		this.publicaciones = new ArrayList<Publicacion>();
	}
	
	//Agregar un libro
	public void agregarLibro(String nombre, String editor, String numeroTelefono,
			Integer añoPublicacion, Integer numEjemplares,
			Integer iSBN, ArrayList<String> autores) {
		Publicacion nuevaPubli = new Libro(nombre,editor,numeroTelefono,
				añoPublicacion, numEjemplares, iSBN, autores);
		publicaciones.add(nuevaPubli);
	}
	
	//Agregar una revista
	public void agregarRevista(String nombre, String editor, String numeroTelefono,
			Integer añoPublicacion, Integer numEjemplares,
			Integer iSSN, Integer numRevista) {
		Publicacion nuevaPubli = new Revista(nombre,editor,numeroTelefono,
				añoPublicacion, numEjemplares, iSSN, numRevista);
		publicaciones.add(nuevaPubli);
	} 
	
	public void agregarTesis(String nombre, String editor, String numeroTelefono, 
			Integer añoPublicacion,
			 String autor, Integer mes) {
		Publicacion nuevaPubli = new Tesis(nombre,editor,numeroTelefono,
				añoPublicacion, autor,mes);
		publicaciones.add(nuevaPubli);
	} 
	
	public void agregarDiario(String nombre, String editor, String numeroTelefono, 
			Integer añoPublicacion, Integer dia, Integer mes) {
		Publicacion nuevaPubli = new Diario(nombre,editor,numeroTelefono,
				añoPublicacion, dia,mes);
		publicaciones.add(nuevaPubli);
	} 
	
	public String mostrarTodo() {
		String s = "";
		for (int i=0;i<publicaciones.size();i++) {
			s = s + publicaciones.get(i).mostrar() + "\n" + "\n";
		}
		return s;
	}

}
