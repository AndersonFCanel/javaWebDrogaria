package br.com.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.domain.Fabricante;

//Observações:
//@Ignores serve para ignorar o método anotado!
public class FabricanteDAOTest {
	@Test
	@Ignore
	public void salvar(){
		Fabricante fabricante = new Fabricante();
		fabricante.setDescricao("Aché");
		
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		fabricanteDAO.salvar(fabricante);
	}
	
	@Test
	public void listar() {
		FabricanteDAO FabricanteDAO = new FabricanteDAO();
		List<Fabricante> resultado = FabricanteDAO.listar();

		System.out.println("\nTotal de Registros Encontrados: " + resultado.size());
		System.out.println("LISTA DE RESULTADOS: ");
		for (Fabricante fabricante : resultado) {
			System.out.println(fabricante.getCodigo() + " - " + fabricante.getDescricao());
		}
		System.out.println("\n");
	}
	
}
