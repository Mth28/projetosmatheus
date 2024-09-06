package ValidarSenha;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;

public class SenhaValida extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPasswordField passwordField;
    private JLabel lblFeedback;
    private JCheckBox chkShowPassword;
    private JTextArea textAreaHistorico;
    
    /**
     * Lança a aplicação.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SenhaValida frame = new SenhaValida();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Cria o frame.
     */
    public SenhaValida() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Rótulo para instrução
        JLabel lblInstruction = new JLabel("Digite a senha:");
        lblInstruction.setBounds(10, 10, 150, 25);
        contentPane.add(lblInstruction);

        // Campo de texto para a senha
        passwordField = new JPasswordField();
        passwordField.setBounds(170, 10, 200, 25);
        contentPane.add(passwordField);

        // Botão para validar a senha
        JButton btnVerificar = new JButton("Verificar Senha");
        btnVerificar.setBounds(10, 50, 150, 25);
        btnVerificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                verificarSenha();
            }
        });
        contentPane.add(btnVerificar);

        // Botão para limpar o campo de senha
        JButton btnLimpar = new JButton("Limpar");
        btnLimpar.setBounds(170, 50, 100, 25);
        btnLimpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                passwordField.setText("");
                lblFeedback.setText("");
            }
        });
        contentPane.add(btnLimpar);

        // Rótulo para mostrar feedback
        lblFeedback = new JLabel("");
        lblFeedback.setBounds(10, 90, 500, 50);
        contentPane.add(lblFeedback);

        // Caixa de seleção para mostrar/ocultar senha
        chkShowPassword = new JCheckBox("Mostrar Senha");
        chkShowPassword.setBounds(280, 50, 150, 25);
        chkShowPassword.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (chkShowPassword.isSelected()) {
                    passwordField.setEchoChar((char) 0);
                } else {
                    passwordField.setEchoChar('*');
                }
            }
        });
        contentPane.add(chkShowPassword);

        // Área de texto para histórico de senhas válidas
        JLabel lblHistorico = new JLabel("Histórico de Senhas Válidas:");
        lblHistorico.setBounds(10, 150, 200, 25);
        contentPane.add(lblHistorico);

        textAreaHistorico = new JTextArea();
        textAreaHistorico.setBounds(10, 180, 550, 150);
        textAreaHistorico.setEditable(false);
        contentPane.add(textAreaHistorico);
    }

    /**
     * Verifica a validade da senha e atualiza o feedback.
     */
    private void verificarSenha() {
        String senha = new String(passwordField.getPassword());
        if (senha.length() < 8) {
            lblFeedback.setText("Senha deve ter pelo menos 8 caracteres.");
        } else if (!senha.matches(".*[A-Z].*")) {
            lblFeedback.setText("Senha deve conter pelo menos uma letra maiúscula.");
        } else if (!senha.matches(".*[a-z].*")) {
            lblFeedback.setText("Senha deve conter pelo menos uma letra minúscula.");
        } else if (!senha.matches(".*\\d.*")) {
            lblFeedback.setText("Senha deve conter pelo menos um número.");
        } else if (!senha.matches(".*[@#$%^&+=].*")) {
            lblFeedback.setText("Senha deve conter pelo menos um caractere especial (@, #, $, %, &, +, =).");
        } else {
            lblFeedback.setText("Senha válida!");
            adicionarAoHistorico(senha);
        }
    }

    /**
     * Adiciona a senha válida ao histórico.
     */
    private void adicionarAoHistorico(String senha) {
        textAreaHistorico.append(senha + "\n");
    }
}
