package GerenciarTarefa;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import gerenciador.GerenciadorTarefas; // Importe a classe GerenciadorTarefas
import gerenciador.Tarefa; // Importe a classe Tarefa

public class Remover extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField campoTitulo;
    private JLabel rotuloResultado;
    private GerenciadorTarefas gerenciadorTarefas; // Instância do GerenciadorTarefas

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Remover frame = new Remover();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Remover() {
        gerenciadorTarefas = new GerenciadorTarefas(); // Inicializa o GerenciadorTarefas

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Rótulo para o título da tarefa
        JLabel rotuloTitulo = new JLabel("Digite o título da tarefa:");
        rotuloTitulo.setFont(new Font("Arial", Font.PLAIN, 14));
        rotuloTitulo.setBounds(10, 20, 200, 25);
        contentPane.add(rotuloTitulo);

        // Campo para o título da tarefa
        campoTitulo = new JTextField();
        campoTitulo.setBounds(220, 20, 200, 25);
        contentPane.add(campoTitulo);
        campoTitulo.setColumns(20);

        // Botão para remover a tarefa
        JButton botaoRemover = new JButton("Remover Tarefa");
        botaoRemover.setBounds(220, 60, 150, 30);
        botaoRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removerTarefa();
            }
        });
        contentPane.add(botaoRemover);

        // Rótulo de resultado
        rotuloResultado = new JLabel("");
        rotuloResultado.setFont(new Font("Arial", Font.BOLD, 14));
        rotuloResultado.setBounds(10, 100, 400, 25);
        contentPane.add(rotuloResultado);
    }

    /**
     * Remove a tarefa com base no título e atualiza o rótulo de resultado.
     */
    private void removerTarefa() {
        String titulo = campoTitulo.getText().trim();
        if (titulo.isEmpty()) {
            rotuloResultado.setText("Por favor, digite um título de tarefa.");
            return;
        }

        // Remove a tarefa com base no título
        gerenciadorTarefas.removerTarefa(titulo);
        rotuloResultado.setText("Tarefa com o título \"" + titulo + "\" removida com sucesso.");
    }
}
