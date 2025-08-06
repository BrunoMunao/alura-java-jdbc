import java.sql.Connection;
import java.sql.PreparedStatement;

public class TestaExclusao {
    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.getConnection();
        
        PreparedStatement stmt = connection.prepareStatement("DELETE FROM produto WHERE id > ?");
        stmt.setInt(1, 2); 
        
        stmt.execute();

        int linhasAfetadas = stmt.getUpdateCount();
        System.out.println("Linhas afetadas: " + linhasAfetadas);

        connection.close();
    }
}
