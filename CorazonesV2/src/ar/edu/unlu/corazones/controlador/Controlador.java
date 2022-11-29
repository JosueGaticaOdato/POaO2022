package ar.edu.unlu.corazones.controlador;

import ar.edu.unlu.corazones.modelo.Corazones;
import ar.edu.unlu.corazones.modelo.EventosCorazones;
import ar.edu.unlu.corazones.observer.Observable;
import ar.edu.unlu.corazones.observer.Observador;
import ar.edu.unlu.corazones.vista.VistaConsola;

/**
 * 
 *	Controlador:
 *	.Encargado de la comunicacion entre la vista y el juego
 *
 */
public class Controlador implements Observador{
	private Corazones modelo;
	
	private VistaConsola vista;
	
	//Constructor
	public Controlador(Corazones modelo, VistaConsola vista) {
		this.modelo = modelo;
		this.vista = vista;
		this.vista.setControlador(this);
		this.modelo.agregadorObservador(this);
	}	

	/**
	 * DESDE VISTA A MODELO
	 */
	
	public boolean cartaValida(int posCarta) {
		return this.modelo.cartaTiradaValida(posCarta);
	}

	public int numeroRonda() {
		return this.modelo.getRonda();
	}

	public String jugadorActual(){
		return this.modelo.jugadorActual();
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
	
	public String mostrarPuntajes() {
		return this.modelo.mostrarPuntajes();
	}
	
	public String mostrarCartasEnMesa() {
		return this.modelo.cartasEnMesa();
	}
	
	public String mostrarCartasJugadorActual() {
		return this.modelo.cartasJugadorActual();
	}
	
	public void cartaJugada(int posCarta) {
		this.modelo.setposCartaATirar(posCarta);
		
	}
	
	public String ganadorJugada() {
		return this.modelo.ganadorJugada();
	}
	
	public String ganadorJuego() {
		return this.modelo.ganadorJuego();
	}
	
	public String ganadorJuegoPuntos() {
		return this.modelo.ganadorJuegoPuntos();
	}
	
	public String mostrarCartaJugada(int i) {
		return this.modelo.cartaElegida(i);
	}
	
	public String mostrarCartasPosiblesAJugar() {
		return this.modelo.cartasPosiblesAJugar();
	}

	public boolean cantidadDeJugadoresValida() {
		return this.modelo.cantidadDeJugadoresValida();
	}
	
	/*
	 * DESDE MODELO A VISTA
	 */
	
	@Override
	public void actualizar(Object evento, Observable observador) {
		if(evento instanceof EventosCorazones) {
			switch((EventosCorazones) evento) {
				case PEDIR_CARTA:
					this.vista.pedirCarta();
					break;
				case GANADOR_JUGADA:
					this.vista.mostrarGanadorJugada();
					break;
				case FIN_DE_RONDA:
					this.vista.mostrarPuntaje();
					break;
				case FIN_DE_JUEGO:
					this.vista.finalDeJuego();
					break;
				case JUGO_2_DE_TREBOL:
					this.vista.jugador2deTrebol();
					break;
				case PASAJE_DE_CARTAS:
					this.vista.pasajeDeCartas();
					break;
				case PEDIR_CARTA_PASAJE:
					this.vista.pedirCartaPasaje();
					break;
				case FIN_PASAJE_DE_CARTAS:
					this.vista.finPasajeDeCartas();
					break;
			}
		}
	}
}
