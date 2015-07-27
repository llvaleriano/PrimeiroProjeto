package br.com.dissemine.livraria.web;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import br.com.dissemine.livraria.aplicacao.LivrariaFacade;
import br.com.dissemine.livraria.dominio.Editora;
import br.com.dissemine.livraria.infraestrutura.JPAUtil;

@ManagedBean
public class EditoraBean {
	
	private Editora editora = new Editora();
	private List<Editora> editoras;
	private EntityManager em = JPAUtil.getEntityManager();
	private LivrariaFacade livrariaFacade = new LivrariaFacade(); 
	
	@PostConstruct
	public void carregarEditora() {
		Map<String, String> parametros = FacesContext.getCurrentInstance().
				getExternalContext().getRequestParameterMap();
		String parametroId = parametros.get("id");
		if (parametroId != null) {
			editora = em.find(Editora.class, Long.valueOf(parametroId));
		}
	}
	
	public String salvar() {
		livrariaFacade.salvarEditora(editora);
		return "listaEditoras.xhtml?faces-redirect=true";
	}
	
	
	public List<Editora> getEditoras() {
		if (editoras == null) {
			editoras = livrariaFacade.listarEditoras();
		}
		return editoras;
	}

	public void excluir(Editora editora) {
		editora = em.merge(editora);
		em.remove(editora);
		editoras = null;
	}
	
	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}
}
