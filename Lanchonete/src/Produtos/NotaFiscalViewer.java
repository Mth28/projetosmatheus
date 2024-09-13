package Produtos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class NotaFiscalViewer extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTable table;
    private DefaultTableModel tableModel;

    public NotaFiscalViewer() {
        setTitle("Visualizador de Notas Fiscais");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        tableModel = new DefaultTableModel(new Object[]{"ID", "Nome Cliente", "Telefone", "Endereço", "Valor Pedido", "Nota Fiscal", "Data/Hora"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        JButton refreshButton = new JButton("Atualizar");
        refreshButton.addActionListener(e -> loadVendas());
        add(refreshButton, BorderLayout.SOUTH);

        JButton showNotaButton = new JButton("Mostrar Nota Fiscal");
        showNotaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showNotaFiscal();
            }
        });
        add(showNotaButton, BorderLayout.NORTH);

        loadVendas();
    }

    private void loadVendas() {
        tableModel.setRowCount(0);

        String query = "SELECT * FROM vendas";
        try (Connection conn = VendaDAO.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nomeCliente = rs.getString("nome_cliente");
                String telefone = rs.getString("telefone");
                String endereco = rs.getString("endereco");
                double valorPedido = rs.getDouble("valor_pedido");
                String notaFiscal = rs.getString("nota_fiscal");
                String dataHora = rs.getString("data_hora");

                tableModel.addRow(new Object[]{id, nomeCliente, telefone, endereco, valorPedido, notaFiscal, dataHora});
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao carregar dados das vendas.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void showNotaFiscal() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            int id = (Integer) table.getValueAt(selectedRow, 0);
            Venda venda = getVendaById(id);
            if (venda != null) {
                NotaFiscalDialog dialog = new NotaFiscalDialog(this, venda);
                dialog.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Venda não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma venda na tabela.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private Venda getVendaById(int id) {
        String query = "SELECT * FROM vendas WHERE id = ?";
        try (Connection conn = VendaDAO.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Venda venda = new Venda();
                venda.setId(rs.getInt("id"));
                venda.setNomeCliente(rs.getString("nome_cliente"));
                venda.setTelefone(rs.getString("telefone"));
                venda.setEndereco(rs.getString("endereco"));
                venda.setValorPedido(rs.getDouble("valor_pedido"));
                venda.setNotaFiscal(rs.getString("nota_fiscal"));
                venda.setDataHora(rs.getString("data_hora"));
                return venda;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao buscar venda.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            NotaFiscalViewer viewer = new NotaFiscalViewer();
            viewer.setVisible(true);
        });
    }
}

