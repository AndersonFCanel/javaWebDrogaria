package br.com.drogaria.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * Classe para entidade Usuário.
 * 
 * @author Anderson Canel
 * @version 1.00
 * @since Release 01 da aplicação
 */
//Observações:
//No campo Senha o formato usado será MD5, por esta razão o tamanho e length = 32.
//@JoinColumn(nullable = false) Não é possível existir Usuário sem ter uma Pessoa

@SuppressWarnings("serial")
@Entity
public class Usuario extends GenericDomain {
	@Column(length = 32, nullable = false)
	private String senha;
	
	@Column(nullable = false)
	private Character tipo;
	
	@Column(nullable = false)
	private Boolean ativo;
	
	@OneToOne
	@JoinColumn(nullable = false)
	private Pessoa pessoa;

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Character getTipo() {
		return tipo;
	}

	public void setTipo(Character tipo) {
		this.tipo = tipo;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
}
