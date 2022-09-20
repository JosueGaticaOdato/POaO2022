package ar.edu.unlu.ejercicio6;

public class Palabra {

	private String palabra;
	
	public Palabra(String palabraAgregada) {
		palabra = palabraAgregada;
	}
	
	public String getPalabra() {
		return palabra;
	}
	
	public int puntaje() {
		int puntos = 0;
		for (int i = 0; i < palabra.length(); i++) { //Recorre palabra
		       if (palabra.charAt(i) == 'k' || palabra.charAt(i) == 'z' ||
		       palabra.charAt(i) == 'x' || palabra.charAt(i) == 'y' 
		       || palabra.charAt(i) == 'w' || palabra.charAt(i) == 'q'){
		        	puntos = puntos + 2;
		        }
		        else {
		        	puntos = puntos + 1;
		        }
		    }
		return puntos;
		} 
		
	}
