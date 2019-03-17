package br.com.drogaria.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Classe para entidade estado.
 * 
 * @author Anderson Canel
 * @version 1.00
 * @since Release 01 da aplicação
 */

//Observações:
//@Entity diz que é uma entidade gerenciada pelo hibernate e é uma tabela;
//Cuidado com os imports.
//@Column diz pro hibernate que o atributo é uma coluna; 

@SuppressWarnings("serial")
@Entity
public class Estado extends GenericDomain {
	@Column(length = 2, nullable = false)
	private String sigla;
	
	@Column(length = 50, nullable = false)
	private String nome;

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
