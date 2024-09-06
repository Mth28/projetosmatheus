package cadusuario;

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
    private JTextField textFieldEmail;
    private GestorUsuarios gestorUsuarios;

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
        gestorUsuarios = new GestorUsuarios(); // Inicialize GestorUsuarios

        setTitle("Remover Usuário");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(10, 30, 80, 14);
        contentPane.add(lblEmail);

        textFieldEmail = new JTextField();
        textFieldEmail.setBounds(100, 27, 250, 20);
        contentPane.add(textFieldEmail);
        textFieldEmail.setColumns(10);

        JButton btnRemover = new JButton("Remover");
        btnRemover.setBounds(80, 70, 100, 23);
        contentPane.add(btnRemover);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(190, 70, 100, 23);
        contentPane.add(btnCancelar);

        // Action for the "Remover" button
        btnRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removerUsuario();
            }
        });

        // Action for the "Cancelar" button
        btnCancelar.addActionListener(e -> {
            // Clear field when Cancel button is clicked
            textFieldEmail.setText("");
        });
    }

    private void removerUsuario() {
        String email = textFieldEmail.getText();

        if (email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "O campo de email não pode estar vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Usuario usuario = gestorUsuarios.buscarUsuarioPorEmail(email);
            if (usuario == null) {
                JOptionPane.showMessageDialog(this, "Usuário não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            // Assume que o método `removerUsuario` foi implementado
            gestorUsuarios.removerUsuario(email);
            JOptionPane.showMessageDialog(this, "Usuário removido com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            textFieldEmail.setText("");
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
