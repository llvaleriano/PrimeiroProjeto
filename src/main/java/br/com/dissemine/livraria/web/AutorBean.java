package br.com.dissemine.livraria.web;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.dissemine.livraria.dominio.Autor;
import br.com.dissemine.livraria.infraestrutura.JPAUtil;

@ManagedBean
@ViewScoped
public class AutorBean {
	
	private Autor autor = new Autor();
	private List<Autor> autores;
	
	private Integer paginaAtual;
	private Integer tamanhoPagina = 2;
	private Integer totalPaginas;
	private Long totalRegistros;
	
	private EntityManager em = JPAUtil.getEntityManager();
	
	@PostConstruct
	public void carregaAutor() {
		Map<String, String> parametros = FacesContext.getCurrentInstance().
				getExternalContext().getRequestParameterMap();
		String parametroId = parametros.get("id");
		if (parametroId != null) {
			autor = em.find(Autor.class, Long.valueOf(parametroId));
		}
	}
	
	public String salvar() {
		if (autor.getId() == null) {
			em.persist(autor);
		} else {
			em.merge(autor);
		}
		return "listaAutores.xhtml?faces-redirect=true";
	}
	
	public List<Autor> getAutores() {
		if (autores == null) {
			paginaAtual = paginaAtual == null ? 1 : paginaAtual;
			calculaTotalRegistros();
			EntityManager em = JPAUtil.getEntityManager();
			TypedQuery<Autor> query = em.createQuery("select a from Autor a", Autor.class);
			query.setMaxResults(tamanhoPagina);
			query.setFirstResult((paginaAtual - 1) * tamanhoPagina);
			autores = query.getResultList();
		}
		return autores;
	}
	
	private void calculaTotalRegistros() {
		EntityManager em = JPAUtil.getEntityManager();
		TypedQuery<Long> query = em.createQuery("select count(a.id) from Autor a", Long.class);
		totalRegistros = query.getSingleResult();
		double totalPaginas = (double)totalRegistros / (double)tamanhoPagina;
		this.totalPaginas = (int) Math.round(totalPaginas);
	}
	
	public void primeiraPagina() {
		this.paginaAtual = 1;
		autores = null;
	}
	
	public void proximaPagina() {
		if (paginaAtual < totalPaginas) {
			++this.paginaAtual;
		}
		autores = null;
	}
	
	public void paginaAnterior() {
		if (this.paginaAtual > 1) {
			--this.paginaAtual;
		}
		autores = null;
	}
	
	public void ultimaPagina() {
		this.paginaAtual = totalPaginas;
		autores = null;
	}
	
	public void excluir(Autor autor) {
		Autor autorGerenciado = em.merge(autor);
		em.remove(autorGerenciado);
		autores = null;
	}

	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Integer getPaginaAtual() {
		return paginaAtual;
	}

	public Integer getTotalPaginas() {
		return totalPaginas;
	}

	public Long getTotalRegistros() {
		return totalRegistros;
	}
	
}
