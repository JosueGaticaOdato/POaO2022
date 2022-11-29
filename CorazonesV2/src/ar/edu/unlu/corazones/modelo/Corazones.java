package ar.edu.unlu.corazones.modelo;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlu.corazones.observer.Observable;
import ar.edu.unlu.corazones.observer.Observador;

/**
 * 
 * Clase corazones:
 * .Aqui se llevara a cabo toda la logica y funcionalidad del juego
 *
 */

public class Corazones implements Observable{
	
	/**
	 * Constantes
	 */
	
	private static final int puntajeMaximo = 12; //TESTING
	private static final int cantJugadores = 4;
	private static final int cantJugadasPorRonda = 13; //TESTING
	private static final int cantCartasRepartidas = 13; //TESTING
	private static final int maximoPasajeDeCartas = 3;
	
	/**
	 * Atributos
	 */
	
	//Array donde estaran los jugadores
	private Jugador[] jugadores; 
	
	//Mazo del juego
	private Mazo mazo;
	
	//Rondas jugadas (En una ronda hay 13 jugadas)
	private int ronda;
	
	//Mesa donde se tiraran las cartas del juego
	private Mesa mesa;
	
	//Posicion del jugador actual
	private int posJugadorActual;
	
	//Posicion de la carta que tirara el jugador actual
	private int posCartaATirar;
	
	//Jugador que gano la mano
	private Jugador jugadorGanadorMano;
	
	//Lista de observadores
	private List<Observador> observadores;
	
	/**
	 * Comportamiento
	 */
	
	//Constructor
	public Corazones() {
		ronda = 0; //Inicializo las rondas en 0
		//Creo la instancia de los jugadores
		jugadores = new Jugador[cantJugadores];	
		this.observadores = new ArrayList<>();
		/**
		 * Cargo default
		 */
		agregarJugadores("a");
		agregarJugadores("b");
		agregarJugadores("c");
		agregarJugadores("d");
	}
	
	/**
	 * INICIO DE JUEGO:
	 * .Tiene que dar por iniciado el juego y terminar una vez que se supere
	 * la cantidad maxima de puntos
	 * .Tiene que crear las rondas cada vez que termina una
	 * .Tiene que mostrar al jugador ganador
	 */
	public void inicarJuego() {
		//Inicializo la ronda
		ronda = 1;
		boolean seTermino = false;
		//Mientras no se termine el juego
		while (!seTermino) {
			//Inicio la ronda
			iniciarRonda();
			//Notifico cuando se termino la ronda, para mostrar los puntajes
			notificar(EventosCorazones.FIN_DE_RONDA);
			if (hayGanador()) { //Consulto si alguien sobrepaso el puntaje maximo
				seTermino = true; 
				//Notifico al controlador que el juego termino
				notificar(EventosCorazones.FIN_DE_JUEGO);
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
		//Creo el mazo
		mazo = new Mazo();
		//reparto las cartas a los jugadores
		repartirCartas();
		//Realizo el pasaje de cartas entre usuarios, segun la ronda
		pasajeDeCartas();
		//Ciclo por todas las jugadas que hay en la ronda
		for(int jugada = 0; jugada < cantJugadasPorRonda; jugada++) {
			mesa = new Mesa(); //Creo la mesa donde se colocaran las 4 cartas
			if (jugada == 0) { //Primera jugada, se tira el 2 de trebol
				//Obtengo la posicion del jugador que tiene el 2 de trebol
				//y lo cargo en la mesa
				posJugadorActual = jugador2Trebol(); 
				//Obtengo al jugador del 2 de trebol
				jugadorGanadorMano = jugadores[posJugadorActual]; 
				notificar(EventosCorazones.JUGO_2_DE_TREBOL);
				}
			else { //Otra jugada que no sea la primera
				//Obtengo la posicion del jugador que es mano
				posJugadorActual = jugadorGanadorMano.getPosicionFisica();
				//Le pido la carta a jugar
				notificar(EventosCorazones.PEDIR_CARTA);
				jugarCarta(posCartaATirar);
			}
			//Itero con los jugadores restantes, para pedir que tiren las cartas
			//Siempre juega el jugador que esta a la izquierda del que tiro
			int i = 0;
			//Pido la posicion del jugador que realiza la primera jugada
			posJugadorActual = jugadorGanadorMano.getPosicionFisica();		
			//itero con los jugadores restantes
			while (i < 3) {
				//Pido el proximo jugador (el de la izquierda)
				Jugador proxJugador = obtenerIzquierda(jugadores[posJugadorActual]);
				/**
				 * Solicito la carta al jugador
				 */
				posJugadorActual = proxJugador.getPosicionFisica();
				notificar(EventosCorazones.PEDIR_CARTA);
				jugarCarta(posCartaATirar);
				//Aumento contador
				i++;
			}
			
			//Una vez que tiraron las cartas todos los jugadores, determino el ganador
			jugadorGanadorMano = jugadores[mesa.determinarGanador()];
			//Notifico quien fue el ganador de la mesa
			notificar(EventosCorazones.GANADOR_JUGADA);
			//Cargo las cartas al ganador
			jugadorGanadorMano.recibirCartasRecogida(mesa.getCartasJugadasEnMesa());
		}
		//Calculo los puntajes de los jugadores una vez finaliada la ronda
		calcularPuntajes();
	}
	
	//Setter para obtener la carta que tiro el usuario
	public void setposCartaATirar(int posCartaATirar2) {
		this.posCartaATirar = posCartaATirar2;
	}
	
	//Metodo que juega la carta del usuario
	public void jugarCarta(int posCartaATirar2) {
		Carta carta = jugadores[posJugadorActual].obtenerCarta(posCartaATirar2);
		mesa.recibirCartaTirada(posJugadorActual, carta);
		jugadores[posJugadorActual].tirarCarta(carta);
	}
	
	//Metodo que se encarga de decirme quien es el jugador que tiene
	//el 2 de trebol, ademas de agregarlo a la mesa y tirarlo de la mano
	//del jugador
	private int jugador2Trebol() {
		boolean encontrado = false;
		int i = 0;
		while(!encontrado && i < jugadores.length) { //Busco el 2 de trebol
			if (jugadores[i].tengoEl2DeTrebol()) {
				/**
				 * Indico que lo encontre, lo tiro a la mesa y lo descarto de la 
				 * mano del jugador
				 */
				encontrado = true;
				mesa.recibirCartaTirada(i, new Carta(Palo.TREBOL,2));
				jugadores[i].tirar2Trebol();
			} else {i++;}
		}
		return i;
	}
	
	//Metodo que me dice si hay un ganador
	//El ganador se define si uno de los jugadore supera el puntaje maximo,
	//de esta forma ganara el que tine menos puntos, ya que recolecto
	//menos corazones.
	private boolean hayGanador() {
		boolean hayGanador = false;
		int pos = 0;
		while (!hayGanador && pos < jugadores.length) {
			if (jugadores[pos].getPuntaje() > puntajeMaximo) {
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
		
	/**
	//Metodo que me muestra las mano de los jugadores
	public String mostrarManoJugadores() {
		String s = "";
		for(int i = 0; i < jugadores.length; i++) {
			s += "Jugador: " + (i+1) + " - " + jugadores[i].mostrarNombre() + "\n" +
					jugadores[i].mostrarMano() + "\n";
		}
		return s;
	}**/

	//Metodo que reparte las cartas a cada jugador, como se hace de forma habitual
	//1 1 1 1, 2 2 2 2, 3 3 3 3, etc.
	private void repartirCartas() {
		for(int i = 0; i < cantCartasRepartidas; i++) {
			for(Jugador jugador : jugadores) {
				jugador.recibirCarta(mazo.sacarCarta());
			} 
		}
	}
	
	//Metodo para obtener el jugador que esta a la izquierda
	private Jugador obtenerIzquierda(Jugador jugador) {
		return jugadores[jugador.obtenerIzquierda()];
	}
	
	//Metodo quer realiza el pasaje de cartas entre usuarios, segun el
	//numero de ronda
	public void pasajeDeCartas() {
		int pasaje = this.ronda % 4;
		
		/**
		 * CASOS:
		 * 	1. Pasaje de 1: Se realiza el pasaje a la izquierda
		 *  2. Pasaje de 2: Se realiza el pasaje al frente
		 *  3. Pasaje de 3: Se realiza el pasaje a la derecha
		 *  4. Pasaje de 0: No hay pasaje
		 */
		
		//Primer for por la cantida de jugadores
		if (pasaje != 0) { //Primero consulto si tengo que pasar las cartas o no
		for(int jugador = 0; jugador < jugadores.length; jugador++) {
			//Tengo el jugador actual
			posJugadorActual = jugador;
			//Aviso que voy a realizar el pasaje de cartas
			notificar(EventosCorazones.PASAJE_DE_CARTAS);
			//Segundo for por la cantidad de cartas que se van a pasar
			for (int cartasPasadas = 0; cartasPasadas < maximoPasajeDeCartas; cartasPasadas++ ) {
					//Recibo la carta
					notificar(EventosCorazones.PEDIR_CARTA_PASAJE);
					Carta carta = jugadores[jugador].obtenerCarta(posCartaATirar);
					//La saco de la mano del jugador
					jugadores[jugador].tirarCarta(posCartaATirar);
					switch(pasaje) {
						case 1: //CASO 1: A LA IZQUIERDA
							jugadores[jugadores[jugador].obtenerIzquierda()].recibirCarta(carta);
							break;
						case 2: //CASO 2: AL FRENTE
							jugadores[jugadores[jugadores[jugador]
									.obtenerIzquierda()].obtenerIzquierda()].recibirCarta(carta);
							break;
						case 3: //CASO 3: A LA DERECHA
							jugadores[jugadores[jugadores[jugadores[jugador]
									.obtenerIzquierda()].obtenerIzquierda()].
							          obtenerIzquierda()].recibirCarta(carta);
							break;
					}
				}
			//Notifico que el usuario x dejo de pasar sus cartas
			notificar(EventosCorazones.FIN_PASAJE_DE_CARTAS);
			}
		}
	}

	//Metodo que calcula el puntaje de cada jugador
	public void calcularPuntajes() {
		for(int i = 0; i < jugadores.length; i++) {
			jugadores[i].contarPuntos();
		}
	}

	//Metodo que me muestra los puntajes de cada jugador
	public String mostrarPuntajes() {
		String s = "Ronda " + this.ronda + "\n" ;
		for(int i = 0; i < jugadores.length; i++) {
			s += "Jugador:" + (i+1) + " - " + jugadores[i].mostrarNombre() + "\n" +
					jugadores[i].getPuntaje() + "\n";
		}
		return s;
	}
	
	//Mostrar cartas en mesa
	public String cartasEnMesa() {
		return mesa.mostrarCartasEnMesa();
	}
	
	//Mostrar la mano del jugador actual
	public String cartasJugadorActual() {
		return this.jugadores[posJugadorActual].mostrarMano();
	}
	
	//Me muestra quien es el jugador actual
	public String jugadorActual() {
		return jugadores[posJugadorActual].mostrarNombre();
	}

	//Muestra quien gano la jugada
	public String ganadorJugada() {
		return this.jugadorGanadorMano.mostrarNombre();
	}

	//Mostrar quien gano el juego
	public String ganadorJuego() {
		int puntaje = puntajeMaximo;
		Jugador ganador = null;
		int pos = 0;
		while (pos < jugadores.length) {
			if (jugadores[pos].getPuntaje() < puntaje) {
				ganador = jugadores[pos];
				puntaje = jugadores[pos].getPuntaje();
			}
			pos ++;
		}
		return ganador.mostrarNombre();
	}
	
	//Muestra los puntos del ganador del juego
	public String ganadorJuegoPuntos() {
		int puntaje = puntajeMaximo;
		int pos = 0;
		while (pos < jugadores.length) {
			if (jugadores[pos].getPuntaje() < puntaje) {
				puntaje = jugadores[pos].getPuntaje();
			}
			pos ++;
		}
		return String.valueOf(puntaje);
	}

	//Me dice la carta que eligio el usuario
	public String cartaElegida(int posCarta) {
		return jugadores[posJugadorActual].obtenerCarta(posCarta).mostrarCarta();
	}
	
	//Getter con el numero de ronda
	public int getRonda() {
		return this.ronda;
	}
	
	//Notificar los eventos
	@Override
	public void notificar(Object evento) {
		for (Observador observador : this.observadores) {
			observador.actualizar(evento, this);
		}
	}

	//Agregar observadores
	@Override
	public void agregadorObservador(Observador observador) {
		this.observadores.add(observador);
	}


}
