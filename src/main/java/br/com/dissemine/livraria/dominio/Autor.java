package br.com.dissemine.livraria.dominio;

import java.util.Collections;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import br.com.dissemine.livraria.dominio.produtos.Livro;

@Entity
public class Autor {
	
	@Id
	@SequenceGenerator(name="autorGenerator", sequenceName="autorSequence", initialValue=10)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="autorGenerator")
	private Long id;

	@Column(length=100, nullable=false)
	private String nome;
	
	@Column(length=100, nullable=false)
	private String email;
	
	@ManyToMany(mappedBy="autores")
	private Set<Livro> livros = Collections.emptySet();
	
	public Set<Livro> adicionarLivro(Livro livro) {
		livro.adicionarAutor(this);
		livros.add(livro);
		return livros;
	}
	
	public void mostrarDetalhes() {
		System.out.println(nome);

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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Set<Livro> getLivros() {
		return livros;
	}
	public void setLivros(Set<Livro> livros) {
		this.livros = livros;
	}

	@Override
	public String toString() {
		return "Autor: " + nome; 
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Autor outroAutor = (Autor) obj;
		if (email == null) {
			if (outroAutor.email != null)
				return false;
		} else if (!email.equals(outroAutor.email))
			return false;
		if (nome == null) {
			if (outroAutor.nome != null)
				return false;
		} else if (!nome.equals(outroAutor.nome))
			return false;
		return true;
	}
}
