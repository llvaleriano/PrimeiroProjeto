package br.com.dissemine.livraria.dominio.produtos;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import br.com.dissemine.livraria.dominio.Autor;

@Entity
@DiscriminatorValue(value="impresso")
public class LivroImpresso extends Livro {

	private Double peso;
	private Double altura;
	private Double largura;
	
	public LivroImpresso() {
		super();
	}
	
	public LivroImpresso(Autor autor, String titulo) {
		super(autor, titulo);
	}
	
	@Override
	public boolean concederDesconto(double percentualDesconto) {
		if (percentualDesconto < 0.3) {
			//valor = valor - (valor * percentualDesconto);
			valor -= valor * percentualDesconto;
			System.out.println("Valor com desconto - Impresso: " + valor);
			return true;
		}
		return false;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Double getLargura() {
		return largura;
	}

	public void setLargura(Double largura) {
		this.largura = largura;
	}
}
