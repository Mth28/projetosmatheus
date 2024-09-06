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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Atualizar extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField campoTituloAtualizar;
    private JTextField campoNovaDescricao;
    private JTextField campoNovaData;
    private JLabel rotuloResultado;
    private GerenciadorTarefas gerenciadorTarefas; // Instância do GerenciadorTarefas

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Atualizar frame = new Atualizar();
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
    public Atualizar() {
        gerenciadorTarefas = new GerenciadorTarefas(); // Inicializa o GerenciadorTarefas

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Rótulo para o título da tarefa a ser atualizada
        JLabel rotuloTituloAtualizar = new JLabel("Título da tarefa a ser atualizada:");
        rotuloTituloAtualizar.setFont(new Font("Arial", Font.PLAIN, 14));
        rotuloTituloAtualizar.setBounds(10, 20, 250, 25);
        contentPane.add(rotuloTituloAtualizar);

        // Campo para o título da tarefa a ser atualizada
        campoTituloAtualizar = new JTextField();
        campoTituloAtualizar.setBounds(270, 20, 150, 25);
        contentPane.add(campoTituloAtualizar);
        campoTituloAtualizar.setColumns(20);

        // Rótulo para a nova descrição
        JLabel rotuloNovaDescricao = new JLabel("Nova descrição:");
        rotuloNovaDescricao.setFont(new Font("Arial", Font.PLAIN, 14));
        rotuloNovaDescricao.setBounds(10, 60, 150, 25);
        contentPane.add(rotuloNovaDescricao);

        // Campo para a nova descrição
        campoNovaDescricao = new JTextField();
        campoNovaDescricao.setBounds(120, 60, 300, 25);
        contentPane.add(campoNovaDescricao);
        campoNovaDescricao.setColumns(30);

        // Rótulo para a nova data de conclusão
        JLabel rotuloNovaData = new JLabel("Nova data de conclusão (dd/MM/yyyy):");
        rotuloNovaData.setFont(new Font("Arial", Font.PLAIN, 14));
        rotuloNovaData.setBounds(10, 100, 250, 25);
        contentPane.add(rotuloNovaData);

        // Campo para a nova data de conclusão
        campoNovaData = new JTextField();
        campoNovaData.setBounds(270, 100, 150, 25);
        contentPane.add(campoNovaData);
        campoNovaData.setColumns(15);

        // Botão para atualizar a tarefa
        JButton botaoAtualizar = new JButton("Atualizar Tarefa");
        botaoAtualizar.setBounds(150, 150, 150, 30);
        botaoAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarTarefa();
            }
        });
        contentPane.add(botaoAtualizar);

        // Rótulo de resultado
        rotuloResultado = new JLabel("");
        rotuloResultado.setFont(new Font("Arial", Font.BOLD, 14));
        rotuloResultado.setBounds(10, 200, 400, 25);
        contentPane.add(rotuloResultado);
    }

    /**
     * Atualiza a tarefa com base nos campos preenchidos e exibe o resultado.
     */
    private void atualizarTarefa() {
        String titulo = campoTituloAtualizar.getText().trim();
        String novaDescricao = campoNovaDescricao.getText().trim();
        String novaDataStr = campoNovaData.getText().trim();

        if (titulo.isEmpty() || novaDescricao.isEmpty() || novaDataStr.isEmpty()) {
            rotuloResultado.setText("Por favor, preencha todos os campos.");
            return;
        }

        Date novaData;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            novaData = sdf.parse(novaDataStr);
        } catch (ParseException e) {
            rotuloResultado.setText("Data inválida. Use o formato dd/MM/yyyy.");
            return;
        }

        // Cria uma nova tarefa com as informações fornecidas
        Tarefa tarefaAtualizada = new Tarefa(titulo, novaDescricao, novaData, false);
        gerenciadorTarefas.atualizarTarefa(tarefaAtualizada);
        rotuloResultado.setText("Tarefa atualizada com sucesso.");
    }
}
