package br.com.alura.jdbc.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.jdbc.dao.ProdutoDAO;
import br.com.alura.jdbc.factory.ConnectionFactory;
import br.com.alura.jdbc.modelo.Produto;

public class ProdutoController {

	private Connection connection;
	private ProdutoDAO produtoDAO;

	public ProdutoController() {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		this.connection = connectionFactory.getConnection();
		this.produtoDAO = new ProdutoDAO(connection);
	}

	public void deletar(Integer id) {
		try {
			if (id == null) {
				throw new IllegalArgumentException("ID não pode ser nulo");
			}			
			produtoDAO.deletar(id);
		} catch (SQLException e) {
			System.err.println("Erro ao deletar produto: " + e.getMessage());
			return;
		}		
	}

	public void salvar(Produto produto) {
		try {
			if (produto.getNome() == null || produto.getDescricao() == null) {
				throw new IllegalArgumentException("Nome e Descrição devem ser informados");
			}
			produtoDAO.salvar(produto);
		} catch (SQLException e) {
			System.err.println("Erro ao salvar produto: " + e.getMessage());
			return;
		}
	}

	public List<Produto> listar() {
		List<Produto> produtos = new ArrayList<Produto>();
		try {
			produtos = produtoDAO.listar();
		} catch (SQLException e) {
			System.err.println("Erro ao listar produtos: " + e.getMessage());
			return produtos;
		}
		return produtos;
	}

	public void alterar(String nome, String descricao, Integer id) {
		try {
			if (id == null || nome == null || descricao == null) {
				throw new IllegalArgumentException("ID, Nome e Descrição devem ser informados");
			}
			Produto produto = new Produto(nome, descricao);
			produto.setId(id);
			produtoDAO.alterar(nome, descricao, id);
		} catch (SQLException e) {
			System.err.println("Erro ao alterar produto: " + e.getMessage());
			return;
		}
	}
}
