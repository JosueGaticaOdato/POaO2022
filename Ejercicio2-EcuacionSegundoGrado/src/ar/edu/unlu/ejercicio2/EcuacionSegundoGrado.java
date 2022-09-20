package ar.edu.unlu.ejercicio2;

import java.util.*;

public class EcuacionSegundoGrado {

	private Integer a;
	private Integer b;
	private Integer c;
	private double raiz1;
	private double raiz2;

	public EcuacionSegundoGrado(Integer coeficienteA, Integer coeficienteB, 
			Integer coeficienteC) {
		 a = coeficienteA;
		 b = coeficienteB;
		 c = coeficienteC;
		 double discriminante = Math.pow(b, 2)-4*a*c;
		 raiz1 = ((-b + Math.sqrt(discriminante)) / 2*a);
		 raiz2 = ((-b - Math.sqrt(discriminante)) / 2*a);
	}
	
	public Integer cantidadRaices() {
		int discriminante = (b^2)-4*a*c;
		int raices = 2;
		if (discriminante == 0) {
			raices = 1;
		}
		return raices;
	}
	
	public Double getraiz1() {
		return raiz1;
	}
	
	public Double getraiz2() {
		return raiz2;
	}
	
	public Integer calcularY(int x) {
		return (a*x^2 + b*x + c);
	}
}
