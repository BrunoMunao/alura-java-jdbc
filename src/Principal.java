import java.sql.Connection;
import dao.ProdutoDAO;
import factory.ConnectionFactory;
import modelos.Produto;

public class Principal {

    public static void main(String[] args) {
        System.out.println("Inserindo produtos!");
                
        try (Connection connection = new ConnectionFactory().getConnection()) {
            ProdutoDAO produtoDAO = new ProdutoDAO(connection);

            Produto produto1 = new Produto("Mouse2", "Mouse sem fio");
            Produto produto2 = new Produto("Teclado2", "Teclado Mecânico");
            
            produtoDAO.salvarProduto(produto1);
            produtoDAO.salvarProduto(produto2);

            produtoDAO.listarProdutos();
        } catch (Exception e) {
            System.err.println("Erro ao abrir conexão: " + e.getMessage());
            return;
        }
        

    }
}
