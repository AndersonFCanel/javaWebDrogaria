package br.com.drogaria.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Classe para entidade cidade.
 * 
 * @author Anderson Canel
 * @version 1.00
 * @since Release 01 da aplicação
 */

//Observações:
//@Entity diz que é uma entidade gerenciada pelo hibernate e é uma tabela;
//Cuidado com os imports.
//@Column diz pro hibernate que o atributo é uma coluna; 
//Na modelagem a classe Cidade ficou definida com um relacionamento do tipo COMPOSIÇÃO com a classe Estado, ou seja, se um objeto do tipo estado deixa de existir, os objetos do tipo cidade relacionados a estado excluido também deixam de existir, relacionamento do tipo "tem um", sentdo
//A @nnotation @ManyToOne, "muitos para um", é responsável pela criação de FK, esse relacionamento diz: Um Estado pode ter muitas cidades e muitas Cidades podem ter um Estado.
//A @nnotation @JoinColumn serve para personalizar prorpiedades de colunas que são FK, em colunas normais se usa apenas @column

@SuppressWarnings("serial")
@Entity
public class Cidade extends GenericDomain {
	@Column(length = 50, nullable = false)
	private String nome;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Estado estado;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
}
