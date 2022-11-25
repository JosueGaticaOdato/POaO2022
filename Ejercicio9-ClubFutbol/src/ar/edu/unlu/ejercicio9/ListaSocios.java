package ar.edu.unlu.ejercicio9;

import java.util.ArrayList;

public class ListaSocios {
	
	private ArrayList<Socio> ListaDeSocios;
	
	public ListaSocios() {
		ArrayList<Socio> ListaDeSocios = new ArrayList<Socio>();
	}
	
	public void agregarSocio(String nombre, String apellido,String direccion, String email, Integer suscripcion) {
		Socio newSocio = new Socio(nombre, apellido,direccion, email, suscripcion);
		ListaDeSocios.add(newSocio);
	}
	
	public String mostrarSocios() {
		String s = "";
		for (int i=0 ; i<ListaDeSocios.size() ; i++) {
			s = s + " Socio N° " + (i + 1 ) + "\n"
					+ "Nombre:  " + ListaDeSocios.get(i).getNombre() + "\n"
					+ "Apellido:  " + ListaDeSocios.get(i).getApellido() + "\n"
					+ "Direccion:  " + ListaDeSocios.get(i).getDireccion()+ "\n"
					+ "Email:  " + ListaDeSocios.get(i).getEmail() + "\n"
					+ "Suscripcion:  " + ListaDeSocios.get(i).getSuscripcion() + "\n";
		}
		return s; 
		}
	}

