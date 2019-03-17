package br.com.drogaria.domain;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * POJO domain.
 * 
 * @author Anderson Canel
 * @version 1.00
 * @since Release 01 da aplicação
 */

//Observações:
//Chamamos serializable, pois os frameworks costumam serializar os objetos.
//A @nnotation MappedSuperClass diz que essa classe não corresponde a uma tabela, porém será utilizada por outras que são tabelas(Herança).
//@SuppressWarnings anotação própria do JAVA para suprimir Warning

@SuppressWarnings("serial")
@MappedSuperclass
public class GenericDomain implements Serializable {

	// @Id, annotation hibernate para identificar uma PK
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codigo;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
}
