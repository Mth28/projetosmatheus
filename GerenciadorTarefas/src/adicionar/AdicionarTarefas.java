package adicionar;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

import GerenciarTarefa.Listar;
import gerenciador.GerenciadorTarefas;
import gerenciador.Tarefa;

public class AdicionarTarefas extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField campoTitulo;
    private JTextField campoDescricao;
    private JTextField campoDataConclusao;
    private JTextField campoStatus;
    private GerenciadorTarefas gerenciadorTarefas;
    private Listar listaFrame; // Referência para atualizar a lista

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AdicionarTarefas frame = new AdicionarTarefas(null); // Passar null para listarFrame
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
    public AdicionarTarefas(Listar listaFrame) {
        this.listaFrame = listaFrame;
        gerenciadorTarefas = new GerenciadorTarefas();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Rótulo e campo para título
        JLabel lblTitulo = new JLabel("Título:");
        lblTitulo.setFont(new Font("Arial", Font.PLAIN, 14));
        lblTitulo.setBounds(10, 20, 80, 25);
        contentPane.add(lblTitulo);

        campoTitulo = new JTextField();
        campoTitulo.setBounds(100, 20, 250, 25);
        contentPane.add(campoTitulo);
        campoTitulo.setColumns(30);

        // Rótulo e campo para descrição
        JLabel lblDescricao = new JLabel("Descrição:");
        lblDescricao.setFont(new Font("Arial", Font.PLAIN, 14));
        lblDescricao.setBounds(10, 60, 80, 25);
        contentPane.add(lblDescricao);

        campoDescricao = new JTextField();
        campoDescricao.setBounds(100, 60, 250, 25);
        contentPane.add(campoDescricao);
        campoDescricao.setColumns(30);

        // Rótulo e campo para data de conclusão
        JLabel lblDataConclusao = new JLabel("Data de Conclusão (dd/MM/yyyy):");
        lblDataConclusao.setFont(new Font("Arial", Font.PLAIN, 14));
        lblDataConclusao.setBounds(10, 100, 200, 25);
        contentPane.add(lblDataConclusao);

        campoDataConclusao = new JTextField();
        campoDataConclusao.setBounds(220, 100, 130, 25);
        contentPane.add(campoDataConclusao);
        campoDataConclusao.setColumns(10);

        // Rótulo e campo para status
        JLabel lblStatus = new JLabel("Status (true/false):");
        lblStatus.setFont(new Font("Arial", Font.PLAIN, 14));
        lblStatus.setBounds(10, 140, 150, 25);
        contentPane.add(lblStatus);

        campoStatus = new JTextField();
        campoStatus.setBounds(170, 140, 50, 25);
        contentPane.add(campoStatus);
        campoStatus.setColumns(5);

        // Botão para adicionar tarefa
        JButton btnAdicionar = new JButton("Adicionar Tarefa");
        btnAdicionar.setBounds(100, 200, 200, 30);
        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarTarefa();
            }
        });
        contentPane.add(btnAdicionar);
    }

    /**
     * Adiciona uma nova tarefa ao gerenciador e atualiza a lista.
     */
    private void adicionarTarefa() {
        try {
            String titulo = campoTitulo.getText();
            String descricao = campoDescricao.getText();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date dataConclusao = sdf.parse(campoDataConclusao.getText());
            boolean status = Boolean.parseBoolean(campoStatus.getText());

            Tarefa novaTarefa = new Tarefa(titulo, descricao, dataConclusao, status);
            gerenciadorTarefas.adicionarTarefa(novaTarefa);

            if (listaFrame != null) {
                listaFrame.listarTarefas(); // Atualiza a lista de tarefas
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }
}
