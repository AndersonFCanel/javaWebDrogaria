package br.com.drogaria.dao;

import org.junit.Test;

import br.com.drogaria.domain.Cidade;
import br.com.drogaria.domain.Estado;

public class CidadeDAOTest {
	@Test
	public void salvar() {
		EstadoDAO estadoDAO = new EstadoDAO();

		// No caso de trabalhar com FK, essa deve ser buscada, para que se passe um
		// objeto estado em cidade.setEstado(estado);
		Estado estado = estadoDAO.buscar(1L);

		Cidade cidade = new Cidade();
		cidade.setNome("Marília");
		cidade.setEstado(estado);

		CidadeDAO cidadeDAO = new CidadeDAO();
		cidadeDAO.salvar(cidade);
	}
}
