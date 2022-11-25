package ar.edu.unlu.ejercicio1;

public abstract class Publicacion {
	String nombre;
	
	String editor;
	
	String numeroTelefono;
	
	Integer añoPublicacion;
	
	//Constructor
	public Publicacion(String nombre, String editor, String numeroTelefono, Integer añoPublicacion) {
		super();
		this.nombre = nombre;
		this.editor = editor;
		this.numeroTelefono = numeroTelefono;
		this.añoPublicacion = añoPublicacion;
	}
	

	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getEditor() {
		return editor;
	}



	public void setEditor(String editor) {
		this.editor = editor;
	}



	public String getNumeroTelefono() {
		return numeroTelefono;
	}



	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}



	public Integer getAñoPublicacion() {
		return añoPublicacion;
	}


	public void setAñoPublicacion(Integer añoPublicacion) {
		this.añoPublicacion = añoPublicacion;
	}

	//Clase abstracta que me muestra la publicacion
	abstract public String mostrar();

	
	
}
