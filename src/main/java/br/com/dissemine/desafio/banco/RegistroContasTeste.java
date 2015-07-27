package br.com.dissemine.desafio.banco;

public class RegistroContasTeste {

	private Cliente rick, erick, marina;
	private RegistroContas registroContas = new RegistroContas();
	
	public static void main(String[] args) {
		RegistroContasTeste teste = new RegistroContasTeste();
		
		teste.criaClientes();
		teste.abreContasCorrente();
		teste.movintaContaCorrente();
		
		teste.abreContasPoupanca();
		teste.movintaContaPoupanca();
	}
	
	private void criaClientes() {
		rick = new Cliente();
		rick.setNome("Rick");
		rick.setCpf("11111111111");
		
		erick = new Cliente();
		erick.setNome("Erick");
		erick.setCpf("22222222222");
		
		marina = new Cliente();
		marina.setNome("Marina");
		marina.setCpf("33333333333");
	}
	
	private void abreContasCorrente() {
		System.out.println("--- Abrindo contas corrente novas...");
		registroContas.abrirContaCorrente(rick, "123", "123456");
		registroContas.abrirContaCorrente(marina, "123", "123321");
		registroContas.abrirContaCorrente(erick, "123", "321123");
		
		System.out.println("--- Tentando abrir contas para clientes que j· tem conta corrente");
		registroContas.abrirContaCorrente(rick, "123", "123456");
		registroContas.abrirContaCorrente(marina, "123", "123321");
		registroContas.abrirContaCorrente(erick, "123", "321123");
	}
	
	private void abreContasPoupanca() {
		System.out.println("--- Abrindo contas poupanca novas...");
		registroContas.abrirContaPoupanca(rick, "123", "123456");
		registroContas.abrirContaPoupanca(marina, "123", "123321");
		registroContas.abrirContaPoupanca(erick, "123", "321123");
		
		System.out.println("--- Tentando abrir contas para clientes que j√° tem conta corrente");
		registroContas.abrirContaPoupanca(rick, "123", "123456");
		registroContas.abrirContaPoupanca(marina, "123", "123321");
		registroContas.abrirContaPoupanca(erick, "123", "321123");
	}

	private void movintaContaCorrente() {
		System.out.println("--- Realizando depositos e saques em conta corrente");
		Conta contaMarina = marina.getContaCorrente();
		contaMarina.deposita(1000);
		contaMarina.saca(100);
		contaMarina.verificaSaldo();
		contaMarina.saca(100);
		contaMarina.verificaSaldo();
		contaMarina.saca(100);
		contaMarina.verificaSaldo();
		contaMarina.saca(100);
		contaMarina.verificaSaldo();
		contaMarina.saca(100);
		contaMarina.verificaSaldo();
	}
	
	private void movintaContaPoupanca() {
		System.out.println("--- Realizando depositos e saques em poupanca");
		Conta contaMarina = marina.getContaPoupanca();
		contaMarina.deposita(1000);
		contaMarina.saca(100);
		contaMarina.verificaSaldo();
		contaMarina.saca(100);
		contaMarina.verificaSaldo();
		contaMarina.saca(100);
		contaMarina.verificaSaldo();
		contaMarina.saca(100);
		contaMarina.verificaSaldo();
		contaMarina.saca(100);
		contaMarina.verificaSaldo();
	}	
}
