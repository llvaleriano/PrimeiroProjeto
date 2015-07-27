package br.com.dissemine.desafio.banco;

import java.util.HashSet;
import java.util.Set;

public class Cliente {

	private String nome;
	private String cpf;
	private Set<Conta> contas = new HashSet<Conta>();
	
	public void adicionarConta(Conta conta) {
		contas = new HashSet<Conta>();
		contas.add(conta);
	}
	
	public Conta getContaCorrente() {
		for(Conta conta : contas) {
			if (conta.isContaCorrente()) {
				return conta;
			}
		}
		return null;
	}
	
	public Conta getContaPoupanca() {
		for(Conta conta : contas) {
			if (! conta.isContaCorrente()) {
				return conta;
			}
		}
		return null;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Set<Conta> getContas() {
		return contas;
	}
	public void setContas(Set<Conta> contas) {
		this.contas = contas;
	}
}
