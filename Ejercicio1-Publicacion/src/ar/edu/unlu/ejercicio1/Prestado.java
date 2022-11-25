package ar.edu.unlu.ejercicio1;

public abstract class Prestado {
	
	Integer ejemplares;
	
	Integer ejemplares_Prestados = 0;

	abstract public void prestar();
	
	//abstract public String mostrar();
	
	public Integer calcularDisponibles() {
		return ejemplares - ejemplares_Prestados;
	}

	public String mostrar() {
		// TODO Auto-generated method stub
		return null;
	}

}
