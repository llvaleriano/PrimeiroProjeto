package br.com.dissemine.livraria.dominio.produtos;

public interface Produto extends Comparable<Produto>{

	Double getValor();
	String getTitulo();
	
}