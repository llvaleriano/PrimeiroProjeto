package br.com.dissemine.desafio;

public class Fatorial {
	
	public static void main(String[] args) {
		for (byte i=0; i<= 20; i++) {
			System.out.println(i + "! = " + calcular(i));
		}
	}
	
	public static long calcular(int numero) {
		if (numero == 0) {
			return 1;
		}
		if (numero == 1) {
			return 1;
		}
		
		return numero * calcular(numero -1);
	}
}
