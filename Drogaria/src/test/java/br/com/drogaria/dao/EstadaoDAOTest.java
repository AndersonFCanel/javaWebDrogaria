package br.com.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.domain.Estado;

public class EstadaoDAOTest {
	@Test
	@Ignore
	public void salvar() {
		Estado estado = new Estado();
		estado.setNome("Rio Grande do Sul");
		estado.setSigla("RS");

		EstadoDAO estadoDAO = new EstadoDAO();
		estadoDAO.salvar(estado);
	}

	@Test
	public void listar() {
		EstadoDAO estadoDAO = new EstadoDAO();
		List<Estado> resultado = estadoDAO.listar();

		System.out.println("\nTotal de Registros Encontrados: " + resultado.size());
		System.out.println("LISTA DE RESULTADOS: ");
		for (Estado estado : resultado) {
			System.out.println(estado.getCodigo() + " - " + estado.getSigla() + " - " + estado.getNome());
		}
		System.out.println("\n");
	}

	@Test
	public void buscar() {
		Long codigo = 2L;

		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);

		if (estado == null) {
			System.out.println("Nenhum estado encontrado. ");
		} else {
			System.out.println("LISTA DE RESULTADOS: ");
			System.out.println(estado.getCodigo() + " - " + estado.getSigla() + " - " + estado.getNome());
			System.out.println("\n");
		}
	}
}
