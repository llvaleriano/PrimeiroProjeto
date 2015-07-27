package br.com.dissemine.desafio.banco;

public class ContaCorrente extends Conta {
	private int totalSaques;
	
	@Override
	public boolean saca(double valor) {
		totalSaques++;
		if (totalSaques > 4) {
			saldo -= 1;
		}
		return super.saca(valor);
	}

	@Override
	public boolean isContaCorrente() {
		return Conta.CONTA_CORRENTE;
	}
}
