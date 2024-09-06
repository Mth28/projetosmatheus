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

public class Buscar extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldEmail;
    private JTextField textFieldNome;
    private JTextField textFieldDataNascimento;
    private GestorUsuarios gestorUsuarios;

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
        gestorUsuarios = new GestorUsuarios(); // Inicializa GestorUsuarios

        setTitle("Buscar Usuário");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(10, 30, 80, 14);
        contentPane.add(lblEmail);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(10, 70, 80, 14);
        contentPane.add(lblNome);

        JLabel lblDataNascimento = new JLabel("Data Nascimento:");
        lblDataNascimento.setBounds(10, 110, 120, 14);
        contentPane.add(lblDataNascimento);

        textFieldEmail = new JTextField();
        textFieldEmail.setBounds(100, 27, 200, 20);
        contentPane.add(textFieldEmail);
        textFieldEmail.setColumns(10);

        textFieldNome = new JTextField();
        textFieldNome.setBounds(100, 67, 200, 20);
        contentPane.add(textFieldNome);
        textFieldNome.setColumns(10);
        textFieldNome.setEditable(false); // Não permite editar o nome

        textFieldDataNascimento = new JTextField();
        textFieldDataNascimento.setBounds(130, 107, 170, 20);
        contentPane.add(textFieldDataNascimento);
        textFieldDataNascimento.setColumns(10);
        textFieldDataNascimento.setEditable(false); // Não permite editar a data de nascimento

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(80, 150, 100, 23);
        contentPane.add(btnBuscar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(190, 150, 100, 23);
        contentPane.add(btnCancelar);

        // Action for the "Buscar" button
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarUsuario();
            }
        });

        // Action for the "Cancelar" button
        btnCancelar.addActionListener(e -> {
            textFieldEmail.setText("");
            textFieldNome.setText("");
            textFieldDataNascimento.setText("");
        });
    }

    private void buscarUsuario() {
        String email = textFieldEmail.getText();

        if (email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "O campo email deve ser preenchido.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Usuario usuario = gestorUsuarios.buscarUsuarioPorEmail(email);
        if (usuario == null) {
            JOptionPane.showMessageDialog(this, "Usuário não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        textFieldNome.setText(usuario.getNome());
        textFieldDataNascimento.setText(usuario.getDataNascimento());
    }
}
