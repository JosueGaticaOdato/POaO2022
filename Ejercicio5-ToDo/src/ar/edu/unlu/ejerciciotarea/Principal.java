package ar.edu.unlu.ejerciciotarea;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String descripcion, estado,fecha;
		Integer prioridad,menu,eleccion;
		Scanner sc = new Scanner(System.in);
		
		
		ArrayList<Tarea> ListaTarea = new ArrayList<Tarea>();
		do {
			System.out.println("Menu:");
			System.out.println("1 - Mostrar todas las tareas");
			System.out.println("2 - Agregar tarea");
			System.out.println("3 - Mostrar solo 1 tarea");
			System.out.println("4 - Preguntar si una tarea esta vencida");
			System.out.println("5 - Preguntar si una tarea esta completa");
			System.out.println("6 - Salir");
			System.out.println("Elige una opcion: ");
			menu = sc.nextInt();
			switch (menu) {
				case 1:
					int i = 0;
					while(i < ListaTarea.size()) {
						System.out.println("Tarea N°" + (i + 1));
						System.out.println(ListaTarea.get(i).mostrarTarea() + "\n");
						i++;
					}
					break;
				case 2:
					sc.nextLine(); //Limpio buffer
					System.out.println("Añade una tarea!!");
					System.out.println("Ingresa la descripcion:");
					descripcion = sc.nextLine();
					System.out.println("Ingresa el estado(Completo, Incompleto, Vencido):");
					//sc.nextLine(); //Limpio buffer
					estado = sc.nextLine();
					System.out.println("Ingresa la prioridad[1-99]:");
					prioridad = sc.nextInt();
					System.out.println("Ingrese la fecha de vencimiento: ");
					//sc.nextLine(); //Limpio buffer
					fecha = sc.next();
					System.out.println("");
					LocalDate fechavencimiento = LocalDate.parse(fecha);
					Tarea nuevaTarea = new Tarea(estado,descripcion,prioridad,fechavencimiento);
					ListaTarea.add(nuevaTarea);
					break;
				case 3:
					System.out.println("Numero de la tarea:");
					eleccion = sc.nextInt() - 1;
					System.out.println(ListaTarea.get(eleccion).mostrarTarea());
					break;
				case 4:
					System.out.println("Numero de la tarea:");
					eleccion = sc.nextInt() - 1;
					System.out.println("Tarea: " + ListaTarea.get(eleccion).getTarea());
					System.out.println("Esta vencida? " + ListaTarea.get(eleccion).tareaVencida() );
					break;
				case 5:
					System.out.println("Numero de la tarea:");
					eleccion = sc.nextInt() - 1;
					System.out.println("Tarea: " + ListaTarea.get(eleccion).getTarea());
					System.out.println("Esta completa? " + ListaTarea.get(eleccion).tareaVencida() );
					break;
				default: System.out.println("Opcion incorrecta:");
			}
		} while (menu != 0);
		

		/*//ListaTarea.add(nuevaTarea);
		//System.out.println("Tarea agregada");
		System.out.println(nuevaTarea.mostrarTarea());
		System.out.println("Tarea vencida? " + nuevaTarea.tareaVencida());*/
		
		
		
		
		
		
	}

}
