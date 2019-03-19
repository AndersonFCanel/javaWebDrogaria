package br.com.drogaria.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.drogaria.util.HibernateUtil;

/**
 * DAO Genérico Camada DAO é um padrão de projeto onde os serviços de salvar,
 * excluir, pesquisar ficam. Como DAO's possuem métodos com funcionalidades
 * parecidas, foi utilizado o GenericDAO. O throw erro, serve para repropagar
 * para as camadas s uperiores ; Independentemente de ocorrer erro ou tudo
 * funcionar perfeitamente a sessão deve ser fechada "finally {sessao.close()}".
 * 
 * @author Anderson Canel
 * @version 1.00
 * @since Release 01 da aplicação
 */

//Observações:
//Tenta (try)configurar Session, salvar e commitar, caso ocorra algo de incorreto, ele da o rollback.

public class GenericDAO<Entidade> {

	private Class<Entidade> classe;

	/**
	 * Contrutor usan API Reflection para pegar o tipo de Entidade em runtime. O
	 * tipo Entidade somente será checkado em runtime.
	 * 
	 * @author Anderson Ferreira Canel
	 * @exception RuntimeException
	 * @return void
	 */

	// Como estamos trabalhando com entidade suprimimos o Warning, pois o java
	// reclama por não saber o tipo.

	@SuppressWarnings("unchecked")
	public GenericDAO() {
		/// Explicando a linha abaixo
		// getClass() ==> Captura a classe, por exemplo: EstadoDAO
		// .getGenericSuperclass()) ==> Captura o supertipo genérico, por exempplo:
		/// extends GenericDAO<Estado>
		// .getActualTypeArguments()[0]; ==> Captura somente o Estado, por exemplo:
		/// <Estado>
		this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	/**
	 * Método para salvar informações no banco de dados. 
	 * É aberta uma sessão e então ocorre a tentativa de salvar o objeto genérico.
	 * @author Anderson Ferreira Canel
	 * @param entidade
	 * @exception RuntimeException
	 * @return void
	 */
	public void salvar(Entidade entidade) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(entidade);
			transacao.commit();
		} catch (RuntimeException erro) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw erro;
		} finally {
			sessao.close();
		}
	}

	/**
	 * Método para listar informações persistidas no banco de dados.
	 * Este método retornará uma lista de entidades.
	 * @author Anderson Ferreira Canel
	 * @param entidade
	 * @exception RuntimeException
	 * @return  List<Entidade>
	 */
	@SuppressWarnings("unchecked")
	public List<Entidade> listar() {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		try {
			// Explicando a linha abaixo:
			// Criteria n é o critério da consulta, nesse caso tratase da tabela inteira.
			Criteria consulta = sessao.createCriteria(classe);
			List<Entidade> resultado = consulta.list();
			return resultado;
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}

	}

	/**
	 * Método para buscar informações persistidas no banco de dados.
	 * Este método retornará uma única entidade. 
	 * @author Anderson Ferreira Canel
	 * @param entidade
	 * @exception RuntimeException
	 * @return Entidade
	 */
	@SuppressWarnings("unchecked")
	public Entidade buscar(Long codigo) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		try {
			// Explicando o TRECHO abaixo:
			// Criteria n é o critério da consulta, nesse caso tratase da tabela inteira.
			// A restrição de busca é pelo codigo informado . Restrictions.idEq(codigo).
			// Como quero um resultado unico usei: consulta.uniqueResult(), para muitos
			// usase lista.
			Criteria consulta = sessao.createCriteria(classe);
			consulta.add(Restrictions.idEq(codigo));
			Entidade resultado = (Entidade) consulta.uniqueResult();
			return resultado;
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
	}

	
	/**
	 * Método para excluir entidade persistida no banco de dados. 
	 * @author Anderson Ferreira Canel
	 * @param entidade
	 * @exception Runtime Exception
	 * @return void
	 */
	public void excluir(Entidade entidade) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();
			sessao.delete(entidade);
			transacao.commit();
		} catch (RuntimeException erro) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw erro;
		} finally {
			sessao.close();
		}
	}
}
