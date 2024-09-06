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

public class AdicionarNota extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldNome;
    private JTextField textFieldNota;
    private JLabel lblFeedback;

    /**
     * Lança a aplicação.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AdicionarNota frame = new AdicionarNota();
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
    public AdicionarNota() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Rótulo para o nome do aluno
        JLabel lblNome = new JLabel("Nome do Aluno:");
        lblNome.setBounds(10, 10, 150, 25);
        contentPane.add(lblNome);

        // Campo de texto para o nome do aluno
        textFieldNome = new JTextField();
        textFieldNome.setBounds(170, 10, 250, 25);
        contentPane.add(textFieldNome);
        textFieldNome.setColumns(10);

        // Rótulo para a nota
        JLabel lblNota = new JLabel("Nota:");
        lblNota.setBounds(10, 50, 150, 25);
        contentPane.add(lblNota);

        // Campo de texto para a nota
        textFieldNota = new JTextField();
        textFieldNota.setBounds(170, 50, 100, 25);
        contentPane.add(textFieldNota);
        textFieldNota.setColumns(10);

        // Botão para adicionar a nota
        JButton btnAdicionar = new JButton("Adicionar Nota");
        btnAdicionar.setBounds(10, 90, 150, 25);
        btnAdicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                adicionarNota();
            }
        });
        contentPane.add(btnAdicionar);

        // Rótulo para mostrar o feedback
        lblFeedback = new JLabel("");
        lblFeedback.setBounds(10, 130, 400, 50);
        contentPane.add(lblFeedback);
    }

    /**
     * Adiciona a nota e atualiza o feedback.
     */
    private void adicionarNota() {
        try {
            // Obtém os valores dos campos de texto
            String nomeAluno = textFieldNome.getText();
            double nota = Double.parseDouble(textFieldNota.getText());

            // Valida a nota
            if (nota < 0 || nota > 10) {
                lblFeedback.setText("A nota deve estar entre 0 e 10.");
                return;
            }

            // Atualiza o rótulo com a nota adicionada
            lblFeedback.setText(String.format("Nota de %s: %.2f adicionada com sucesso!", nomeAluno, nota));
        } catch (NumberFormatException e) {
            lblFeedback.setText("Por favor, insira uma nota válida.");
        }
    }
}
