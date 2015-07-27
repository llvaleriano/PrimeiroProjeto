package br.com.dissemine.livraria.dominio;

import java.util.HashMap;
import java.util.Map;

import br.com.dissemine.livraria.dominio.produtos.Produto;

public class CarrinhoMapa {
	
	private double totalCompra=0;
	private Map<Produto, Integer> produtos = new HashMap<Produto, Integer>();
	
	public void adiciona(Produto produto, Integer quantidade) {
		produtos.put(produto, quantidade);
		totalCompra += (produto.getValor() * quantidade);
	}
	
	public void mostrarItens() {
		for (Map.Entry<Produto, Integer> item : produtos.entrySet()){
			System.out.print("Quantidade: " + item.getValue() + " - ");
			System.out.print(item.getKey().getTitulo() + ": " + item.getKey().getValor());
			System.out.println();
		}
	}
	
	public double getTotalCompra() {
		return totalCompra;
	}
}
