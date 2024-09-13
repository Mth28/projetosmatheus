package Produtos;
import java.sql.*;
import java.time.LocalDateTime;

public class VendaDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String USER = "root"; // 
    private static final String PASSWORD = "Aluno"; 
    private static final String DATABASE = "mlanches";

    // Obtém uma conexão com o banco de dados
    static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL + DATABASE, USER, PASSWORD);
    }

    // Configura o banco de dados e a tabela
    public static void setup() {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {

            // Cria o banco de dados se não existir
            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS " + DATABASE);
            stmt.executeUpdate("USE " + DATABASE);

            // Cria a tabela de vendas se não existir
            String createTableSQL = "CREATE TABLE IF NOT EXISTS vendas ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY, "
                    + "nome_cliente VARCHAR(100), "
                    + "telefone VARCHAR(20), "
                    + "endereco VARCHAR(255), "
                    + "valor_pedido DECIMAL(10, 2), "
                    + "nota_fiscal TEXT, "
                    + "data_hora DATETIME default current_timestamp)"; 
             
            stmt.executeUpdate(createTableSQL);

            System.out.println("Banco de dados e tabela criados com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Adiciona uma nova venda
    public void adicionarVenda(Venda venda) throws SQLException {
        String sql = "INSERT INTO vendas (nome_cliente, telefone, endereco, valor_pedido, nota_fiscal) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, venda.getNomeCliente());
            stmt.setString(2, venda.getTelefone());
            stmt.setString(3, venda.getEndereco());
            stmt.setDouble(4, venda.getValorPedido());
            stmt.setString(5, venda.getNotaFiscal());
            stmt.executeUpdate();
        }
    }

    // Obtém uma venda pelo ID
    public Venda obterVendaPorId(int id) throws SQLException {
        String sql = "SELECT * FROM vendas WHERE id = ?";
        Venda venda = null;

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                venda = new Venda();
                venda.setId(rs.getInt("id"));
                venda.setNomeCliente(rs.getString("nome_cliente"));
                venda.setTelefone(rs.getString("telefone"));
                venda.setEndereco(rs.getString("endereco"));
                venda.setValorPedido(rs.getDouble("valor_pedido"));
                venda.setNotaFiscal(rs.getString("nota_fiscal"));
                venda.setDataHora(rs.getString("data_hora"));
            }
        }

        return venda;
    }

    // Atualiza uma venda existente
    public void atualizarVenda(Venda venda) throws SQLException {
        String sql = "UPDATE vendas SET nome_cliente = ?, telefone = ?, endereco = ?, valor_pedido = ?, nota_fiscal = ? WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, venda.getNomeCliente());
            stmt.setString(2, venda.getTelefone());
            stmt.setString(3, venda.getEndereco());
            stmt.setDouble(4, venda.getValorPedido());
            stmt.setString(5, venda.getNotaFiscal());
            stmt.setInt(6, venda.getId());

            stmt.executeUpdate();
        }
    }

    // Exclui uma venda pelo ID
    public void excluirVenda(int id) throws SQLException {
        String sql = "DELETE FROM vendas WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
   }
    public static void main(String[] args) {
		VendaDAO banco= new VendaDAO();
		banco.setup();
	}
}
