package br.com.dissemine.livraria.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.dissemine.livraria.dominio.Autor;
import br.com.dissemine.livraria.infraestrutura.JPAUtil;

public class ListaAutor {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		Query query = em.createQuery("select a from Autor a", Autor.class);
		List<Autor> autores = query.getResultList();
		for (Autor autor:autores) {
			System.out.print(autor.getNome());
			System.out.println(" (" + autor.getEmail() + ")");
		}
		em.close();
	}
}
