package ar.edu.unlu.corazones.vista;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Scanner;
import ar.edu.unlu.corazones.controlador.Controlador;
import ar.edu.unlu.corazones.modelo.Jugador;

/**
 * 
 * Vista de consola
 * Esta se encargara de mostrarle al usuario toda la funcionalidad del sistema
 *
 */

public class VistaConsola implements IVista {
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
			limpiarPantalla(50);
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
			System.out.println("Escriba cualquier tecla para continuar...");
			this.entrada.next();
		}
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
		System.out.println("Juego comenzado!");
		controlador.comenzarJuego();
		//System.out.println(controlador.mostrarGanador());
	}
	
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
	
	public void pedirCarta() {
		System.out.println(this.controlador.mostrarCartasEnMesa());
		System.out.println("Es el turno del jugador: "
				+ this.controlador.jugadorActual());
		System.out.println(this.controlador.mostrarCartasJugadorActual());
		System.out.println("Elija una carta");
		int posCarta = entrada.nextInt();
		controlador.cartaJugada(posCarta - 1);
	}
	
	public void limpiarPantalla(int lineas)
	{
	 for (int i=0; i < lineas; i++)
	 {
	  System.out.println();
	 }
	}

	//Metodo que setea el controlador
	@Override
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}

	public void mostrarGanadorJugada() {
		System.out.println("El jugador que se llevo todas las cartas "
				+ "fue " + this.controlador.ganadorJugada());
	}


}
