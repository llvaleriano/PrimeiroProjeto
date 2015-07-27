package br.com.dissemine.livraria.web;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.dissemine.livraria.dominio.produtos.Livro;
import br.com.dissemine.livraria.infraestrutura.JPAUtil;

@ManagedBean
@ViewScoped
public class ListagemLivrosBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<Livro> livros;
	private String titulo = "";
	private String ultimoTituloPesquisado = "";

	@SuppressWarnings("unchecked")
	public void carregarLivros() {
		EntityManager em = JPAUtil.getEntityManager();
		Query query = em.createNamedQuery(Livro.LIVROS_EM_ESTOQUE_POR_TITULO, Livro.class);
		query.setParameter("tituloLivro", "%" + titulo.toUpperCase() + "%");
		livros = query.getResultList();
		ultimoTituloPesquisado = titulo;
	}
	
	public List<Livro> getLivros() {
		if (! ultimoTituloPesquisado.equals(titulo)) {
			carregarLivros();
		}
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}
