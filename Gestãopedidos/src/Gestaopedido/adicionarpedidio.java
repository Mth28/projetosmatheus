package Gestaopedido;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class adicionarpedidio extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldId;
    private JTextField textFieldProduto;
    private JComboBox<String> comboBoxStatus;
    private JTextArea textAreaProdutos;

    // Instance of GestorPedidos for managing pedidos
    private GestorPedidos gestorPedidos;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                adicionarpedidio frame = new adicionarpedidio();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public adicionarpedidio() {
        gestorPedidos = new GestorPedidos(); // Initialize GestorPedidos

        setTitle("Adicionar Pedido");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblId = new JLabel("ID:");
        lblId.setBounds(10, 30, 80, 14);
        contentPane.add(lblId);

        JLabel lblProduto = new JLabel("Produto:");
        lblProduto.setBounds(10, 60, 80, 14);
        contentPane.add(lblProduto);

        JLabel lblStatus = new JLabel("Status:");
        lblStatus.setBounds(10, 90, 80, 14);
        contentPane.add(lblStatus);

        JLabel lblProdutos = new JLabel("Produtos (um por linha):");
        lblProdutos.setBounds(10, 120, 150, 14);
        contentPane.add(lblProdutos);

        textFieldId = new JTextField();
        textFieldId.setBounds(100, 27, 150, 20);
        contentPane.add(textFieldId);
        textFieldId.setColumns(10);

        textFieldProduto = new JTextField();
        textFieldProduto.setBounds(100, 57, 150, 20);
        contentPane.add(textFieldProduto);
        textFieldProduto.setColumns(10);

        comboBoxStatus = new JComboBox<>(new String[] {"Pendente", "Processando", "Enviado", "Entregue"});
        comboBoxStatus.setBounds(100, 87, 150, 20);
        contentPane.add(comboBoxStatus);

        textAreaProdutos = new JTextArea();
        textAreaProdutos.setBounds(10, 140, 550, 150);
        JScrollPane scrollPane = new JScrollPane(textAreaProdutos);
        scrollPane.setBounds(10, 140, 550, 150);
        contentPane.add(scrollPane);

        JButton btnAdicionar = new JButton("Adicionar");
        btnAdicionar.setBounds(80, 300, 100, 23);
        contentPane.add(btnAdicionar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(190, 300, 100, 23);
        contentPane.add(btnCancelar);

        JButton btnMostrarPedidos = new JButton("Mostrar Pedidos");
        btnMostrarPedidos.setBounds(300, 300, 150, 23);
        contentPane.add(btnMostrarPedidos);

        // Action for the "Adicionar" button
        btnAdicionar.addActionListener(e -> adicionarPedido());

        // Action for the "Cancelar" button
        btnCancelar.addActionListener(e -> limparCampos());

        // Action for the "Mostrar Pedidos" button
        btnMostrarPedidos.addActionListener(e -> mostrarPedidos());
    }

    private void adicionarPedido() {
        String id = textFieldId.getText();
        String status = (String) comboBoxStatus.getSelectedItem();

        if (id.isEmpty() || status.isEmpty()) {
            // Show an error message if any field is empty
            JOptionPane.showMessageDialog(this, "Todos os campos devem ser preenchidos.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Create a list of products from the text area
        List<String> produtos = new ArrayList<>();
        String[] linhas = textAreaProdutos.getText().split("\n");
        Collections.addAll(produtos, linhas);

        // Create and add the Pedido to GestorPedidos
        Pedido pedido = new Pedido(id, produtos, status);
        try {
            gestorPedidos.criarPedido(pedido);
            JOptionPane.showMessageDialog(this, "Pedido adicionado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            limparCampos();
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limparCampos() {
        textFieldId.setText("");
        textFieldProduto.setText("");
        comboBoxStatus.setSelectedIndex(0);
        textAreaProdutos.setText("");
    }

    private void mostrarPedidos() {
        // Get all pedidos and show them
        StringBuilder sb = new StringBuilder();
        for (Pedido pedido : gestorPedidos.getPedidos()) {
            sb.append(pedido).append("\n");
        }
        JOptionPane.showMessageDialog(this, sb.toString(), "Pedidos", JOptionPane.INFORMATION_MESSAGE);
    }
}

