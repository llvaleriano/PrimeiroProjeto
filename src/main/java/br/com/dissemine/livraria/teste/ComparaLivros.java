package br.com.dissemine.livraria.teste;

import br.com.dissemine.livraria.dominio.Autor;
import br.com.dissemine.livraria.dominio.produtos.Livro;
import br.com.dissemine.livraria.dominio.produtos.LivroDigital;
import br.com.dissemine.livraria.dominio.produtos.LivroImpresso;

public class ComparaLivros {

	public static void main(String[] args) {
		Autor autor = new Autor();
		autor.setNome("Martin Fowler");
		
		Livro a = new LivroImpresso(autor, "AAA");
		Livro b = new LivroImpresso(autor, "AAA");
		Livro c = new LivroDigital(autor, "AAA");
		
		System.out.println(a.equals(b));
		System.out.println(b.equals(a));
		System.out.println(b.equals(c));
	}
}
