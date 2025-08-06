import java.sql.Statement;
import java.sql.Connection;

public class TestaExclusao {
    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.getConnection();
        
        Statement stmt = connection.createStatement();
        stmt.execute("DELETE FROM produto WHERE id = 2");

        int linhasAfetadas = stmt.getUpdateCount();

        System.out.println("Linhas afetadas: " + linhasAfetadas);

        connection.close();
    }
}
