package ar.edu.unlu.ejercicio1;

public class Revista extends Prestado {
	
	private Integer ISSN;
	
	private Integer numero;

	//Constructor
	public Revista(Integer iSSN, Integer numero) {
		super();
		ISSN = iSSN;
		this.numero = numero;
	}


	//Getters y Setters
	public Integer getISSN() {
		return ISSN;
	}

	public void setISSN(Integer iSSN) {
		ISSN = iSSN;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	//Mostrar
	@Override
	@Override
	@Override
	public String mostrar() {
		String s;
		s = "REVISTA " + "\n" + ".nombre: " + getNombre() + "\n" + ".editor: " + this.getEditor() + "\n" 
				+ ".telefono: " + this.getNumeroTelefono() + "\n"  + ".Año: " + this.getAñoPublicacion() + "\n" +
				".ISSN: " + this.getISSN() + "\n" + ".numero: " + this.getNumero()  + "\n" +
				".ejemplares: " + this.getNumEjemplares() + "\n" + ".ejemplares prestado: " + this.getNumEjemplaresPrestados();
		return s;
	}


}
