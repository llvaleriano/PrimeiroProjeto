package br.com.dissemine.livraria.produtos;

import org.junit.Assert;
import org.junit.Test;

import br.com.dissemine.livraria.dominio.Autor;
import br.com.dissemine.livraria.dominio.LivrariaException;
import br.com.dissemine.livraria.dominio.produtos.Livro;
import br.com.dissemine.livraria.dominio.produtos.LivroImpresso;

public class LivroTest {

	@Test
	public void criaLivroComAutor() {
		Autor autor = new Autor();
		autor.setNome("Fulano");
		autor.setEmail("fulano@gmail.com");
		
		Livro livro = new LivroImpresso(autor, "Livro Impresso");
		
		Assert.assertNotNull(livro);
		Assert.assertEquals(autor, livro.getAutores().iterator().next());
	}
	
	@Test (expected = LivrariaException.class)
	public void criarLivroSemAutorDeveLancarExcecao() {
		new LivroImpresso(null, "LivroImpresso");
	}
}
