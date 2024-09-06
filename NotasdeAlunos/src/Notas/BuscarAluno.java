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

public class BuscarAluno extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldNomeAluno;
    private JLabel lblResultado;

    /**
     * Lança a aplicação.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BuscarAluno frame = new BuscarAluno();
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
    public BuscarAluno() {
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
        textFieldNomeAluno = new JTextField();
        textFieldNomeAluno.setBounds(160, 10, 200, 25);
        contentPane.add(textFieldNomeAluno);
        textFieldNomeAluno.setColumns(10);

        // Botão para buscar o aluno
        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(10, 50, 150, 25);
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarAluno();
            }
        });
        contentPane.add(btnBuscar);

        // Rótulo para mostrar o resultado
        lblResultado = new JLabel("");
        lblResultado.setBounds(10, 90, 400, 50);
        contentPane.add(lblResultado);
    }

    /**
     * Simula a busca do aluno e atualiza o feedback.
     */
    private void buscarAluno() {
        String nomeAluno = textFieldNomeAluno.getText();

        // Simulação de busca do aluno
        if (nomeAluno.isEmpty()) {
            lblResultado.setText("Por favor, insira o nome do aluno.");
        } else {
            // Aqui você poderia implementar a lógica para buscar o aluno em um banco de dados ou lista
            // Por exemplo, vamos simular que o aluno foi encontrado:
            lblResultado.setText("Aluno " + nomeAluno + " encontrado com sucesso!");
        }
    }
}
