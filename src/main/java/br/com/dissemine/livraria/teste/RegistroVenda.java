package br.com.dissemine.livraria.teste;

import br.com.dissemine.livraria.dominio.Autor;
import br.com.dissemine.livraria.dominio.CarrinhoMapa;
import br.com.dissemine.livraria.dominio.LivrariaException;
import br.com.dissemine.livraria.dominio.Revista;
import br.com.dissemine.livraria.dominio.produtos.Livro;
import br.com.dissemine.livraria.dominio.produtos.LivroDigital;
import br.com.dissemine.livraria.dominio.produtos.LivroImpresso;
import br.com.dissemine.livraria.dominio.produtos.MiniLivro;

public class RegistroVenda {

	public static void main(String[] args) {
		CarrinhoMapa carrinho = new CarrinhoMapa();
		
		Autor autor = new Autor();
		autor.setNome("Martin Fowler");
				
		try {
			Livro livroDigital = new LivroDigital(null, "Padrões de integração - Digital");
			livroDigital.setValor(Double.valueOf(100));
			carrinho.adiciona(livroDigital, 1);
		} catch (LivrariaException e) {
			System.out.println(e.getMessage());
		}
		Livro livroImpresso = new LivroImpresso(autor, "Padrãoes de integração - Impresso");
		livroImpresso.setValor(Double.valueOf(50));
		Livro miniLivro = new MiniLivro(autor, "Analysis Patterns");
		miniLivro.setValor(Double.valueOf(20));
		
		Revista revista = new Revista();
		revista.setTitulo("Java Magazine");
		revista.setValor(9.9);
		
		carrinho.adiciona(livroImpresso, 2);
		carrinho.adiciona(miniLivro, 3);
		carrinho.adiciona(revista, 4);
		
		carrinho.mostrarItens();
		
		System.out.println("Total da compra: " + carrinho.getTotalCompra());
	}
}
