package ar.edu.unlu.ejercicio10;

public class CuentaNormal {
		private double saldo;
		
		private double limDescubierto;
		
		public CuentaNormal(double saldoCuentaNormal, double limDescubiertoCuentaNormal) {
			saldo = saldoCuentaNormal;
			limDescubierto = limDescubiertoCuentaNormal;
		}
		
		public double montoTotal() { //Monto total que puede gastar el usuario
			return saldo + limDescubierto;
		}
		
		public double getSaldo() {
			return saldo;
		}
		
		public void setSaldo(double monto) {
			saldo = monto;
		}
		
		public double getLimiteDescubierto() {
			return limDescubierto;
		}
		
		public boolean gastarDinero(double monto) {
			boolean descubierto = false;
			if (monto > saldo) {
				monto = monto - saldo;
				saldo = 0;
				limDescubierto = limDescubierto - monto;
				descubierto = true; //Si utilizo el descubierto uso true
			}
			else saldo = saldo - monto;	
			return descubierto;
		}
		
		public void acreditar(double monto) {
			saldo = saldo + monto;
		}

}
