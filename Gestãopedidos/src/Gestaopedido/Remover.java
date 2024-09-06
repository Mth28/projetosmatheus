package Gestaopedido;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;

public class Remover extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldId;

    // Instance of GestorPedidos for managing pedidos
    private GestorPedidos gestorPedidos;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Remover frame = new Remover();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public Remover() {
        gestorPedidos = new GestorPedidos(); // Initialize GestorPedidos

        setTitle("Remover Pedido");
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

        JButton btnRemover = new JButton("Remover");
        btnRemover.setBounds(120, 70, 100, 23);
        contentPane.add(btnRemover);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(230, 70, 100, 23);
        contentPane.add(btnCancelar);

        // Action for the "Remover" button
        btnRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removerPedido();
            }
        });

        // Action for the "Cancelar" button
        btnCancelar.addActionListener(e -> {
            // Clear field when Cancel button is clicked
            textFieldId.setText("");
        });
    }

    private void removerPedido() {
        String id = textFieldId.getText();

        if (id.isEmpty()) {
            // Show an error message if the ID field is empty
            JOptionPane.showMessageDialog(this, "O campo ID deve ser preenchido.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            boolean sucesso = gestorPedidos.removerPedido(id);
            if (sucesso) {
                JOptionPane.showMessageDialog(this, "Pedido removido com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Pedido não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
            textFieldId.setText(""); // Clear the field after operation
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao remover o pedido: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
