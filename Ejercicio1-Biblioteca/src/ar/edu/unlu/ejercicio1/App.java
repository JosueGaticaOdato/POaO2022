package ar.edu.unlu.ejercicio1;

import java.util.Scanner;

//Principal!
public class App {
	
	//Main
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Variables a utilizar y creacion de la biblioteca
		String titulo,autor,libro1,libro2;
		Integer menu, isbn, num_paginas, num_ejemplares;
		boolean se_hizo;
		Scanner sc = new Scanner(System.in);
		Biblioteca miBiblioteca = new Biblioteca();
		
		//Menu
	do {
		System.out.println("Menu:");
		System.out.println("1 - Agregar Libro");
		System.out.println("2 - Buscar libro por Autor");
		System.out.println("3 - Buscar libro por Titulo");
		System.out.println("4 - Cantidad de prestamos realizados");
		System.out.println("5 - Cual libro tiene mas paginas?");
		System.out.println("6 - Realizar un prestamo usando el titulo del libro");
		System.out.println("7 - Realizar un prestamo usando el autor del libro");
		System.out.println("8 - Realizar una devolucion usando el titulo del libro");
		System.out.println("9 - Realizar una devolucion usando el autor del libro");
		System.out.println("0 - Salir");
		System.out.println("Elige una opcion: ");
	menu = sc.nextInt();
	//Switch con opciones
	switch (menu) {
	case 1: //Agregar tarea
		sc.nextLine(); //Limpio buffer
		System.out.println("Añade un nuevo libro!!");
		System.out.println("Ingresa el titulo del libro:");
		titulo = sc.nextLine();
		System.out.println("Ingresa el autor del libro");
		//sc.nextLine(); //Limpio buffer
		autor = sc.nextLine();
		System.out.println("Ingresa la cantidad de paginas");
		num_paginas = sc.nextInt();
		System.out.println("Ingresa la cantidad de ejemplares del libro");
		num_ejemplares = sc.nextInt();
		System.out.println("");
		miBiblioteca.agregarLibro(0, titulo, autor, num_paginas, num_ejemplares);
		break;
	case 2: //Buscar por autor
		System.out.println("Ingresa el autor del libro");
		sc.nextLine(); // Limpio buffer
		autor = sc.nextLine();
		int posAutor = miBiblioteca.buscarLibroAutor(autor);
		if (posAutor != -1) {
		System.out.println(miBiblioteca.mostrarDescripcion(posAutor));}
		else System.out.println("Libro no encontrado");
		break;
	case 3: //Buscar por titulo
		System.out.println("Ingresa el titulo del libro");
		sc.nextLine(); // Limpio buffer
		titulo = sc.nextLine();
		int posTitulo = miBiblioteca.buscarLibroTitulo(titulo);
		if (posTitulo != -1) {
		System.out.println(miBiblioteca.mostrarDescripcion(posTitulo));}
		else System.out.println("Libro no encontrado");
		break;
	case 4: //Mostrar prestamos totales
		System.out.println("Cantidad de prestamos realizados: " + miBiblioteca.prestamosTotales());
		break;
	case 5: //Comparacion de paginas
		sc.nextLine(); // Limpio buffer
		System.out.println("Ingresa el titulo del libro 1");
		libro1 = sc.nextLine(); // Limpio buffer
		System.out.println("Ingresa el titulo del libro 2");
		libro2 = sc.nextLine();
		System.out.println("El libro que tiene mas paginas es " + miBiblioteca.masPaginas(libro1, libro2));
		break;
	case 6: //Prestamo por titulo
		sc.nextLine(); // Limpio buffer
		System.out.println("Ingresa el titulo del libro");
		titulo = sc.nextLine();
		se_hizo = miBiblioteca.realizarPrestamoTitulo(titulo);
		if (se_hizo) {
			System.out.println("Prestamo realizado!");
		} else System.out.println("Solamente hay un ejemplar del libro, no se puede realizar el prestamo");
		break;
	case 7: //Prestamo por autor
		sc.nextLine(); // Limpio buffer
		System.out.println("Ingresa el autor del libro");
		autor = sc.nextLine();
		se_hizo = miBiblioteca.realizarPrestamoAutor(autor);
		if (se_hizo) {
			System.out.println("Prestamo realizado!");
		} else System.out.println("Solamente hay un ejemplar del libro, no se puede realizar el prestamo");
		break;
	case 8: //Devolucion por titulo
		sc.nextLine(); // Limpio buffer
		System.out.println("Ingresa el titulo del libro");
		titulo = sc.nextLine();
		se_hizo = miBiblioteca.DevolverPrestamoTitulo(titulo);
		if (se_hizo) {
			System.out.println("Devolucion realizada!");
		} else System.out.println("Hubo un error! no se pudo concretar la devolucion");
		break;
	case 9: //Devolucion por autor
		sc.nextLine(); // Limpio buffer
		System.out.println("Ingresa el autor del libro");
		autor = sc.nextLine();
		se_hizo = miBiblioteca.DevolverPrestamoAutor(autor);
		if (se_hizo) {
			System.out.println("Devolucion realizada!");
		} else System.out.println("Hubo un error! no se pudo concretar la devolucion");
		break;
	case 0: //Fin del programa
		System.out.println("Adios!");
		break;
	default: System.out.println("Opcion incorrecta:");
}
} while (menu != 0); 
	}
}

