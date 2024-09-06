package Notas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

public class EntradasInvalidas extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldEntrada;
    private JLabel lblResultado;

    /**
     * Lança a aplicação.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    EntradasInvalidas frame = new EntradasInvalidas();
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
    public EntradasInvalidas() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Rótulo para a entrada
        JLabel lblEntrada = new JLabel("Insira um valor:");
        lblEntrada.setBounds(10, 10, 150, 25);
        contentPane.add(lblEntrada);

        // Campo de texto para a entrada
        textFieldEntrada = new JTextField();
        textFieldEntrada.setBounds(160, 10, 200, 25);
        contentPane.add(textFieldEntrada);
        textFieldEntrada.setColumns(10);

        // Botão para validar a entrada
        JButton btnValidar = new JButton("Validar");
        btnValidar.setBounds(10, 50, 150, 25);
        btnValidar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                validarEntrada();
            }
        });
        contentPane.add(btnValidar);

        // Rótulo para mostrar o resultado
        lblResultado = new JLabel("");
        lblResultado.setBounds(10, 90, 400, 50);
        contentPane.add(lblResultado);
    }

    /**
     * Valida a entrada e atualiza o feedback.
     */
    private void validarEntrada() {
        String entrada = textFieldEntrada.getText();

        // Valida a entrada
        if (entrada.isEmpty()) {
            lblResultado.setText("O campo de entrada não pode estar vazio.");
        } else {
            try {
                // Tenta converter a entrada para um número
                Double.parseDouble(entrada);
                lblResultado.setText("Entrada válida: " + entrada);
            } catch (NumberFormatException e) {
                lblResultado.setText("Entrada inválida. Por favor, insira um número.");
            }
        }
    }
}
