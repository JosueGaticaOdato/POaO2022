package ar.edu.unlu.ejercicio10;

import java.util.Scanner;

public class AppEjercicio10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int diasPlazoFijo = 10; 
		String nombre;
		int codigo, saldoCN, limCN, opcion;
		double monto;
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese su nombre:");
		nombre = sc.nextLine();
		System.out.println("Ingrese el codigo:");
		codigo = sc.nextInt();
		System.out.println("Ingrese el saldo de la cuenta normal:");
		saldoCN = sc.nextInt();
		System.out.println("Ingrese el limite descubierto de la cuenta:");
		limCN = sc.nextInt();
		
		//Creacion del usuario
		Cliente Usuario = new Cliente(nombre,codigo,saldoCN,limCN);
		
		
		//Menu
		do {
			System.out.println("Ejercicio 10 - Billetera Virtual");
			System.out.println("1 - Salto de la cuenta normal");
			System.out.println("2 - Limite de giros en descubierto");
			System.out.println("3 - Invertir en plazo fijo ");
			System.out.println("4 - Mostrrar monto invertido en plazo fijo");
			System.out.println("5 - ");
			System.out.println("0 - Salir");
			System.out.println("Opcion: ");
			opcion = sc.nextInt();
			
			switch (opcion){
				case 1:
					System.out.println("Saldo cuenta normal: " 
							+ Usuario.obtenerSaldoCuentaNormal());
					break;
				case 2:
					System.out.println("Limite de giros en descubierto: " 
				+ Usuario.obtenerLimiteDeGiros());
					break;
				case 3:
					System.out.println("Cual es el monto que quiere invertir?");
					monto = sc.nextDouble();
					if (!Usuario.tieneInversion()){
						Usuario.invertir(monto, diasPlazoFijo);
					}
					else {
						System.out.println("No se puede realizar la inversion, ya el usuario realizo una.");
					}
					
					break;
				case 4:
					System.out.println("Monto invertido en plazo fijo: " 
							+ Usuario.inversionPlazoFijo());;
					break;
				case 5:;
					break;
			}
			
			sc.nextLine();
		} while (opcion != 0);
		
		sc.close();
	}

}
