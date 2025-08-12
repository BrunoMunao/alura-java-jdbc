package br.com.alura.jdbc.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.jdbc.dao.CategoriaDAO;
import br.com.alura.jdbc.factory.ConnectionFactory;
import br.com.alura.jdbc.modelo.Categoria;

public class CategoriaController {

	private CategoriaDAO categoriaDAO;
	private ConnectionFactory connectionFactory;

	public CategoriaController() {
		this.connectionFactory = new ConnectionFactory();
		this.categoriaDAO = new CategoriaDAO(connectionFactory.getConnection());
	}

	public List<Categoria> listar() {
		List<Categoria> categorias = new ArrayList<Categoria>();
		try {
			categorias = categoriaDAO.listar();
		} catch (SQLException e) {
			System.err.println("Erro ao listar categorias: " + e.getMessage());
			return categorias;
		}
		return categorias;
	}
}
