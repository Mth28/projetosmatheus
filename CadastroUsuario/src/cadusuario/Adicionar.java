package cadusuario;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Adicionar extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldNome;
    private JTextField textFieldEmail;
    private JPasswordField passwordFieldSenha;

    // Simulando um gestor de usuários
    private GestorUsuarios gestorUsuarios;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Adicionar frame = new Adicionar();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public Adicionar() {
        gestorUsuarios = new GestorUsuarios(); // Inicializa o gestor de usuários

        setTitle("Adicionar Usuário");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(10, 30, 80, 14);
        contentPane.add(lblNome);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(10, 60, 80, 14);
        contentPane.add(lblEmail);

        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setBounds(10, 90, 80, 14);
        contentPane.add(lblSenha);

        textFieldNome = new JTextField();
        textFieldNome.setBounds(100, 27, 150, 20);
        contentPane.add(textFieldNome);
        textFieldNome.setColumns(10);

        textFieldEmail = new JTextField();
        textFieldEmail.setBounds(100, 57, 150, 20);
        contentPane.add(textFieldEmail);
        textFieldEmail.setColumns(10);

        passwordFieldSenha = new JPasswordField();
        passwordFieldSenha.setBounds(100, 87, 150, 20);
        contentPane.add(passwordFieldSenha);

        JButton btnAdicionar = new JButton("Adicionar");
        btnAdicionar.setBounds(80, 130, 100, 23);
        contentPane.add(btnAdicionar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(190, 130, 100, 23);
        contentPane.add(btnCancelar);

        // Ação para o botão "Adicionar"
        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarUsuario();
            }
        });

        // Ação para o botão "Cancelar"
        btnCancelar.addActionListener(e -> {
            textFieldNome.setText("");
            textFieldEmail.setText("");
            passwordFieldSenha.setText("");
        });
    }

    private void adicionarUsuario() {
        String nome = textFieldNome.getText();
        String email = textFieldEmail.getText();
        String senha = new String(passwordFieldSenha.getPassword());

        if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos os campos devem ser preenchidos.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Usuario usuario = new Usuario(nome, email, senha);
        try {
            gestorUsuarios.adicionarUsuario(usuario);
            JOptionPane.showMessageDialog(this, "Usuário adicionado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            textFieldNome.setText("");
            textFieldEmail.setText("");
            passwordFieldSenha.setText("");
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
