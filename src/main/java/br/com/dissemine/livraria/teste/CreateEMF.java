package br.com.dissemine.livraria.teste;

import javax.persistence.Persistence;

public class CreateEMF {

	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("livraria-pu");
	}
}
