package ar.edu.unlu.corazones.modelo;

/**
 * CLASE CARTA
 * 	Objeto que identificara las cartas que se utilizan en el juego
 * 	En este caso, el puntaje de las cartas se determina en la iniciliazacion del objeto,
 *  segun el palo al que pertenezca la carta
 *
 */
public class Carta {
	
	// *************************************************************
	//                        CONSTANTES
	// *************************************************************
	
	//Constantes del valor de las cartas
	private final int DAMADEPICAS = 13;
	private final int CORAZONES = 1;
	private final int OTRAS = 0;
	
	// *************************************************************
	//                        ATRIBUTOS
	// *************************************************************

	
	//Valor del palo que tiene la carta
	private Palo palo;
	
	//Valor (1 a 13) que tiene la carta
	private int valor;
	
	//Valor texto
	private String valorTexto;
	
	//Puntaje que tiene la carta en el juego Corazones
	private int puntaje;
	
	// *************************************************************
	//                       CONSTRUCTOR
	// *************************************************************
	
	public Carta(Palo palo, int valor) {
		this.palo = palo;
		this.valor = valor;
		//Determino el puntaje de la carta cada vez que la inicializo
		puntajeCarta();
		valorCarta();
	}
	
	// *************************************************************
	//                       COMPORTAMIENTO
	// *************************************************************
	
	//Metodo que muestra la carta en forma de string
	public String mostrarCarta() {
			return valorTexto + "-" + palo.toString();
	}
	
	//Obtener el valor real de la carta
	private void valorCarta() {
		switch (this.valor) {
		case 11:
			this.valorTexto = "J";
			break;
		case 12:
			this.valorTexto = "Q";
			break;
		case 13:
			this.valorTexto = "K";
			break;
		case 14:
			this.valorTexto = "A";
			break;
		default:
			this.valorTexto = String.valueOf(this.valor);
			break;
		}
	}
	
	//Metodo privado, propia de la carta, que determina el puntaje de la
	//misma en el juego Corazones
	private void puntajeCarta() {
		//Si la carta es de corazones, entonces vale 1 punto
		if (palo == Palo.CORAZONES){
			this.puntaje = CORAZONES;
		//En cambio, si es la dama de picas, vale 13 puntos
		} else if (palo == Palo.PICAS && valor == 12) {
			this.puntaje = DAMADEPICAS;
		//Sino, la carta no vale nada en este juego
		} else {
			this.puntaje = OTRAS;
		}
	}
	
	// *************************************************************
	//                      GETTERS
	// *************************************************************
	
	//Getter para obtener el valor del palo de la carta
	public Palo getPalo() {
		return palo;
	}

	//Getter para obtener el valor del palo de la carta
	public int getValor() {
		return valor;
	}
	
	//Getter para obtener el puntaje de la carta
	public int getPuntaje() {
		return this.puntaje;
	}
}
