package br.com.dissemine.livraria.aplicacao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.dissemine.livraria.dominio.Editora;
import br.com.dissemine.livraria.infraestrutura.JPAUtil;

public class LivrariaFacade {

	private EntityManager em = JPAUtil.getEntityManager();
	
	@SuppressWarnings("unchecked")
	public List<Editora> listarEditoras() {
		Query query = em.createQuery("select e from Editora e", Editora.class);
		return query.getResultList();
	}
	
	public void salvarEditora(Editora editora) {
		em.merge(editora);
	}
}
