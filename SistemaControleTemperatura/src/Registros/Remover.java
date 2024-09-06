package Registros;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import gerenciador.GerenciadorTemperaturas;
import gerenciador.Temperatura;

public class Remover extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField campoData;
    private JTextField campoValor;
    private JLabel rotuloResultado;
    private GerenciadorTemperaturas gerenciadorTemperaturas;

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
        gerenciadorTemperaturas = new GerenciadorTemperaturas(); // Inicializa o Gerenciador de Temperaturas

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Rótulo para a data
        JLabel rotuloData = new JLabel("Data (dd/MM/yyyy):");
        rotuloData.setFont(new Font("Arial", Font.PLAIN, 14));
        rotuloData.setBounds(10, 20, 150, 25);
        contentPane.add(rotuloData);

        // Campo de texto para a data
        campoData = new JTextField();
        campoData.setBounds(170, 20, 100, 25);
        contentPane.add(campoData);
        campoData.setColumns(10);

        // Rótulo para o valor
        JLabel rotuloValor = new JLabel("Valor da Temperatura:");
        rotuloValor.setFont(new Font("Arial", Font.PLAIN, 14));
        rotuloValor.setBounds(10, 60, 150, 25);
        contentPane.add(rotuloValor);

        // Campo de texto para o valor
        campoValor = new JTextField();
        campoValor.setBounds(170, 60, 100, 25);
        contentPane.add(campoValor);
        campoValor.setColumns(10);

        // Botão para remover a temperatura
        JButton botaoRemover = new JButton("Remover Temperatura");
        botaoRemover.setBounds(170, 100, 200, 30);
        botaoRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removerTemperatura();
            }
        });
        contentPane.add(botaoRemover);

        // Rótulo de resultado
        rotuloResultado = new JLabel("");
        rotuloResultado.setFont(new Font("Arial", Font.BOLD, 14));
        rotuloResultado.setBounds(10, 150, 400, 25);
        contentPane.add(rotuloResultado);
    }

    /**
     * Remove a temperatura com base nos dados fornecidos e exibe o resultado.
     */
    private void removerTemperatura() {
        String dataTexto = campoData.getText();
        String valorTexto = campoValor.getText();

        try {
            // Converte a data
            SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
            Date data = formatoData.parse(dataTexto);

            // Converte o valor
            double valor = Double.parseDouble(valorTexto);

            // Cria o objeto Temperatura
            Temperatura temperatura = new Temperatura(data, valor);

            // Remove a temperatura
            gerenciadorTemperaturas.removerTemperatura(temperatura);

            // Atualiza o rótulo de resultado
            rotuloResultado.setText("Temperatura removida com sucesso.");

        } catch (Exception e) {
            // Caso ocorra algum erro na conversão ou remoção
            rotuloResultado.setText("Erro: " + e.getMessage());
        }
    }
}
