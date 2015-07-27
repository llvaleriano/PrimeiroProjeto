package br.com.dissemine.livraria.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import br.com.dissemine.livraria.dominio.ItemCompra;
import br.com.dissemine.livraria.dominio.produtos.Livro;
import br.com.dissemine.livraria.infraestrutura.JPAUtil;

@ManagedBean
@SessionScoped
public class DetalheLivroBean {

	private Livro livro;
	private List<ItemCompra> itensCompra = new ArrayList<ItemCompra>();
	
	public void carregaLivro() {
		Map<String, String> parametros = FacesContext.getCurrentInstance().
				getExternalContext().getRequestParameterMap();
		String parametroId = parametros.get("id");
		if (parametroId != null) {
			EntityManager em = JPAUtil.getEntityManager();
			livro = em.find(Livro.class, Long.valueOf(parametroId));
		}
	}
	
	public void adicionarItemCompra() {
		ItemCompra itemCompra = new ItemCompra();
		Integer quantidade = 1;
		boolean jaCadastrado = false;
		
		for(ItemCompra ic : itensCompra) {
			if (ic.getLivro().equals(livro)) {
				itemCompra = ic;
				quantidade = 1+itemCompra.getQuantidade();
				jaCadastrado = true;
				break;
			}
		}

		itemCompra.setQuantidade(quantidade);
		itemCompra.setLivro(livro);
		if (!jaCadastrado) {
			itensCompra.add(itemCompra);
		}
	}

	public Livro getLivro() {
		carregaLivro();
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	public List<ItemCompra> getItensCompra() {
		return itensCompra;
	}
	public void setItensCompra(List<ItemCompra> itensCompra) {
		this.itensCompra = itensCompra;
	}
}
