package ar.edu.unlu.corazones.modelo;

/**
 * ENUMERADO EVENTO CORAZONES
 * Enumerado con todos los eventos/situaciones que pueden suceder en el juego
 * Esto permite la comunicacion entre vista, controlador y modelo
 */

public enum EventosCorazones {
	PEDIR_CARTA, 
	GANADOR_JUGADA,
	FIN_DE_RONDA,
	FIN_DE_JUEGO,
	JUGO_2_DE_TREBOL,
	PASAJE_DE_CARTAS,
	PEDIR_CARTA_PASAJE,
	FIN_PASAJE_DE_CARTAS;
}
