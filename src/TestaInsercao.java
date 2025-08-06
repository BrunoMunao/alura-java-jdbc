import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestaInsercao {

    public static void main(String[] args) throws Exception {
        System.out.println("Inserindo um produto!");

        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.getConnection();

        Statement stmt = connection.createStatement();
        stmt.execute("INSERT INTO produto (nome, descricao) VALUES ('Mouse', 'Mouse sem fio')", Statement.RETURN_GENERATED_KEYS);

        ResultSet rs = stmt.getGeneratedKeys();

        while (rs.next()) {
            System.out.println("ID do produto inserido: " + rs.getInt(1));
        }        

        connection.close();
    }
}

