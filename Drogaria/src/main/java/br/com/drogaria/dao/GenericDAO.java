package br.com.drogaria.dao;

import java.lang.reflect.ParameterizedType;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.drogaria.util.HibernateUtil;
/**
 * DAO Genérico
 * Camada DAO é um padrão de projeto onde os serviços de salvar, excluir, pesquisar ficam.
 * Como DAO's possuem métodos com funcionalidades parecidas, foi utilizado o GenericDAO.
 * O throw erro, serve para repropagar para as camadas s uperiores ;
 * Independentemente de ocorrer erro ou tudo funcionar perfeitamente a sessão deve ser fechada "finally {sessao.close()}".
 * 
 * @author Anderson Canel
 * @version 1.00
 * @since Release 01 da aplicação
 */ 

//Observações:
//Tenta (try)configurar Session, salvar e commitar, caso ocorra algo de incorreto, ele da o rollback.



public class GenericDAO<Entidade> {
	
	private Class<Entidade> classe;
	
	/**Contrutor usan API Reflection para pegar o tipo de Entidade em runtime.
	 * O tipo Entidade somente será checkado em runtime.
	 * @author Anderson  Ferreira Canel
	 * @param entidade
	 * @exception RuntimeException
	 * @return void
	 */
	@SuppressWarnings("unchecked")
	public GenericDAO(){
		this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	
	/**Método para salvar informações no banco de dados.
	 * É aberta uma sessão e então ocorre a tentativa de salvar o objeto genérico.
	 * @author Anderson  Ferreira Canel
	 * @param entidade
	 * @exception RuntimeException
	 * @return void
	 */
	public void salvar(Entidade entidade) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao  = null;
 
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
}
