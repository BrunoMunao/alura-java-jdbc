import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestaListagem {

    public static void main(String[] args) throws Exception {        
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.getConnection();

        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM produto");
        stmt.execute();

        ResultSet rs = stmt.getResultSet();

        while (rs.next()) {
            System.out.println("ID: " + rs.getInt("id"));
            System.out.println("Nome: " + rs.getString("nome"));
            System.out.println("Descrição: " + rs.getString("descricao"));
            System.out.println("---------------------------");
        }        

        connection.close();
    }
}

