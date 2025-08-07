package testes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import factory.ConnectionFactory;

public class TestaInsercaoComParametros {

    public static void main(String[] args) throws Exception {
        System.out.println("Inserindo um produto!");

        ConnectionFactory factory = new ConnectionFactory();
        try (Connection connection = factory.getConnection()) {
            connection.setAutoCommit(false); 
            
            try (PreparedStatement stmt = connection.prepareStatement("INSERT INTO produto (nome, descricao) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS)) {
                adicionarVariavel("Mouse", "Mouse sem fio", stmt);
                adicionarVariavel("Teclado", "Teclado Mecânico", stmt);                
            } catch (Exception e) {
                e.printStackTrace();
                connection.rollback(); // Rollback em caso de erro
            } finally {
                connection.commit(); // Commit após todas as inserções
            }        
        }
    }

    private static void adicionarVariavel(String nome, String descricao, PreparedStatement stmt) {        
        try {
            stmt.setString(1, nome);
            stmt.setString(2, descricao);
            stmt.execute();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                while (rs.next()) {
                    System.out.println("ID do produto inserido: " + rs.getInt(1));
                }        
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

