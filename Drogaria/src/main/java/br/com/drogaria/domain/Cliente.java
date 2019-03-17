package br.com.drogaria.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Classe para entidade Cliente.
 * 
 * @author Anderson Canel
 * @version 1.00
 * @since Release 01 da aplicação
 */
//Observações:
//Observar no Import do date, Jabva.Util
//A @nnotation @Temporal diz ao hibernate que é uma data através do parâmmetro: TemporalType.DATE
//A @nnotation @OneToOne, uma  Pessoa só pode possuir um cadastro de cliente e um cliente só pode ser uma pessoa. A Composição ficado lado do cliente porque só se pode haver um cliente se existir uma pessoa.

@SuppressWarnings("serial")
@Entity
public class Cliente extends GenericDomain {
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataCadastro;
	
	/**Atributo para definir se o cliente tem compras a crédito liberada
	 * @author Anderson Ferreira Canel
	*/
	@Column(nullable = false)
	private Boolean liberado;
	
	@OneToOne
	@JoinColumn(nullable = false)
	private Pessoa pessoa;

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Boolean getLiberado() {
		return liberado;
	}

	public void setLiberado(Boolean liberado) {
		this.liberado = liberado;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
}
