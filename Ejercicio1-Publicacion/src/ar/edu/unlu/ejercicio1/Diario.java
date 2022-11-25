package ar.edu.unlu.ejercicio1;

import java.time.LocalDate;

public class Diario extends Publicacion {

	private LocalDate fecha;
	
	//Constructor
	public Diario(String nombre, String editor, String numeroTelefono,
			Integer añoPublicacion,
			Integer mes, Integer dia) {
		super(nombre, editor, numeroTelefono, añoPublicacion);
		fecha = LocalDate.of(añoPublicacion, mes, dia);
	}
	
	//Mostrar
	@Override
	public String mostrar() {
		String s;
		s = "Tipo: DIARIO" + "\n" +  ".nombre: " + getNombre() + "\n" 
				+ ".editor: " + this.getEditor() + "\n" + 
				".telefono: " + this.getNumeroTelefono() + "\n" + 
				".Fecha: " + fecha.toString();
		return s;
	}
	
	
}
