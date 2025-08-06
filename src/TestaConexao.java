import java.sql.Connection;

public class TestaConexao {
    public static void main(String[] args) throws Exception {
        System.out.println("Testa conexão com o DB!");

        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.getConnection();
        System.out.println("Conexão aberta com sucesso!");

        connection.close();
    }
}
