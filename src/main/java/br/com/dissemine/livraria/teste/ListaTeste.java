package br.com.dissemine.livraria.teste;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListaTeste {

	public static void main(String[] args) {
		List<String> nomes = new ArrayList<String>();
		nomes.add("Leonardo");
		nomes.add("Vanessa");
		nomes.add("Filipe");
		nomes.add("Wesley");
		
		Collections.sort(nomes);
		
		for (String nome:nomes) {
			System.out.println("nome:" +nome);
		}

	}
}
