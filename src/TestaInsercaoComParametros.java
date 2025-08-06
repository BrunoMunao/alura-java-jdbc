import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestaInsercaoComParametros {

    public static void main(String[] args) throws Exception {
        System.out.println("Inserindo um produto!");

        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.getConnection();

        PreparedStatement stmt = connection.prepareStatement("INSERT INTO produto (nome, descricao) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);        

        stmt.setString(1, "Teclado");
        stmt.setString(2, "Teclado mecânico");

        stmt.execute();

        ResultSet rs = stmt.getGeneratedKeys();

        while (rs.next()) {
            System.out.println("ID do produto inserido: " + rs.getInt(1));
        }        

        connection.close();
    }
}

