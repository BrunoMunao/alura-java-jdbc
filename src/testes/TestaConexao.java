package testes;
import java.sql.Connection;
import factory.ConnectionFactory;

public class TestaConexao {
    public static void main(String[] args) throws Exception {
        System.out.println("Testa conexão com o DB!");
        ConnectionFactory factory = new ConnectionFactory();

        for (int i = 0; i < 6; i++) {
            try (Connection connection = factory.getConnection()) {
                System.out.println("Conexão " + (i + 1) + " aberta com sucesso!");
            } catch (Exception e) {
                System.err.println("Erro ao abrir conexão " + (i + 1) + ": " + e.getMessage());
            }
        }
    }
}
