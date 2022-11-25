package ar.edu.unlu.ejercicio9;

public class Socio {
	
	private String Nombre;
	private String Apellido;
	private String Direccion;
	private String Email;
	private Integer Suscripcion;
	
	//Constructor: Creacion de un nuevo socio
	public Socio(String nombre, String apellido,String direccion, String email, Integer suscripcion) {
		super();
		Nombre = nombre;
		Apellido = apellido;
		Direccion = direccion;
		Email = email;
		Suscripcion = suscripcion;
	}

	public Integer getSuscripcion() {
		return Suscripcion;
	}

	public void setSuscripcion(Integer suscripcion) {
		Suscripcion = suscripcion;
	}

	//Getters y Setters
	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}
	
	
}
