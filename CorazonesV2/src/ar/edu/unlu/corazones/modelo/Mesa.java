package ar.edu.unlu.corazones.modelo;

public class Mesa {
	
	//Cartas que puede haber en mesa
	public final int cartasEnMesa = 4;
	
	/*
	 * Atributos
	 */
	//private boolean corazones;
	private Carta[] cartasJugadasEnMesa;
	private Carta primerCartaJugada;
	
	/*
	 * Comportamiento
	 */
	
	//Constructor de la clase mesa
	public Mesa() {
		cartasJugadasEnMesa = new Carta[cartasEnMesa];
		//this.corazones = false;
	}
	
	//Metodo que recibe la carta junto con el jugador y la carga en las
	//cartas jugadas
	public void recibirCartaTirada(int posicionJugador, Carta carta) {
		if (!primeraCarta()){
			primerCartaJugada = carta;
		}
		cartasJugadasEnMesa[posicionJugador] = carta;
	}
	
	//Getter para obtener la primera carta que se jugo
	public Carta getPrimerCartaJugada() {
		return primerCartaJugada;
	}

	//Metodo que me dice si es la primera carta que se juega
	//Esto es fundamental ya que el palo de esta determina
	//cual sera la carta mas alta
	public boolean primeraCarta() {
		boolean NoesElPrimero = false;
		int pos = 0;
		while (!NoesElPrimero && pos < cartasJugadasEnMesa.length) {
			if (cartasJugadasEnMesa[pos] != null){
				NoesElPrimero = true;
			}
			pos++;
		}
		return NoesElPrimero;
	}
	
	//Metodo para determinar quien fue el ganador de esa jugada
	public int determinarGanador() {
		Palo paloMejorCarta = primerCartaJugada.getPalo();
		int valorMejorCarta = primerCartaJugada.getValor();
		int posicionGanador = 0;
		for (int cartaJugada = 0; cartaJugada < cartasEnMesa; cartaJugada++) {
			if (cartasJugadasEnMesa[cartaJugada].getPalo() == paloMejorCarta
					&& cartasJugadasEnMesa[cartaJugada].getValor() >= valorMejorCarta) {
				paloMejorCarta = cartasJugadasEnMesa[cartaJugada].getPalo();
				valorMejorCarta = cartasJugadasEnMesa[cartaJugada].getValor();
				posicionGanador = cartaJugada;
			}
		}
		return posicionGanador;
	}

	//Mostrar las cartas que se jugaron
	public Carta[] getCartasJugadasEnMesa() {
		return cartasJugadasEnMesa;
	}
	
	//Obtener la posicion del jugador que gano
	public int posicionGanador() {
		return this.posicionGanador();
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
	
	

}
