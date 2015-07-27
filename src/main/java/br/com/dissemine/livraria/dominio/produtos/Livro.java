package br.com.dissemine.livraria.dominio.produtos;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

import br.com.dissemine.livraria.dominio.Autor;
import br.com.dissemine.livraria.dominio.Editora;
import br.com.dissemine.livraria.dominio.LivrariaException;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tipoLivro", discriminatorType=DiscriminatorType.STRING)
@NamedQueries({
	@NamedQuery(name=Livro.LIVROS_EM_ESTOQUE, 
	query="select l from Livro l where l.quantidadeEmEstoque > 0"),
	@NamedQuery(name=Livro.LIVROS_EM_ESTOQUE_POR_TITULO, 
	query="select l from Livro l where l.quantidadeEmEstoque > 0 and " +
		  "UPPER(l.titulo) like :tituloLivro"),
	@NamedQuery(name=Livro.LIVROS_POR_AUTOR, 
	query="select l from Livro l join l.autores a where a.id = :idAutor")
	})
public abstract class Livro implements Produto, Promocional {
	
	public static final String LIVROS_EM_ESTOQUE = "livro.livrosDisponiveisEmEstoque";
	public static final String LIVROS_EM_ESTOQUE_POR_TITULO = "livro.livrosDisponiveisEmEstoquePorTitulo";
	public static final String LIVROS_POR_AUTOR = "livro.livrosPorAutor";
	
	@Id
	@SequenceGenerator(name="livroGenerator", sequenceName="livro_sequence")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="livroGenerator")
	protected Long id;
	protected String titulo;
	@ManyToOne(fetch=FetchType.LAZY)
	protected Editora editora;
	protected String descricao;
	protected Integer numeroPaginas;
	protected Double valor;
	protected String isbn;
	@ManyToMany
	@JoinTable (
		name="livro_autor",
		joinColumns = @JoinColumn(name="livro_id"),
		inverseJoinColumns = @JoinColumn(name="autor_id")
	)
	protected Set<Autor> autores = new HashSet<Autor>();
	protected Integer quantidadeEmEstoque;
	protected String urlImagemCapa;
	
	public Livro() {
	}
	
	public Livro(Autor autor, String titulo) {
		if (autor == null) {
			throw new LivrariaException("Autor não pode ser nulo");
		}
		this.titulo = titulo;
		autores.add(autor);
	}
	
	public Set<Autor> adicionarAutor(Autor autor) {
		autores.add(autor);
		return autores;
	}
	
	public void mostrarDetalhes() {
		System.out.println(titulo);
		editora.mostrarDetalhes();
		System.out.println(numeroPaginas + " páginas");
		System.out.println("R$" + valor);
		System.out.println(isbn);
	}
	
	@Override
	public int compareTo(Produto outro) {
		return this.getTitulo().compareTo(outro.getTitulo());
	}

	@Override
	public String toString() {
		return titulo;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autores == null) ? 0 : autores.hashCode());
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((editora == null) ? 0 : editora.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result
				+ ((numeroPaginas == null) ? 0 : numeroPaginas.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
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
		Livro other = (Livro) obj;
		if (autores == null) {
			if (other.autores != null)
				return false;
		} else if (!autores.equals(other.autores))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (editora == null) {
			if (other.editora != null)
				return false;
		} else if (!editora.equals(other.editora))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (numeroPaginas == null) {
			if (other.numeroPaginas != null)
				return false;
		} else if (!numeroPaginas.equals(other.numeroPaginas))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Set<Autor> getAutores() {
		return autores;
	}
	public void setAutores(Set<Autor> autores) {
		this.autores = autores;
	}
	public void setNumeroPaginas(Integer numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}
	public Editora getEditora() {
		return editora;
	}
	public void setEditora(Editora editora) {
		this.editora = editora;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		if (titulo.length() >= 3) {
			this.titulo = titulo;
		} else {
			System.out.println("Nome de livro invalido");
		}
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Integer getQuantidadeEmEstoque() {
		return quantidadeEmEstoque;
	}
	public void setQuantidadeEmEstoque(Integer quantidadeEmEstoque) {
		this.quantidadeEmEstoque = quantidadeEmEstoque;
	}
	public String getUrlImagemCapa() {
		return urlImagemCapa;
	}
	public void setUrlImagemCapa(String urlImagemCapa) {
		this.urlImagemCapa = urlImagemCapa;
	}
}
