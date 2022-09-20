package ar.edu.unlu.ejercicio10;

public class Cliente {
	private CuentaNormal ctaNormal;
	
	private CuentaCredito ctaCredito;
	
	private PlazoFijo plazoFijoCliente;
	
	private String nombre;
	
	private int codigo;
	
	public Cliente(String nombrecliente, int codigocliente,
			int saldo, int limDescubierto) {
		nombre = nombrecliente;
		codigo = codigocliente;
		ctaNormal = new CuentaNormal(saldo,limDescubierto);
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public double obtenerSaldoCuentaNormal() {
		return ctaNormal.getSaldo();
	}
	
	public double obtenerLimiteDeGiros() {
		return ctaNormal.getLimiteDescubierto();
	}
	
	
	public void invertir(double monto, int dias) {
		PlazoFijo plazoFijoCliente = new PlazoFijo(dias,monto);
		ctaNormal.gastarDinero(monto);
	}
	
	public boolean tieneInversion() {
		return plazoFijoCliente.getinversion(); 
	}
	
	public double inversionPlazoFijo() {
		return plazoFijoCliente.obtenerMontoInvertido();
	}
	
	public void acreditarInversion() {
		
	}
}
