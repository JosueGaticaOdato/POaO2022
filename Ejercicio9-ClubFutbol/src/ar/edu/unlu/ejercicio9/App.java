package ar.edu.unlu.ejercicio9;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ListaSocios MiLista = new ListaSocios(); //Creacion de la lista de socios
		Scanner sc = new Scanner(System.in);
		String nombre, apellido, direccion, email, valorSub;
		Integer menu, suscripcion;
		
			
			//Menu
		do {
			System.out.println("Menu:");
			System.out.println("1 - Agregar Socio");
			System.out.println("2 - Mostrar todos los socios");
			System.out.println("3 - Mostrar actividades para socios");
			System.out.println("4 -	Mostrar actividades habilitadas para un socio");
			System.out.println("Elige una opcion: ");
		menu = sc.nextInt();
		//Switch con opciones
		switch (menu) {
		case 1: //Agregar socio
			sc.nextLine(); //Limpio buffer
			System.out.println("Digame el nombre del nuevo socio:");
			nombre = sc.nextLine();
			System.out.println("Digame el apellido del nuevo socio:");
			apellido = sc.nextLine();
			System.out.println("Digame la direccion del nuevo socio:");
			direccion = sc.nextLine();
			System.out.println("Digame el email del nuevo socio:");
			email = sc.nextLine();
			suscripcion = -1;
			do {
			System.out.println("Digame la suscripcion que desea"
					+ " el del nuevo socio:");
			System.out.println("1.Basica");
			System.out.println("2.Intermedia");
			System.out.println("3.Destacada");
			suscripcion = sc.nextInt();
			} while (suscripcion < 0 || suscripcion > 4);
			
			MiLista.agregarSocio(nombre, apellido,direccion, email, suscripcion);
			
			System.out.println("Nuevo socio cargado!");
			break;
		case 2: //Mostrar todos los socios
			System.out.println(MiLista.mostrarSocios());
			break;
		case 3: //Mostrar actividades para socios
			break;
		case 4: //Mostrar actividades que puede realizar un socio
			break;
		default: System.out.println("Opcion incorrecta:");
	}
	} while (menu != 0); 

	}

}
