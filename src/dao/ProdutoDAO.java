package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import modelos.Produto;

public class ProdutoDAO {

    private Connection connection;

    public ProdutoDAO(Connection connection) {
        this.connection = connection;
    }

    public void salvarProduto(Produto produto) {
        String sql = "INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.execute();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                while (rs.next()) {
                    produto.setId(rs.getInt(1));
                    System.out.println("ID do produto inserido: " + produto.getId());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listarProdutos() {
        String sql = "SELECT * FROM PRODUTO";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.execute();
            try (ResultSet rs = stmt.getResultSet()) {
                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id"));
                    System.out.println("Nome: " + rs.getString("nome"));
                    System.out.println("Descrição: " + rs.getString("descricao"));
                    System.out.println("---------------------------");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listarProdutosComCategorias() {
        String sql = "SELECT p.id, p.nome, p.descricao, c.descricao AS categoria_nome " +
                     "FROM produto p " +
                     "INNER JOIN categoria c ON p.categoria_id = c.id";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.execute();
            try (ResultSet rs = stmt.getResultSet()) {
                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id"));
                    System.out.println("Nome: " + rs.getString("nome"));
                    System.out.println("Descrição: " + rs.getString("descricao"));
                    System.out.println("Categoria: " + rs.getString("categoria_nome"));
                    System.out.println("---------------------------");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
