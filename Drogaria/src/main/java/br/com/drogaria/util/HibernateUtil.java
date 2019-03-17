package br.com.drogaria.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	private static SessionFactory fabricaDeSessoes = criarFabricaDeSessoes();

	public static SessionFactory getFabricaDeSessoes() {
		return fabricaDeSessoes;
	}

	/*
	 * Atenção aos imports!
	 * 
	 */
	private static SessionFactory criarFabricaDeSessoes() {
		try {

			/*
			 * A linha abaixo busca o arquivo hibernate.cfg.xml e retorna suas
			 * configurações.
			 */
			Configuration configuracao = new Configuration().configure();

			/* A linha abaixo aplica as conficurações. */
			ServiceRegistry registro = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties())
					.build();

			/* A linha abaixo utiliza o registro do serviço para criar a fábrica sessoes. */
			SessionFactory fabrica = configuracao.buildSessionFactory(registro);
			
			//Retorna fábrica de sessoões.
			return fabrica;
		} catch (Throwable ex) {
			System.err.println("A fábrica de sessões não pode ser criada." + ex);

			// throw garante que a aplicação será avisada sobre a ocorrência da exception.
			throw new ExceptionInInitializerError(ex);
		}
	}
}
