package br.com.dissemine.livraria.teste;

import br.com.dissemine.livraria.dominio.Autor;
import br.com.dissemine.livraria.dominio.Editora;
import br.com.dissemine.livraria.dominio.produtos.Livro;
import br.com.dissemine.livraria.dominio.produtos.LivroImpresso;

public class CadastroLivro {

	public static void main(String[] args) {
		Autor autor = new Autor();
		autor.setNome("Nietzsche");
		autor.setEmail("nietzsche@666.com");
		Livro livro = new LivroImpresso(autor, "Ecce homo");
		
		Editora editora = new Editora();
		editora.setNome("Sextante");
		editora.setUrl("www.sextante.com.br");
		editora.setEmail("contato@sextante.com.br");
		
		livro.setEditora(editora);
		livro.setNumeroPaginas(200);
		livro.setValor(59.90);
		livro.setIsbn("000-000-000");

		livro.mostrarDetalhes();

		boolean descontoConcedido = livro.concederDesconto(0.2);
		if (descontoConcedido) {
			System.out.println("Valor com desconto: " + livro.getValor());
		}
		
		Autor outroAutor = new Autor();
		outroAutor.setNome("Dan Brown");
		outroAutor.setEmail("dan@brown.com");
		
		Livro outroLivro = new LivroImpresso(outroAutor, "Fortaleza digital");
		outroLivro.setEditora(editora);
		outroLivro.setNumeroPaginas(300);
		outroLivro.setValor(49.70);
		outroLivro.setIsbn("000-111-000");

		outroLivro.mostrarDetalhes();
		descontoConcedido = outroLivro.concederDesconto(0.15);
		if (descontoConcedido) {
			System.out.println("Valor com desconto: " + outroLivro.getValor());
		}
		
	}
}
