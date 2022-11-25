package ar.edu.unlu.ejerciciotarea;
import java.time.LocalDate;

public class Tarea {
	private String estado;
	
	private String descripcion;
	
	private Integer prioridad;
	
	private LocalDate fecha_limite = LocalDate.now();
	
	//Constructor
	public Tarea(String cestado, String cdescripcion, Integer cprioridad,
				LocalDate cfecha_limite) {
		descripcion = cdescripcion;
		prioridad = cprioridad;
		fecha_limite = cfecha_limite;
		if (tareaVencida()) {
			estado = "Vencida";
		}else estado = cestado ;
	}
	
	public String getTarea() {
		return descripcion;
	}
	
	
	public boolean tareaVencida() { 
		return fecha_limite.isBefore(LocalDate.now());
	}
	
	public void cambiarPrioridad(Integer nuevaPrioridad) {
		prioridad = nuevaPrioridad;
	}
	
	public void modificarDescripcion(String nuevaDescripcion) {
		descripcion = nuevaDescripcion;
	}
	
	public String mostrarTarea() {
		String s;
		if (tareaVencida()) {
			s = "(Vencida) Tarea: " + descripcion + "\nEstado: " + estado + "\nPrioridad: "
					+ prioridad + "\nFecha vencimiento: "  + fecha_limite;
		} else {
			s = "Tarea: " + descripcion + "\nEstado: " + estado + "\nPrioridad: "
					+ prioridad + "\nFecha vencimiento: "  + fecha_limite;}
		return s;
		}
		
	
	public boolean tareaCompleta(){
		return ((estado == "completa") || (estado == "Completa"));
	}
	}
