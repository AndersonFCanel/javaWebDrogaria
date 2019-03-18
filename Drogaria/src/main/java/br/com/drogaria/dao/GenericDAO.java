package br.com.drogaria.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.drogaria.util.HibernateUtil;
/**
 * DAO Genérico
 * Camada DAO é um padrão de projeto onde os serviços de salvar, excluir, pesquisar ficam.
 * @author Anderson Canel
 * @version 1.00
 * @since Release 01 da aplicação
 */

//Observações:
//Como DAO's possuem métodos com funcionalidades parecidas, criaremos o GenericDAO.
//Tenta (try)configurar Session, salvar e commitar, caso ocorra algo de incorreto, ele da o rollback.
//O throw erro, serve para repropagar para as camadas superiores ;
//NUNCA esquecer de encerra a sessão com "finally {sessao.close()}";


public class GenericDAO<Entidade> {
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
