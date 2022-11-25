package ar.edu.unlu.ejercicio1;

public class Tesis extends Publicacion {
	
	private String autor;
	
	private Integer mes;

	//Constructor
	public Tesis(String nombre, String editor, String numeroTelefono,
			Integer añoPublicacion,
			String autor, Integer mes) {
		super(nombre, editor, numeroTelefono, añoPublicacion);
		this.autor = autor;
		this.mes = mes;
	}
	
	//Getters y Setters
	public String getAutor() {
		return autor;
	}



	public void setAutor(String autor) {
		this.autor = autor;
	}



	public Integer getMes() {
		return mes;
	}



	public void setMes(Integer mes) {
		this.mes = mes;
	}


	//Mostrar Tesis
	@Override
	public String mostrar() {
		String s;
		s = "Tipo: TESIS" + "\n" + ".nombre: " + getNombre() + "\n" + 
				".editor: " + this.getEditor() + "\n" + 
				".telefono: " + this.getNumeroTelefono() + "\n" +
				".Fecha: " + this.getMes() + "/" +  this.getAñoPublicacion() + "\n" +
				".autor: " + this.getAutor() + "\n";
		return s;
	}


	
	
	

}
