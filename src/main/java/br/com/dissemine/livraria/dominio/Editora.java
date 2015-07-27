package br.com.dissemine.livraria.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Editora {

	@Id
	@SequenceGenerator(name="editoraGenerator", sequenceName="editoraSequence")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="editoraGenerator")
	private Long id;
	@Column(length=100)
	private String nome;
	@Column(length=100)
	private String url;
	@Column(length=100)
	private String email;
	
	public void mostrarDetalhes() {
		System.out.println(nome);
		System.out.println(url);
		System.out.println(email);
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
