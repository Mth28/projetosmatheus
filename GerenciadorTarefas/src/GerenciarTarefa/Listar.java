package GerenciarTarefa;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.BorderLayout;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import gerenciador.GerenciadorTarefas;
import gerenciador.Tarefa;

public class Listar extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextArea textAreaTarefas;
    private GerenciadorTarefas gerenciadorTarefas;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Listar frame = new Listar();
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
    public Listar() {
        gerenciadorTarefas = new GerenciadorTarefas();
        inicializarTarefas(); // Método para adicionar tarefas de exemplo

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout());

        textAreaTarefas = new JTextArea();
        textAreaTarefas.setFont(new Font("Arial", Font.PLAIN, 14));
        textAreaTarefas.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textAreaTarefas);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        listarTarefas();
    }

    /**
     * Lista todas as tarefas e exibe no JTextArea.
     */
    public void listarTarefas() {
        List<Tarefa> tarefas = gerenciadorTarefas.listarTarefas();
        StringBuilder sb = new StringBuilder();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        if (tarefas.isEmpty()) {
            sb.append("Nenhuma tarefa encontrada.");
        } else {
            for (Tarefa tarefa : tarefas) {
                sb.append("Título: ").append(tarefa.getTitulo()).append("\n");
                sb.append("Descrição: ").append(tarefa.getDescricao()).append("\n");
                sb.append("Data de Conclusão: ").append(sdf.format(tarefa.getDataConclusao())).append("\n");
                sb.append("Status: ").append(tarefa.isStatus() ? "Concluída" : "Não Concluída").append("\n");
                sb.append("------------------------------------\n");
            }
        }

        textAreaTarefas.setText(sb.toString());
    }

    /**
     * Método para adicionar tarefas de exemplo.
     */
    private void inicializarTarefas() {
        gerenciadorTarefas.adicionarTarefa(new Tarefa("Estudar Java", "Revisar conceitos de OOP", new java.util.Date(), false));
        gerenciadorTarefas.adicionarTarefa(new Tarefa("Comprar comida", "Comprar frutas e vegetais", new java.util.Date(), true));
    }
}
