package ar.edu.unlu.corazones.vista;

import ar.edu.unlu.corazones.controlador.Controlador;

public interface IVista {	
	//public void setControlador(Controlador controlador);
	
	public void iniciar();

	void setControlador(Controlador controlador);
}