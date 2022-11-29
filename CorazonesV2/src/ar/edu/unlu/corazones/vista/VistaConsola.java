package ar.edu.unlu.corazones.vista;

import java.util.Scanner;
import ar.edu.unlu.corazones.controlador.Controlador;

/**
 * 
 * Vista de consola
 * Esta se encargara de mostrarle al usuario toda la funcionalidad del sistema
 *
 */

public class VistaConsola implements IVista {
	
	private final int lineas = 50;
	
	private Scanner entrada;
	
	//Pongo como atributo el controlador, que se comunicara con el modelo
	private Controlador controlador;
	
	//Creo la instancia para que el usuario pueda ingresar los datos
	public VistaConsola() {
		this.entrada = new Scanner(System.in);
	}

	//Menu principal del programa
	public void mostrarMenu() {
		System.out.println("         Corazones ");
		System.out.println();
		System.out.println("Selecciona una opcion");
		System.out.println("1 - Crear jugador");
		System.out.println("2 - Modificar jugador");
		System.out.println("3 - Ver lista de jugadores");
		System.out.println("4 - Comenzar juego");
		System.out.println();
		System.out.println("0 - Salir");
		System.out.print("Opcion: ");
	}

	//Iniciar
	@Override
	public void iniciar(){
		boolean salir = false;
		while(!salir) {
			limpiarPantalla(lineas);
			mostrarMenu();
			int opcion = this.entrada.nextInt();
			switch (opcion) {
				case 1: //Crear jugador
					nuevoJugador();
					break;
				case 2: //Modificar jugador por posicion
					modificarJugador();
					break;
				case 3: //Mostrar lista de jugadores 
					System.out.println("Lista de jugadores:");
					System.out.println(controlador.listaJugadores());
					break;
				case 4: //Comenzar juego
					jugar();
					break;
				case 0: //Salir del juego
					salir = true;
					System.out.println("Gracias por jugar!!");
					break;
				default: //Opcion por default
					System.out.println("Opcion no valida.");
			}
			continuar();
		}
	}
	
	//Metodo para cotinaar y no sacar la pantalla de una
	public void continuar() {
		System.out.println("Escriba cualquier tecla para continuar...");
		this.entrada.next();
	}
	
	/**
	 * Modificacion:
	 *   se encarga de solicitarle al usuario tanto el jugador que quiere
	 *	cambiar como el nombre del nuevo jugador para modificarlo en la lista
	 *	de jugadores
	 */
	private void modificarJugador() {
		System.out.println();
		System.out.println("Por favor, ingrese el numero de jugador que quiere modificar:");
		int pos = entrada.nextInt();
		System.out.println("Por favor, ingrese el numero del nuevo jugador:");
		String nombre = entrada.next();
		boolean creado = controlador.modificarJugador(nombre, pos);
		if (creado) {
			//modificar jugador devuelve verdadero si se pudo modificar
			System.out.println("Jugador modificado con exito!");
		} else {
			//devuelve falso en el caso de que sea lo contrario
			System.out.println("No se pudo modificar el jugador.");
		}
		
	}
	
	/**
	 * Jugar
	 */
	private void jugar() {
		if (this.controlador.cantidadDeJugadoresValida()) {
			System.out.println("Juego comenzado!");
			continuar();
			limpiarPantalla(lineas);
			controlador.comenzarJuego();
		} else {
			System.out.println("No estan la cantidad de jugadores suficientes para jugar");
		}
		
	}
	
	//Mostrar puntaje de los jugadores
	public void mostrarPuntaje() {
		System.out.println("Puntaje de los jugadores:");
		System.out.println(controlador.mostrarPuntajes());
	}

	/**
	 * Agregar(alta):
	 * metodo que se encarga de agregar un nuevo jugador al juego
	 */
	
	private void nuevoJugador() {
		System.out.println();
		System.out.println("Por favor, ingrese tu nombre:");
		String nombre = entrada.next();
		boolean creado = controlador.nuevoJugador(nombre);
		if (creado) {
			//creado devuelve verdadero si se pudo agregar bien al jugador
			System.out.println("Jugador creado con exito!");
		} else {
			//y falso si no hay mas lugares en el juego (max 4)
			System.out.println("No se pudo crear el jugador, ya se llego al "
					+ "numero maximo de jugadores.");
		}
	}
	
	/**
	 * Metodo que le pide la carta al usuario
	 */
	
	public void pedirCarta() {
		System.out.println(this.controlador.mostrarCartasEnMesa()); //Muestro lo que hay en mesa
		System.out.println("Es el turno del jugador: "
				+ this.controlador.jugadorActual()); //Digo quien tiene que jugar
		continuar();
		System.out.println(this.controlador.mostrarCartasPosiblesAJugar()); //Muestro las cartas disponibles
		//System.out.println(this.controlador.mostrarCartasJugadorActual()); //Muestro las cartas disponibles
		System.out.println("Las cartas con * son las que se pueden jugar en esta mesa");
		boolean cartaValida = false;
		while (!cartaValida) {
			System.out.println("Elija una carta");
			int posCarta = entrada.nextInt();
			System.out.println("La carta jugada fue " + controlador.mostrarCartaJugada(posCarta - 1)); //Muestro la que eligio
			if (controlador.cartaValida(posCarta - 1)) {
				cartaValida = true;
				controlador.cartaJugada(posCarta - 1); //Paso la carta
			} else {
				System.out.println("Carta invalida! Solo puede tirar cartas del mismo palo que esta en la mesa");
			}
		}
		continuar();
		limpiarPantalla(lineas);
	}
	
	//Limpieza de pantalla (en realidad agrega lineas)
	public void limpiarPantalla(int lineas)
	{
	 for (int i=0; i < lineas; i++)
	 {
	  System.out.println();
	 }
	}

	//Metodo que me muestra quien gano la jugada
	public void mostrarGanadorJugada() {
		System.out.println(this.controlador.mostrarCartasEnMesa());
		System.out.println("El jugador que se llevo todas las cartas "
				+ "fue " + this.controlador.ganadorJugada());
		continuar();
		limpiarPantalla(lineas);
	}

	//Fin del juego, muestra quien gano y por cuantos puntos
	public void finalDeJuego() {
		System.out.println("El ganador del juego fue: "
				+ this.controlador.ganadorJuego() + " ya que consiguio "
						+ "un total de " + this.controlador.ganadorJuegoPuntos());
	}

	//Muestra quien fue el jugador que tiro el 2 de trebol
	public void jugador2deTrebol() {
		System.out.println("El jugador " + controlador.jugadorActual() + " tiro el 2 de trebol");
		
	}

	/**
	 * PASAJE DE CARTAS:
	 * .Muestra a quien se la tiene que pasar, y de quien es el turno
	 */
	
	public void pasajeDeCartas() {
		System.out.println("Pasaje de cartas!!");
		String s = null;
		switch (this.controlador.numeroRonda() % 4) {
			case 0:
				s = ", las cartas se pasaran a la izquierda";
				break;
			case 1:
				s = ", las cartas se pasaran al frente";
				break;
			case 2:
				s = ", las cartas se pasaran a la derecha";
				break;
			case 3:
				s = ", las cartas no se pasaran.";
				break;
		}
		System.out.println("Por ser la ronda " + this.controlador.numeroRonda() + s);
		System.out.println("Es el turno del jugador: "
				+ this.controlador.jugadorActual());
		continuar();
		System.out.println(this.controlador.mostrarCartasJugadorActual());
	}
	
	//Pedir la carta para hacer el pasaje
	public void pedirCartaPasaje() {
		System.out.println("Elija una carta");
		int posCarta = entrada.nextInt();
		System.out.println("La carta elegida fue " + controlador.mostrarCartaJugada(posCarta - 1));
		controlador.cartaJugada(posCarta - 1);
	}

	//Metodo para no mostrarle al otro jugador que jugo
	public void finPasajeDeCartas() {
		continuar();
		limpiarPantalla(lineas);
	}
	
	//Metodo que setea el controlador
	@Override
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}


}
