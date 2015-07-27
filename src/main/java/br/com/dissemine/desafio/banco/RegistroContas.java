package br.com.dissemine.desafio.banco;

import java.util.HashMap;
import java.util.Map;

public class RegistroContas {

	private Map<Cliente, Conta> contas = new HashMap<Cliente, Conta>();
	
	public void abrirContaCorrente(Cliente cliente, String agencia, String numero) {
		if (cliente.getContaCorrente() != null) {
			System.out.println("Cliente " + cliente.getNome() + " j· possui conta corrente");
			return;
		}
		
		Conta contaCorrente = new ContaCorrente();
		preencherDadosConta(cliente, agencia, numero, contaCorrente);
		
		contas.put(cliente, contaCorrente);
		System.out.println("Conta corrente aberta para o cliente " + cliente.getNome());
	}

	public void abrirContaPoupanca(Cliente cliente, String agencia, String numero) {
		if (cliente.getContaPoupanca() != null) {
			System.out.println("Cliente " + cliente.getNome() + "j√° possui conta poupanca");
			return;
		}
		
		Conta contaPoupanca = new ContaPoupanca();
		preencherDadosConta(cliente, agencia, numero, contaPoupanca);
		
		contas.put(cliente, contaPoupanca);
		System.out.println("Conta poupanca aberta para o cliente " + cliente.getNome());
	}

	private void preencherDadosConta(Cliente cliente, String agencia, String numero, Conta conta) {
		conta.setCliente(cliente);
		conta.setAgencia(agencia);
		conta.setNumero(numero);
		cliente.adicionarConta(conta);
	}
}
