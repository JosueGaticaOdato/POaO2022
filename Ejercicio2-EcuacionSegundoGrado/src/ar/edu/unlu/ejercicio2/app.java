package ar.edu.unlu.ejercicio2;

import java.util.Scanner;

public class app {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a,b,c,x, opcion;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Dime los coeficiente de la Ecuacion de Segundo Grado:");
		System.out.println("A:");
		a = sc.nextInt();
		System.out.println("B:");
		b = sc.nextInt();
		System.out.println("C:");
		c = sc.nextInt();
		EcuacionSegundoGrado ecuacion = new EcuacionSegundoGrado(a,b,c);
		
		if (ecuacion.cantidadRaices() == 2) {
		System.out.println("La ecuacion tiene " + ecuacion.cantidadRaices()
				+ " raices, que son ");
		System.out.println("X1: " + ecuacion.getraiz1());
		System.out.println("X2: " + ecuacion.getraiz2());
		} else
			System.out.println("La ecuacion tiene solamente 1 raiz, que es " + ecuacion.getraiz1());
		
		do{
		System.out.println("Calculo de los valores de Y");
		System.out.println("Dime un valor de X:");
		x = sc.nextInt();
		System.out.println("El valor de Y cuando X vale " + x + " es "
				+ ecuacion.calcularY(x));
		System.out.println("Continuar calculando Y?:");
		System.out.println("1 - Si");
		System.out.println("2 - No");
		System.out.println("");
		opcion = sc.nextInt();} while (opcion == 1);
}
}
