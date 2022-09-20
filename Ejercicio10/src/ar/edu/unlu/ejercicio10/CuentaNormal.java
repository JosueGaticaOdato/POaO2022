package ar.edu.unlu.ejercicio10;

public class CuentaNormal {
		private int saldo;
		
		private int limDescubierto;
		
		public CuentaNormal(int saldoCuentaNormal, int limDescubiertoCuentaNormal) {
			saldo = saldoCuentaNormal;
			limDescubierto = limDescubiertoCuentaNormal;
		}
		
		public int montoTotal() { //Monto total que puede gastar el usuario
			return saldo + limDescubierto;
		}
		
		public int getSaldo() {
			return saldo;
		}
		
		public void setSaldo(int monto) {
			saldo = monto;
		}
		
		public int getLimiteDescubierto() {
			return limDescubierto;
		}
		
		public boolean gastarDinero(int monto) {
			boolean descubierto = false;
			if (monto > saldo) {
				saldo = 0;
				limDescubierto = limDescubierto - monto;
				descubierto = true; //Si utilizo el descubierto uso true
			}
			else saldo = saldo - monto;	
			return descubierto;
		}
		
		public void acreditar(int monto) {
			saldo = saldo + monto;
		}

}