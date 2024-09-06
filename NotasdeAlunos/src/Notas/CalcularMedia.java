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

public class CalcularMedia extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldNota1;
    private JTextField textFieldNota2;
    private JTextField textFieldNota3;
    private JLabel lblFeedback;

    /**
     * Lança a aplicação.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CalcularMedia frame = new CalcularMedia();
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
    public CalcularMedia() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Rótulo para a primeira nota
        JLabel lblNota1 = new JLabel("Nota 1:");
        lblNota1.setBounds(10, 10, 100, 25);
        contentPane.add(lblNota1);

        // Campo de texto para a primeira nota
        textFieldNota1 = new JTextField();
        textFieldNota1.setBounds(120, 10, 100, 25);
        contentPane.add(textFieldNota1);
        textFieldNota1.setColumns(10);

        // Rótulo para a segunda nota
        JLabel lblNota2 = new JLabel("Nota 2:");
        lblNota2.setBounds(10, 50, 100, 25);
        contentPane.add(lblNota2);

        // Campo de texto para a segunda nota
        textFieldNota2 = new JTextField();
        textFieldNota2.setBounds(120, 50, 100, 25);
        contentPane.add(textFieldNota2);
        textFieldNota2.setColumns(10);

        // Rótulo para a terceira nota
        JLabel lblNota3 = new JLabel("Nota 3:");
        lblNota3.setBounds(10, 90, 100, 25);
        contentPane.add(lblNota3);

        // Campo de texto para a terceira nota
        textFieldNota3 = new JTextField();
        textFieldNota3.setBounds(120, 90, 100, 25);
        contentPane.add(textFieldNota3);
        textFieldNota3.setColumns(10);

        // Botão para calcular a média
        JButton btnCalcularMedia = new JButton("Calcular Média");
        btnCalcularMedia.setBounds(10, 130, 150, 25);
        btnCalcularMedia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularMedia();
            }
        });
        contentPane.add(btnCalcularMedia);

        // Rótulo para mostrar o feedback
        lblFeedback = new JLabel("");
        lblFeedback.setBounds(10, 170, 400, 50);
        contentPane.add(lblFeedback);
    }

    /**
     * Calcula a média das notas e atualiza o feedback.
     */
    private void calcularMedia() {
        try {
            // Obtém os valores dos campos de texto
            double nota1 = Double.parseDouble(textFieldNota1.getText());
            double nota2 = Double.parseDouble(textFieldNota2.getText());
            double nota3 = Double.parseDouble(textFieldNota3.getText());

            // Valida as notas
            if (nota1 < 0 || nota1 > 10 || nota2 < 0 || nota2 > 10 || nota3 < 0 || nota3 > 10) {
                lblFeedback.setText("Cada nota deve estar entre 0 e 10.");
                return;
            }

            // Calcula a média das notas
            double media = (nota1 + nota2 + nota3) / 3;

            // Atualiza o rótulo com a média
            lblFeedback.setText(String.format("A média das notas é: %.2f", media));
        } catch (NumberFormatException e) {
            lblFeedback.setText("Por favor, insira notas válidas.");
        }
    }
}
