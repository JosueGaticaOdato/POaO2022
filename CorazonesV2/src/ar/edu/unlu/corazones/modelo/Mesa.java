package ar.edu.unlu.corazones.modelo;

/**
 * CLASE MESA:
 *	Objeto donde se llevaran a cabo las jugadas 
 *  Las cartas jugadas en mesa se guardaran en un array, donde la posicion representa al numero del jugador
 *  
 */

public class Mesa {
	
	// *************************************************************
	//                        CONSTANTES
	// *************************************************************
	
	//Cartas que puede haber en mesa
	public final int cartasEnMesa = 4;
	
	// *************************************************************
	//                        ATRIBUTOS
	// *************************************************************
	
	//private boolean corazones;
	private Carta[] cartasJugadasEnMesa;
	private Carta primerCartaJugada;
	
	// *************************************************************
	//                       CONSTRUCTOR
	// *************************************************************
	
	//Constructor de la clase mesa
	public Mesa() {
		cartasJugadasEnMesa = new Carta[cartasEnMesa];
		//this.corazones = false;
	}
	
	// *************************************************************
	//                       COMPORTAMIENTO
	// *************************************************************
	
	//Metodo que recibe la carta junto con el jugador y la carga en las
	//cartas jugadas
	public void recibirCartaTirada(int posicionJugador, Carta carta) {
		if (!primeraCarta()){ //Consulto si no es la primera carta jugada, ya que esta determina como
			//llevara a cabo la jugada
			primerCartaJugada = carta;
		}
		cartasJugadasEnMesa[posicionJugador] = carta; //Guardo la carta
	}

	//Metodo que me dice si es la primera carta que se juega
	//Esto es fundamental ya que el palo de esta determina
	//cual sera la carta mas alta
	public boolean primeraCarta() {
		boolean NoesElPrimero = false;
		int pos = 0;
		while (!NoesElPrimero && pos < cartasJugadasEnMesa.length) { //Busco en la mesa si hay alguna carta jugada
			if (cartasJugadasEnMesa[pos] != null){
				NoesElPrimero = true;
			}
			pos++;
		}
		return NoesElPrimero;
	}
	
	//Metodo para determinar quien fue el ganador de esa jugada
	public int determinarGanador() {
		Palo paloMejorCarta = primerCartaJugada.getPalo(); //Obtengo palo de la primera  carta
		int valorMejorCarta = primerCartaJugada.getValor(); //Obtengo valor de la primera carta
		int posicionGanador = 0;
		for (int cartaJugada = 0; cartaJugada < cartasEnMesa; cartaJugada++) { //Recorro todo mi arreglo
			//Si hay una carta del mismo palo que sobrepase a la mejor que esta en mesa, entonces esa es la mejor
			if (cartasJugadasEnMesa[cartaJugada].getPalo() == paloMejorCarta
					&& cartasJugadasEnMesa[cartaJugada].getValor() >= valorMejorCarta) {
				paloMejorCarta = cartasJugadasEnMesa[cartaJugada].getPalo(); //Cambio valores mejor carta
				valorMejorCarta = cartasJugadasEnMesa[cartaJugada].getValor();
				posicionGanador = cartaJugada; //Guardo la posicion del jugador que gano
			}
		}
		return posicionGanador; //Retorno la posicion de la persona que gano
	}

	
	//Mostrar las cartas en mesa
	public String mostrarCartasEnMesa() {
		String s = "Cartas en mesa:"  + "\n";
		for (int i = 0; i < cartasJugadasEnMesa.length; i++) {
			if (cartasJugadasEnMesa[i] != null) {
				s += "Jugador " + (i + 1) + " - " + cartasJugadasEnMesa[i].mostrarCarta() + "\n";
			} else {
				s += "Jugador " + (i + 1) + " - Ninguna" + "\n" ;
			}
			
		}
		return s;
	}
	
	// *************************************************************
	//                      GETTERS
	// *************************************************************
	
	//Mostrar las cartas que se jugaron
	public Carta[] getCartasJugadasEnMesa() {
		return cartasJugadasEnMesa;
	}
	
	//Obtener la posicion del jugador que gano
	public int posicionGanador() {
		return this.posicionGanador();
	}
	
	//Getter para obtener la primera carta que se jugo
	public Carta getPrimerCartaJugada() {
		return primerCartaJugada;
	}

}
