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

public class Atualizar extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldEmailAntigo;
    private JTextField textFieldEmailNovo;
    private JTextField textFieldNomeNovo;
    private GestorUsuarios gestorUsuarios;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Atualizar frame = new Atualizar();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public Atualizar() {
        gestorUsuarios = new GestorUsuarios(); // Inicializa GestorUsuarios

        setTitle("Atualizar Usuário");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblEmailAntigo = new JLabel("Email Antigo:");
        lblEmailAntigo.setBounds(10, 30, 100, 14);
        contentPane.add(lblEmailAntigo);

        JLabel lblEmailNovo = new JLabel("Novo Email:");
        lblEmailNovo.setBounds(10, 70, 100, 14);
        contentPane.add(lblEmailNovo);

        JLabel lblNomeNovo = new JLabel("Novo Nome:");
        lblNomeNovo.setBounds(10, 110, 100, 14);
        contentPane.add(lblNomeNovo);

        textFieldEmailAntigo = new JTextField();
        textFieldEmailAntigo.setBounds(120, 27, 200, 20);
        contentPane.add(textFieldEmailAntigo);
        textFieldEmailAntigo.setColumns(10);

        textFieldEmailNovo = new JTextField();
        textFieldEmailNovo.setBounds(120, 67, 200, 20);
        contentPane.add(textFieldEmailNovo);
        textFieldEmailNovo.setColumns(10);

        textFieldNomeNovo = new JTextField();
        textFieldNomeNovo.setBounds(120, 107, 200, 20);
        contentPane.add(textFieldNomeNovo);
        textFieldNomeNovo.setColumns(10);

        JButton btnAtualizar = new JButton("Atualizar");
        btnAtualizar.setBounds(80, 150, 100, 23);
        contentPane.add(btnAtualizar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(190, 150, 100, 23);
        contentPane.add(btnCancelar);

        // Action for the "Atualizar" button
        btnAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarUsuario();
            }
        });

        // Action for the "Cancelar" button
        btnCancelar.addActionListener(e -> {
            // Clear fields when Cancel button is clicked
            textFieldEmailAntigo.setText("");
            textFieldEmailNovo.setText("");
            textFieldNomeNovo.setText("");
        });
    }

    private void atualizarUsuario() {
        String emailAntigo = textFieldEmailAntigo.getText();
        String emailNovo = textFieldEmailNovo.getText();
        String nomeNovo = textFieldNomeNovo.getText();

        if (emailAntigo.isEmpty() || emailNovo.isEmpty() || nomeNovo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos os campos devem ser preenchidos.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Usuario usuario = gestorUsuarios.buscarUsuarioPorEmail(emailAntigo);
        if (usuario == null) {
            JOptionPane.showMessageDialog(this, "Usuário com o email antigo não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Atualiza os dados do usuário
        usuario.setEmail(emailNovo);
        usuario.setNome(nomeNovo);

        try {
            gestorUsuarios.atualizarUsuario(usuario);
            JOptionPane.showMessageDialog(this, "Usuário atualizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            textFieldEmailAntigo.setText("");
            textFieldEmailNovo.setText("");
            textFieldNomeNovo.setText("");
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}

