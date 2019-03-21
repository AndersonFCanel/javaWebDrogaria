package br.com.drogaria.dao;

import java.math.BigDecimal;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.domain.Produto;


//Observações:
//O detalhe esta em ser necessário criar o tipo em: produto.setPreco(new BigDecimal("13.70"));

public class ProdutoDAOTest {
	@Test
	@Ignore
	public void salvar(){
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(new Long("3"));
		//Pode ser desta forma também.
		//Fabricante fabricante = fabricanteDAO.buscar(3L);
		
		Produto produto = new Produto();
		produto.setDescricao("Cataflan 50mg com 20 Comprimidos");
		produto.setFabricante(fabricante);
		produto.setPreco(new BigDecimal("13.70"));
		produto.setQuantidade(new Short("7"));
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.salvar(produto);
		
		System.out.println("Produto salvo com sucesso");
	}
}
