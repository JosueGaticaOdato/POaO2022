package ar.edu.unlu.corazones.modelo;

public class Mesa {
	
	//Cartas que puede haber en mesa
	public final int cartasEnMesa = 4;
	
	/*
	 * Atributos
	 */
	private boolean corazones;
	private Carta[] cartasJugadasEnMesa;
	private Carta primerCartaJugada;
	
	/*
	 * Comportamiento
	 */
	
	//Constructor de la clase mesa
	public Mesa() {
		cartasJugadasEnMesa = new Carta[cartasEnMesa];
		this.corazones = false;
	}
	
	//Metodo que recibe la carta junto con el jugador y la carga en las
	//cartas jugadas
	public void recibirCartaTirada(int posicionJugador, Carta carta) {
		if (!primeraCarta()){
			primerCartaJugada = carta;
		}
		cartasJugadasEnMesa[posicionJugador] = carta;
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

	public Carta[] getCartasJugadasEnMesa() {
		return cartasJugadasEnMesa;
	}
	
	

}
