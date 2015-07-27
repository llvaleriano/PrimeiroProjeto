package br.com.dissemine.desafio.banco;

import java.security.InvalidParameterException;

public abstract class Conta {
	public final static boolean CONTA_CORRENTE = true;
	public final static boolean CONTA_POUPANCA = false;
	
	protected Cliente cliente;
	protected String agencia;
	protected String numero;
	protected double saldo;
	protected boolean contaCorrente;
	
	public abstract boolean isContaCorrente();
	
	public boolean deposita(double valor) {
		if (valor > 0) {
			saldo += valor;
			System.out.println("Realizando deposito de " + valor );
			return true;
		}
		return false;
	}

	public boolean saca(double valor) {
		if (valor < 0) {
			throw new InvalidParameterException("Valor inválido");
		}
		if (valor <= saldo) {
			saldo -= valor;
			System.out.println("Realizando saque de " + valor);
			return true;
		}
		return false;
	}

	public void verificaSaldo() {
		System.out.println("Saldo: " + saldo);
	}
	
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
}
