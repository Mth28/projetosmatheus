package ValidarSenha;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

public class EntradasVaziasNulas extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldEntrada;
    private JLabel lblFeedback;

    /**
     * Lança a aplicação.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    EntradasVaziasNulas frame = new EntradasVaziasNulas();
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
    public EntradasVaziasNulas() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Rótulo para instrução
        JLabel lblInstruction = new JLabel("Digite algo:");
        lblInstruction.setBounds(10, 10, 150, 25);
        contentPane.add(lblInstruction);

        // Campo de texto para entrada de dados
        textFieldEntrada = new JTextField();
        textFieldEntrada.setBounds(170, 10, 200, 25);
        contentPane.add(textFieldEntrada);
        textFieldEntrada.setColumns(10);

        // Botão para verificar entrada
        JButton btnVerificar = new JButton("Verificar Entrada");
        btnVerificar.setBounds(10, 50, 150, 25);
        btnVerificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                verificarEntrada();
            }
        });
        contentPane.add(btnVerificar);

        // Rótulo para mostrar feedback
        lblFeedback = new JLabel("");
        lblFeedback.setBounds(10, 90, 400, 50);
        contentPane.add(lblFeedback);
    }

    /**
     * Verifica se a entrada está vazia ou nula e atualiza o feedback.
     */
    private void verificarEntrada() {
        String entrada = textFieldEntrada.getText();
        if (entrada == null || entrada.trim().isEmpty()) {
            lblFeedback.setText("A entrada está vazia ou nula.");
        } else {
            lblFeedback.setText("A entrada é: " + entrada);
        }
    }
}
