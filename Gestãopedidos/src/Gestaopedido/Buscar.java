package Gestaopedido;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;

public class Buscar extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldId;
    private JTextArea textAreaDetalhes;

    // Instance of GestorPedidos for managing pedidos
    private GestorPedidos gestorPedidos;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Buscar frame = new Buscar();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public Buscar() {
        gestorPedidos = new GestorPedidos(); // Initialize GestorPedidos

        setTitle("Buscar Pedido");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblId = new JLabel("ID do Pedido:");
        lblId.setBounds(10, 30, 100, 14);
        contentPane.add(lblId);

        textFieldId = new JTextField();
        textFieldId.setBounds(120, 27, 200, 20);
        contentPane.add(textFieldId);
        textFieldId.setColumns(10);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(120, 70, 100, 23);
        contentPane.add(btnBuscar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(230, 70, 100, 23);
        contentPane.add(btnCancelar);

        textAreaDetalhes = new JTextArea();
        textAreaDetalhes.setBounds(10, 110, 400, 140);
        textAreaDetalhes.setEditable(false);
        contentPane.add(textAreaDetalhes);

        // Action for the "Buscar" button
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarPedido();
            }
        });

        // Action for the "Cancelar" button
        btnCancelar.addActionListener(e -> {
            // Clear fields when Cancel button is clicked
            textFieldId.setText("");
            textAreaDetalhes.setText("");
        });
    }

    private void buscarPedido() {
        String id = textFieldId.getText();

        if (id.isEmpty()) {
            // Show an error message if the ID field is empty
            JOptionPane.showMessageDialog(this, "O campo ID deve ser preenchido.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Pedido pedido = gestorPedidos.buscarPedidoPorId(id);

        if (pedido != null) {
            // Display the details of the found pedido
            StringBuilder detalhes = new StringBuilder();
            detalhes.append("ID: ").append(pedido.getId()).append("\n");
            detalhes.append("Produtos: ").append(String.join(", ", pedido.getProdutos())).append("\n");
            detalhes.append("Status: ").append(pedido.getStatus()).append("\n");
            textAreaDetalhes.setText(detalhes.toString());
        } else {
            // Show an error message if the pedido is not found
            JOptionPane.showMessageDialog(this, "Pedido não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
            textAreaDetalhes.setText("");
        }
    }
}
