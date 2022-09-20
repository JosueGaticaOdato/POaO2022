package ar.edu.unlu.ejercicio10;

public class Cliente {
	private CuentaNormal ctaNormal;
	
	//private CuentaCredito ctaCredito;
	
	//private PlazoFijo plazoFijoCliente;
	
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
	
	
	public void invertir(int monto, int dias) {
		ctaNormal.gastarDinero(monto);
	}
	
	public boolean tieneInversion() {
		return true; //cambiar
	}
	
	public void acreditarInversion() {
		
	}
}