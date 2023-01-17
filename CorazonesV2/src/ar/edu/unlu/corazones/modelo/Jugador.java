package ar.edu.unlu.corazones.modelo;

import java.util.ArrayList;

/**
 * CLASE JUGADOR
 * Se encarga de realizar todos los movimientos dentro del juego
 * Es el que impulsa al juego y sus decisiones afectan a su funcionamiento
 *
 */
public class Jugador {
	
	// *************************************************************
	//                        ATRIBUTOS
	// *************************************************************
	
	//Nombre del jugador
	private String nombre;
	
	//Puntaje del jugador
	private int puntaje;
	
	//Mano del jugador
	private ArrayList<Carta> mano;
	
	//Cartas recogidas durante las jugadas
	private ArrayList<Carta> recogidas;
	
	//Posicion del Jugador en el arreglo
	private int posicionFisica;
	
	//Referencial al jugador de la izq
	private int jugadorIzquierda;
	
	// *************************************************************
	//                       CONSTRUCTOR
	// *************************************************************
	
	//Constructor de la clase jugador
	public Jugador(String nombre, int posicion) {
		this.nombre = nombre; //Determino el nombre del jugador
		this.puntaje = 0; //Seteo los puntos en 0
		mano = new ArrayList<Carta>();//Inicializo la mano y las cartas recogidas
		recogidas = new ArrayList<Carta>();
		//Determino cual es el jugador siguiente
		if ((posicion + 1) == 4) {
			this.jugadorIzquierda = 0; //Si es el jugador 4, a mi izquierda esta el jugador 0 o inicial
		}
		else {
			this.jugadorIzquierda = (posicion + 1); //Sino, es el de la izquierda correspondiente
		}
		this.posicionFisica = posicion;
	}
	
	// *************************************************************
	//                       COMPORTAMIENTO
	// *************************************************************
	
	//Metodo que le da las cartas al jugador y las agrega a su mano
	public void recibirCarta(Carta carta) {
		mano.add(carta);
	}
	
	//Metodo que tira la carta al juego (el jugador la remueve de su mano)
	public void tirarCarta(Carta carta) {
		mano.remove(carta);
	}
	
	//Metodo que muestra la mano del usuario
	public String mostrarManoNormal() {
		String s = "";
		for (int i = 0; i < mano.size() ; i++){
			s += (i+1) + ") " + mano.get(i).mostrarCarta() + "\n";
		 }
		return s;
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
	
	//Metodo que, una vez terminada la ronda, devuelve todas
	// las recogidas
	private void resetRecogidas() {
		recogidas.clear();
	}


	
	//Metodo que me dice las cartas que puede tirar el usuario, que recibe la primera carta que se tiro en mesa
	public String mostrarMano(Carta carta) {
		String s = "";
		boolean puedeTirarCualquiera = true;
		boolean primeraCarta = false;
		int i = 0;
		while (i < mano.size() && !primeraCarta) {
			if (carta == null) { //Si la carta es nula, quiere decir que el arranca la jugada
				primeraCarta = true;
			} else if (mano.get(i).getPalo() == carta.getPalo()) { //Si coincide la carta en mesa con la que tiene en mano
				s += (i+1) + ") " + mano.get(i).mostrarCarta() + "*" + "\n"; //Esa carta si la puede tirar
				puedeTirarCualquiera = false;
			}
			else {
				s += (i+1) + ") " + mano.get(i).mostrarCarta() + "\n"; //Sino, es una carta que no puede tirar
				}
			i++;		
		}
		if (puedeTirarCualquiera || primeraCarta) { //Si uno de los dos es verdadero, puede tirar cualquier carta
			s = mostrarManoNormal();
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
			if (mano.get(i).getPalo() == Palo.TREBOL && mano.get(i).getValor() == 2) { //Primero busco el 2 de trebol
				mano.remove(i);
				borrado = true;			
			}
			else {
				i++;
			}
		}
	}
	
	//Tirar carta a traves de la posicion
	public void tirarCarta(int posCarta) {
		mano.remove(posCarta);
	}
	
	// *************************************************************
	//                      SETTERS
	// *************************************************************
	
	//Set nombre
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	// *************************************************************
	//                      GETTERS
	// *************************************************************
	
	//Get Posicion del jugador
	public int getPosicionFisica() {
		return posicionFisica;
	}
	
	//Get Jugador Izquierda
	public int obtenerIzquierda() {
		return this.jugadorIzquierda;
	}
	
	//Obtener carta a traves de la posicion
	public Carta obtenerCarta(int posCarta) {
		return mano.get(posCarta);
	}
	
	//Getter del nombre del jugador
	public String mostrarNombre() {
		return nombre;
	}
	
	//Metodo que muestra las cartas en mano del jugador
	public int cartasEnMano() {
		return mano.size();
	}
	
	//Getter que obtiene el puntaje del jugador
	public int getPuntaje() {
		return this.puntaje;
	}
	
}
