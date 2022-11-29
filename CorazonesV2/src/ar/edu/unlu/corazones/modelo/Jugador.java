package ar.edu.unlu.corazones.modelo;

import java.util.ArrayList;
import java.util.Random;

/**
 * Clase jugador
 * Se encarga de realizar todos los movimientos dentro del juego
 * Es el que impulsa al juego y sus decisiones afectan a su funcionamiento
 *
 */
public class Jugador {
	
	/**
	 * Atributos
	 */
	
	//Nombre del jugador
	private String nombre;
	
	//Puntaje del jugador
	private int puntaje;
	
	//Mano del jugador
	private ArrayList<Carta> mano;
	
	//Cartas recogidas durante las jugadas
	private ArrayList<Carta> recogidas;
	
	//Cartas que puede tirar el usuario de su mano
	//private ArrayList<Carta> manoCondicionada;
	
	//Posicion del Jugador en el arreglo
	private int posicionFisica;
	
	//Referencial al jugador de la izq
	private int jugadorIzquierda;
	
	/**
	 * Comportamiento
	 */
	
	//Constructor de la clase jugador
	public Jugador(String nombre, int posicion) {
		this.nombre = nombre; //Determino el nombre del jugador
		this.puntaje = 0; //Seteo los puntos en 0
		//Inicializo la mano y las cartas recogidas
		mano = new ArrayList<Carta>();
		//manoCondicionada = mano;
		recogidas = new ArrayList<Carta>();
		//Determino cual es el jugador siguiente
		if ((posicion + 1) == 4) {
			this.jugadorIzquierda = 0;
		}
		else {
			this.jugadorIzquierda = (posicion + 1);
		}
		this.posicionFisica = posicion;
	}
	
	//Metodo que le da las cartas al jugador y las agrega a su mano
	public void recibirCarta(Carta carta) {
		mano.add(carta);
	}
	
	//Metodo que tira la carta al juego (el jugador la remueve de su mano)
	public void tirarCarta(Carta carta) {
		mano.remove(carta);
	}
	
	//Metodo que muestra la mano del usuario
	public String mostrarMano() {
		String s = "";
		for (int i = 0; i < mano.size() ; i++){
			s += (i+1) + ")* " + mano.get(i).mostrarCarta() + "\n";
		 }
		return s;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	//Metodo que le da las cartas al jugador y las guarda en las cartas recogidas
	// (de esta forma puedo calcular los puntos)
	public void recibirCartasRecogida(Carta[] cartas) {
		for (Carta cartaCargada: cartas)
		recogidas.add(cartaCargada);
	}
	
	//Metodo que cuenta la cantidad de puntos que tiene el jugador en esa ronda
	public void contarPuntos() {
		int contador = 0;
		for (int i = 0; i < recogidas.size() ; i++){
			contador += recogidas.get(i).getPuntaje();
		}
		resetRecogidas(); //Reseteo las recogidas
		this.puntaje += contador; //Cargo los puntos
	}
	
	//Getter que obtiene el puntaje del jugador
	public int getPuntaje() {
		return this.puntaje;
	}
	
	//Metodo que, una vez terminada la ronda, devuelve todas
	// las recogidas
	private void resetRecogidas() {
		recogidas.clear();
	}

	//Getter del nombre del jugador
	public String mostrarNombre() {
		return nombre;
	}
	
	//Metodo que me dice las cartas que puede tirar el usuario
	public String cartasQuePuedeTirar(Carta carta){
		String s = "";
		boolean puedeTirarCualquiera = true;
		boolean primeraCarta = false;
		int i = 0;
		while (i < mano.size() && !primeraCarta) {
			if (carta == null) {
				primeraCarta = true;
			} else if (mano.get(i).getPalo() == carta.getPalo()) {
				s += (i+1) + ")* " + mano.get(i).mostrarCarta() + "\n";
				puedeTirarCualquiera = false;
			}
			i++;
		}
		if (puedeTirarCualquiera || primeraCarta) {
			s = mostrarMano();
		}
		return s;
	}
	
	//Metodo que me dice si este jugador es quien inicia la ronda
	public boolean tengoEl2DeTrebol() {
		boolean dostrebol = false;
		int i = 0;
		while ((!dostrebol) && (i < mano.size())) {
			if (mano.get(i).getPalo() == Palo.TREBOL && 
					mano.get(i).getValor() == 2) {
				dostrebol = true;
			} else i++;
		 }
		return dostrebol;
	}
	
	//Metodo que tira el 2 de trebol de la mano del usuario
	public void tirar2Trebol() {
		boolean borrado = false;
		int i = 0;
		while (!borrado) {
			if (mano.get(i).getPalo() == Palo.TREBOL && mano.get(i).getValor() == 2) {
				mano.remove(i);
				borrado = true;			
			}
			else {
				i++;
			}
		}
	}
	
	//Get Posicion del jugador
	public int getPosicionFisica() {
		return posicionFisica;
	}
	
	//Get Jugador Izquierda
	public int obtenerIzquierda() {
		return this.jugadorIzquierda;
	}
	
	public Carta obtenerCarta(int posCarta) {
		return mano.get(posCarta);
	}
	
	public void tirarCarta(int posCarta) {
		mano.remove(posCarta);
	}
}
