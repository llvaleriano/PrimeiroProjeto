package br.com.dissemine.livraria.web;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.Part;

import br.com.dissemine.livraria.dominio.Autor;
import br.com.dissemine.livraria.dominio.produtos.LivroImpresso;
import br.com.dissemine.livraria.infraestrutura.JPAUtil;

@ManagedBean
public class LivroImpressoBean {
	private static final String DIRETORIO_UPLOAD = "C:/JavaBasis/tools/tomcat/webapps/uploads"; 

	private LivroImpresso livroImpresso = new LivroImpresso();
	private Autor autor;
	private Part imagemCapa;
	
	public void salvar() {
		String urlImagemCapa = salvarImagemUpload();
		livroImpresso.setUrlImagemCapa(urlImagemCapa);
		livroImpresso.adicionarAutor(autor);
		EntityManager em = JPAUtil.getEntityManager();
		em.merge(livroImpresso);
		livroImpresso = new LivroImpresso();
		FacesMessage msg = new FacesMessage("Livro impresso cadastrado com sucesso");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	private String salvarImagemUpload() {
		InputStream is;
		try {
			is = imagemCapa.getInputStream();
			Path temporario = Files.createTempFile(Paths.get(DIRETORIO_UPLOAD), 
				"livroimpresso-", ".jpg");
			Files.copy(is, temporario, StandardCopyOption.REPLACE_EXISTING);
			is.close();
			return "/uploads/" + temporario.getFileName().toString();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return null;
	}
	
	public LivroImpresso getLivroImpresso() {
		return livroImpresso;
	}
	public void setLivroImpresso(LivroImpresso livroImpresso) {
		this.livroImpresso = livroImpresso;
	}
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	public Part getImagemCapa() {
		return imagemCapa;
	}
	public void setImagemCapa(Part imagemCapa) {
		this.imagemCapa = imagemCapa;
	}
}
