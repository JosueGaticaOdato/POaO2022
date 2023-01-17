package ar.edu.unlu.corazones.modelo;

import java.util.Random;

/**
 * CLASE MAZO:
 *	Objeto donde estaran las cartas a jugar
 *  El mazo es una pila (implementada como array) donde 
 *  se le reparten a los jugadores las cartas que estan en el tope del mazo
 *  
 */

public class Mazo {
	
	// *************************************************************
	//                        CONSTANTES
	// *************************************************************
	
	//Cantidad de cartas fija
	public final int Cant_Cartas = 52;
	
	//Cantidad de veces que se le hacen los swaps a las cartas
	//(Mayor sera el mayor, mejor sera la mezcla)
	public final int Cant_Mezcla = 50;

	// *************************************************************
	//                        ATRIBUTOS
	// *************************************************************
	
	//El mazo, que sera un array de cartas
	private Carta[] mazo;
	
	//Posicion del tope del mazo
	private int tope;
	
	// *************************************************************
	//                       CONSTRUCTOR
	// *************************************************************
	
	//Constructor de la clase Mazo
	public Mazo() {
		this.mazo = new Carta[Cant_Cartas];
		this.tope = Cant_Cartas - 1;
		//Llamo al metodo crear mazo que crea el mazo
		crearMazo();
		//LLamo al metodo para mezclar el mazo
		barajarMazo();
		
	}
	
	// *************************************************************
	//                       COMPORTAMIENTO
	// *************************************************************
	
	//Metodo que saca la carta del tope del mazo
	public Carta sacarCarta() {
		//Obtengo la carta que saque
		Carta cartaSacada = mazo[this.tope];
		//Hago nulo la posicion de la carta que saque
		mazo[this.tope] = null;
		//Reduzco el valor del tope (ahora hay menos cartas)
		this.tope -= 1;		
		//Devuelvo la carta que saque
		return cartaSacada;
	}
	
	//Metodo propio del constructor que crea el mazo
	private void crearMazo() {
		//Creo la variable con los palos que tengo disponible
		Palo[] misPalos = Palo.values();
		
		int posicion = 0;	
		
		//Primero recorro todos los palos que tengo 
		//CORAZONES, DIAMANTES, PICAS Y TREBOLES
		for (int valorPalo = 0; valorPalo < 4; valorPalo++ ) {
			
			//Luego, recorro los 13 valores que tienen cada carta
			for (int numeroCarta = 2; numeroCarta < 15; numeroCarta++) {
				//Agrego al mazo las cartas que van del 1 al 13
				mazo[posicion] = new Carta(misPalos[valorPalo], numeroCarta);
				posicion++;
				}
			}
	}
	
	//Metodo que baraja el mazo de cartas
	private void barajarMazo() {
		
		//Creo el objeto random para obtener un numero random
		Random rand = new Random(); 
		
		for (int mezcla = 0; mezcla < Cant_Mezcla; mezcla++) {
			
			//Obtengo dos posiciones random dentro de las cartas
			int posicion1 = rand.nextInt(52);
			int posicion2 = rand.nextInt(52);
			
			//Realizo el intercambio de lugares
			Carta swap = mazo[posicion1];
			mazo[posicion1] = mazo[posicion2];
			mazo[posicion2] = swap;
		}
	}
}
