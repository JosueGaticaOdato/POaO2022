package ar.edu.unlu.corazones.app;

import ar.edu.unlu.corazones.controlador.Controlador;
import ar.edu.unlu.corazones.modelo.Corazones;
import ar.edu.unlu.corazones.vista.VistaConsola;

public class appCorazones {

	public static void main(String[] args) {
		
		Corazones modelo = new Corazones();
		VistaConsola vista = new VistaConsola();
		Controlador controlador = new Controlador(modelo, vista);
		vista.iniciar();
		
	}

}
