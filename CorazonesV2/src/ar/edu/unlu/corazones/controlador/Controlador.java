package ar.edu.unlu.corazones.controlador;

import java.util.List;

import ar.edu.unlu.corazones.modelo.Corazones;
import ar.edu.unlu.corazones.modelo.EventosCorazones;
import ar.edu.unlu.corazones.modelo.Jugador;
import ar.edu.unlu.corazones.observer.Observable;
import ar.edu.unlu.corazones.observer.Observador;
import ar.edu.unlu.corazones.vista.VistaConsola;


public class Controlador implements Observador{
	private Corazones modelo;
	
	private VistaConsola vista;
	
	public Controlador(Corazones modelo, VistaConsola vista) {
		this.modelo = modelo;
		this.vista = vista;
		this.vista.setControlador(this);
		this.modelo.agregadorObservador(this);
	}	

	
	public void comenzarJuego(){
		this.modelo.inicarJuego();
	}


	public String listaJugadores() {
		// TODO Auto-generated method stub
		return this.modelo.mostrarJugadores();
	}


	public boolean nuevoJugador(String nombre) {
		return this.modelo.agregarJugadores(nombre);
	}


	public boolean modificarJugador(String nombre, int pos) {
		return this.modelo.reemplazarJugadores(nombre, pos);
	}
	
	
	@Override
	public void actualizar(Object evento, Observable observador) {
		if(evento instanceof EventosCorazones) {
			switch((EventosCorazones) evento) {
				case PEDIR_CARTA:
					this.vista.pedirCarta();
					break;
			}
		}
	}

/**
	public void cartaElegida(int posCarta) {
		return this.modelo.pedirCarta(posCarta);
		
	}*/

}
