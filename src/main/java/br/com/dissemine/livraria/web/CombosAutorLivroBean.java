package br.com.dissemine.livraria.web;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.dissemine.livraria.dominio.Autor;
import br.com.dissemine.livraria.dominio.produtos.Livro;
import br.com.dissemine.livraria.infraestrutura.JPAUtil;

@ManagedBean
@ViewScoped
public class CombosAutorLivroBean {

	private Autor autor;
	private Livro livro;
	private List<Livro> livros;
	
	@SuppressWarnings("unchecked")
	public void carregarLivros() {
		if (autor != null) {
			EntityManager em = JPAUtil.getEntityManager();
			Query query = em.createNamedQuery(Livro.LIVROS_POR_AUTOR, Livro.class);
			query.setParameter("idAutor", autor.getId());
			livros = query.getResultList();
		}
	}
	
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	public List<Livro> getLivros() {
		carregarLivros();
		return livros;
	}
	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
}
