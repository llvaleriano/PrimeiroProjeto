package br.com.dissemine.desafio.banco;

public class ContaPoupanca extends Conta {

	@Override
	public boolean isContaCorrente() {
		return Conta.CONTA_POUPANCA;
	}

}
