import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestaListagem {

    public static void main(String[] args) throws Exception {        
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.getConnection();

        Statement stmt = connection.createStatement();
        stmt.execute("SELECT * FROM produto");

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

