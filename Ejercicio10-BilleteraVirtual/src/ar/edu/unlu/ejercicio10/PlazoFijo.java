package ar.edu.unlu.ejercicio10;

import java.time.Duration; //Libreria para el calculo entre fechas
import java.time.LocalDate;

public class PlazoFijo {
	private LocalDate fechaInicio;
	
	private int dias;
	
	private double monto;
	
	private double interes = 0.4;
	
	private boolean inversion;
	
	private CuentaNormal ctaNormal;
	
	public boolean getinversion(){
		return inversion;
	}
	
	public PlazoFijo(int diasPF, double montoPF)
	{
		dias = diasPF;
		monto = montoPF;
		inversion = true;
	}
	
	public double obtenerMontoInvertido() {
		return monto;
	}
	
	
	public boolean estaVencido() {
		LocalDate fechaactual = LocalDate.now();
		Duration diff = Duration.between(fechaInicio.atStartOfDay(), fechaactual.atStartOfDay());
		long diffDays = diff.toDays();
		return (dias > diffDays);
	}
}
