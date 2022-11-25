package ar.edu.unlu.ejercicio1;

import java.util.Scanner;

public class App {
	//Main
	public static void main(String[] args) {
		
		
		//Variables a utilizar y creacion de la biblioteca
		String titulo,autor,editor, telefono;
		Integer menu, isbn, num_paginas, num_ejemplares, año, numRevista, mes,dia;
		Scanner sc = new Scanner(System.in);
		Biblioteca miBiblioteca = new Biblioteca();
		
		//Menu
	do {
		System.out.println("Menu:");
		System.out.println("1 - Agregar Libro");
		System.out.println("2 - Agregar Revista");
		System.out.println("3 - Agregar Tesis");
		System.out.println("4 - Agregar Diarios");
		System.out.println("5 - Realizar prestamo Libro");
		System.out.println("6 - Realizar prestamo Revista");
		System.out.println("7 - Realziar prestamo Tesis");
		System.out.println("8 - Realizar prestamo Diarios");
		System.out.println("9 - Mostrar todo");
		System.out.println("0 - Salir");
		System.out.println("Elige una opcion: ");
	menu = sc.nextInt();
	//Switch con opciones
	switch (menu) {
	case 1: //Agregar libro
		sc.nextLine(); //Limpio buffer
		System.out.println("Añade un nuevo libro!!");
		System.out.println("Ingresa el titulo del libro:");
		titulo = sc.nextLine();
		System.out.println("Ingresa el editor del libro:");
		editor = sc.nextLine();
		System.out.println("Ingresa el telefono de contacto del libro:");
		telefono = sc.nextLine();
		System.out.println("Ingresa el año de publicacion:");
		año = sc.nextInt();
		System.out.println("Ingresa el ISBN:");
		isbn = sc.nextInt();
		System.out.println("Ingresa el autor:");
		sc.nextLine(); //Limpio buffer
		autor = sc.nextLine();
		System.out.println("Ingresa la cantidad de paginas:");
		num_paginas = sc.nextInt();
		System.out.println("Ingresa la cantidad de ejemplares del libro:");
		num_ejemplares = sc.nextInt();
		System.out.println("");
		miBiblioteca.agregarLibro(titulo, editor, telefono, año, num_ejemplares, isbn, autor, num_paginas);
		break;
	case 2: //Agregar revista
		sc.nextLine(); //Limpio buffer
		System.out.println("Añade una nueva revista!!");
		System.out.println("Ingresa el titulo de la revista:");
		titulo = sc.nextLine();
		System.out.println("Ingresa el editor de la revista:");
		editor = sc.nextLine();
		System.out.println("Ingresa el telefono de contacto de la revista:");
		telefono = sc.nextLine();
		System.out.println("Ingresa el año de publicacion:");
		año = sc.nextInt();
		System.out.println("Ingresa el ISSN:");
		isbn = sc.nextInt();
		System.out.println("Ingresa el numero de revista:");
		numRevista = sc.nextInt();
		System.out.println("Ingresa la cantidad de ejemplares de la revista:");
		num_ejemplares = sc.nextInt();
		miBiblioteca.agregarRevista(titulo, editor, telefono, año, isbn, numRevista, num_ejemplares);
		break;
	case 3: //Agregar Tesis
		sc.nextLine(); //Limpio buffer
		System.out.println("Añade una nueva tesis!!");
		System.out.println("Ingresa el titulo de la tesis:");
		titulo = sc.nextLine();
		System.out.println("Ingresa el editor de la tesis:");
		editor = sc.nextLine();
		System.out.println("Ingresa el telefono de contacto de la tesis:");
		telefono = sc.nextLine();
		System.out.println("Ingresa el año de publicacion:");
		año = sc.nextInt();
		System.out.println("Ingresa el autor:");
		autor = sc.nextLine();
		System.out.println("Ingresa el mes de publicacion:");
		mes = sc.nextInt();
		System.out.println("Ingresa la cantidad de ejemplares de la tesis:");
		num_ejemplares = sc.nextInt();
		miBiblioteca.agregarTesis(titulo, editor, telefono, año, num_ejemplares, autor, mes);
		break;
	case 4: //Agregar Diarios
		sc.nextLine(); //Limpio buffer
		System.out.println("Añade un nuevo diario!!");
		System.out.println("Ingresa el titulo del diario:");
		titulo = sc.nextLine();
		System.out.println("Ingresa el editor del diario:");
		editor = sc.nextLine();
		System.out.println("Ingresa el telefono de contacto del diario:");
		telefono = sc.nextLine();
		System.out.println("Ingresa el año de publicacion:");
		año = sc.nextInt();
		System.out.println("Ingresa el mes de publicacion:");
		mes = sc.nextInt();
		System.out.println("Ingresa el dia de publicacion:");
		dia = sc.nextInt();
		System.out.println("Ingresa la cantidad de ejemplares de la tesis:");
		num_ejemplares = sc.nextInt();
		miBiblioteca.agregarDiario(titulo, editor, telefono, año, num_ejemplares, dia, mes);
		break;
	case 5: //Comparacion de paginas
		break;
	case 6: //Prestamo por titulo
		break;
	case 7: //Prestamo por autor
		break;
	case 8: //Devolucion por titulo
		break;
	case 9: //Devolucion por autor
		System.out.println(miBiblioteca.mostrarTodo());
		break;
	case 0: //Fin del programa
		System.out.println("Adios!");
		break;
	default: System.out.println("Opcion incorrecta:");
}
} while (menu != 0); 
	}
}

