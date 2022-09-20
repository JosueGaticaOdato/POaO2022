package ar.edu.unlu.ejercicio3;

import java.util.ArrayList;

import java.util.Scanner;


public class appejercicio3 {

	//Main
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int longitud, cantidad;
		int opcion = 1;
		String s;

		Scanner sc = new Scanner(System.in);
		
		//Creacion del arreglod de contraseñas
		ArrayList<Contraseña> ContraseñasGuardadas = new ArrayList<Contraseña>();
		
		do {
		//Tomo la longitud y la cantidad de contraseñas a crear
		System.out.println("Creador de contraseñas");
		System.out.println("Determinar longitud:");
		longitud = sc.nextInt();
		System.out.println("Cantidad de contraseña a crear:");
		cantidad = sc.nextInt();
		
		//Voy metiendo en el array a medida que creo
		for (int i = 0; i < cantidad; i++) {
			Contraseña password = new Contraseña(longitud);
			ContraseñasGuardadas.add(password);
		}
		
		System.out.println("Contraseñas generadas");
		
		System.out.println("Mostrando contraseñas:");
		
		//Muestra la contraseña y el tipo que es
		for (int i = 0; i < ContraseñasGuardadas.size(); i++) {
			//Mando el mensaje consultando el tipo de contraseña
			//que es
			if (ContraseñasGuardadas.get(i).tipoContraseña()) {
				s = "Contraseña " + ContraseñasGuardadas.get(i).getContraseña() + " - Fuerte";
			}
			else {
				s = "Contraseña " + ContraseñasGuardadas.get(i).getContraseña() + " - Debil";
			}
			System.out.println(s);
			System.out.println("");
		}
		
		//Consultar si queire seguir creando contraseñas
		System.out.println("Quiere seguir creando contraseñas? ");
		System.out.println("1 - Si");
		System.out.println("2 - No");
		opcion = sc.nextInt();
		} while (opcion != 2);
	
		System.out.println("Adios!");
		sc.close();
	}

}
