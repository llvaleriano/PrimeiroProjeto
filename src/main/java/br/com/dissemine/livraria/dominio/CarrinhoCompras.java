package br.com.dissemine.livraria.dominio;

import java.util.HashMap;
import java.util.Map;

import br.com.dissemine.livraria.dominio.produtos.Produto;

public class CarrinhoCompras {
	
	private double totalCompra=0;
	private Map<Produto, Integer> prod = new HashMap<Produto, Integer>();
	
	//private List<Produto> produtos = new ArrayList<Produto>();
	
	public void adiciona(Produto produto, Integer quantidade) {
		prod.put(produto, quantidade);
	}
	
//	public void adiciona(Produto produto) {
//		produtos.add(produto);
//		totalCompra += produto.getValor();
//	}

	public void mostrarItens() {
		for (Map.Entry<Produto, Integer> item : prod.entrySet()){
			System.out.print(item.getValue());
			System.out.print(item.getKey().getTitulo() + ": " + item.getKey().getValor());
		}
		
	}
	
//	public void mostrarItens() {
//		Collections.sort(produtos);
//		for (Produto item:produtos) {
//			System.out.println(item.getTitulo() + ": " + item.getValor());
//		}
//	}

	public double getTotalCompra() {
		return totalCompra;
	}
}
