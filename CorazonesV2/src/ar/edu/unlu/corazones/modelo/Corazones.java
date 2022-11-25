package ar.edu.unlu.corazones.modelo;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlu.corazones.observer.Observable;
import ar.edu.unlu.corazones.observer.Observador;

public class Corazones implements Observable{
	
	private static final int puntajeMaximo = 50;
	private static final int cantJugadores = 4;
	private static final int cantJugadasPorRonda = 13;
	

	/**
	 * Atributos
	 */
	
	//Array donde estaran los jugadores
	private Jugador[] jugadores; 
	
	//Mazo del juego
	private Mazo mazo;
	
	//Rondas jugadas
	private int ronda;
	
	//Mesa donde se tiraran las cartas del juego
	private Mesa mesa;
	
	private List<Observador> observadores;
	
	/**
	 * Comportamiento
	 */
	
	//Constructor
	public Corazones() {
		//Inicializo las rondas en 0
		ronda = 0;
		//Creo la instancia de los jugadores
		jugadores = new Jugador[cantJugadores];	
		this.observadores = new ArrayList<>();
	}
	
	/**
	 * INICIO DE JUEGO:
	 * .Tiene que dar por iniciado el juego y terminar una vez que se supere
	 * la cantidad maxima de puntos
	 * .Tiene que crear las rondas cada vez que termina una
	 * .Tiene que mostrar al jugador ganador
	 */
	//INICIO DEL JUEGO
	public void inicarJuego() {
		//Inicializo la ronda
		ronda = 1;
		boolean seTermino = false;
		while (!seTermino) {
			iniciarRonda();
			if (hayGanador()) {
				seTermino = true;
			} else {
				ronda ++;
			}
		}
	}
	
	/**
	 * INICIO DE LA RONDA
	 * .Tiene que crear el mazo para comenzar
	 * .Tiene que repartir las 13 cartas a cada jugador
	 * .Tiene que solicitar las cartas la jugador para que las tire en la mesa
	 * .Tiene que determinar que cartas es capaz de tirar
	 * .Tiene que determinar al ganador de cada jugada
	 */
	public void iniciarRonda() {
		mazo = new Mazo();
		repartirCartas();
		int posJugador = 0;
		Jugador jugadorPrincipal = null;
	
		for(int jugada = 0; jugada < cantJugadasPorRonda; jugada++) {
			Mesa mesa = new Mesa();
			if (jugada == 0) { //Primera jugada
				int posJugador2Trebol = jugador2Trebol();	
			} 
			for(int i = 0; i < (cantJugadores - 1); i++) {
				//Pido el proximo jugador (el de la izquierda)
				Jugador proxJugador = obtenerIzquierda(jugadores[posJugador]);
				//Le solicito la carta
				//Carta carta = 
				this.notificar(EventosCorazones.PEDIR_CARTA);
				//Carta carta = jugadores[i].getCartas[pedirCarta]
				//mesa.recibirCartaTirada(proxJugador.getPosicionFisica(), carta);
				//Le paso la posicion del jugador que jugo recien
				posJugador = proxJugador.getPosicionFisica();
			int posicionGanador = mesa.determinarGanador();
			//jugadores[posicionGanador].
		}
	}
	}
	
	public int pedirCarta(int posCarta) {
		return posCarta;
	}
	
	private int jugador2Trebol() {
		boolean encontrado = false;
		int i = 0;
		while(!encontrado && i < jugadores.length) {
			if (jugadores[i].tengoEl2DeTrebol()) {
				encontrado = true;
				mesa.recibirCartaTirada(i, new Carta(Palo.TREBOL,2));
				jugadores[i].tirar2Trebol();
			} else {i++;}
		}
		return i;
	}
	
	//Metodo privado que determina si existe o no un jugador
	//en el juego
	private boolean hayGanador() {
		boolean hayGanador = false;
		int pos = 0;
		while (!hayGanador && pos < jugadores.length) {
			if (jugadores[0].getPuntaje() > puntajeMaximo) {
				hayGanador = true;
			}
			else {
				pos ++;
			}
		}
		return hayGanador;
	}


	
	//Metodo que agrega jugadores al juego,
	//segun lo que devuelva indica si se cargo de forma correcta o no el jugador
	//true = se cargo
	//false = no se cargo porque ya estan todos los jugadores
	public boolean agregarJugadores(String nombre) {
		boolean hayEspacio = false;
		int pos = 0;
		while(!hayEspacio && pos < jugadores.length) {
			if (jugadores[pos] == null) {
				jugadores[pos] = new Jugador(nombre,pos);
				hayEspacio = true;
			}
			else {
				pos++;
			}
		}
		return hayEspacio;
	}
	
	//Metodo que modifica un jugador en el juego
	//Solamente modifica si existe un jugador en la posicion que quiere
	//modificar el usuario, sino no lo hace
	public boolean reemplazarJugadores(String nombre,int posicion) {
		boolean seReemplazo = false;
		//Chequeo si no hay ningun jugador, o el referencial apunta a nulo
		if (!(jugadores[posicion - 1] == null)){
			//Cambia la bandera y modifico al jugador
			seReemplazo = true;
			jugadores[posicion - 1].setNombre(nombre);
		}
		return seReemplazo;
	}
	
	//Metodo que me muestra los jugadores que hay en el juego
	public String mostrarJugadores() {
		String s = "";
		int i = 0;
		boolean vacio = false;
		while (!vacio && i < jugadores.length) {
			if (jugadores[i] != null) {
				s += "Jugador: " + (i+1) + " - " + jugadores[i].mostrarNombre() + "\n";
				i++;
			} else vacio = true;
		}
		return s;	
	}
		
	
	//Metodo que me muestra las mano de los jugadores
	public String mostrarManoJugadores() {
		String s = "";
		for(int i = 0; i < jugadores.length; i++) {
			s += "Jugador: " + (i+1) + " - " + jugadores[i].mostrarNombre() + "\n" +
					jugadores[i].mostrarMano() + "\n";
		}
		return s;
	}


	//Metodo que reparte las cartas a cada jugador, como 
	//se hace de forma habitual
	//1 1 1 1, 2 2 2 2, 3 3 3 3, etc.
	private void repartirCartas() {
		for(int i = 0; i < 13; i++) {
			for(Jugador jugador : jugadores) {
				jugador.recibirCarta(mazo.sacarCarta());
			} 
		}
	}
	
	private Jugador obtenerIzquierda(Jugador jugador) {
		return jugadores[jugador.obtenerIzquierda()];
	}
	
	@Override
	public void notificar(Object evento) {
		for (Observador observador : this.observadores) {
			observador.actualizar(evento, this);
		}
	}

	@Override
	public void agregadorObservador(Observador observador) {
		this.observadores.add(observador);
	}
	
}
