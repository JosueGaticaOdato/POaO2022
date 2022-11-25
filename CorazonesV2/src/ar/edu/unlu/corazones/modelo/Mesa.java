package ar.edu.unlu.corazones.modelo;

public class Mesa {
	
	//Cartas que puede haber en mesa
	public final int cartasEnMesa = 4;
	
	private boolean corazones;
	private Carta[] cartasJugadasEnMesa;
	private Carta primerCartaJugada;
	
	public Mesa() {
		cartasJugadasEnMesa = new Carta[cartasEnMesa];
		this.corazones = false;
	}
	
	public void recibirCartaTirada(int posicionJugador, Carta carta) {
		boolean esElPrimero = false;
		int pos = 0;
		while (!esElPrimero) {
			if (cartasJugadasEnMesa[posicionJugador] == null){
				esElPrimero = true;
				primerCartaJugada = carta;
			} else {
				pos++;
			}
		}
		cartasJugadasEnMesa[posicionJugador] = carta;
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
			}
		}
		return posicionGanador;
	}

	public Carta[] getCartasJugadasEnMesa() {
		return cartasJugadasEnMesa;
	}
	
	

}
