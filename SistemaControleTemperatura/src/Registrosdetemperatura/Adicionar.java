package Registrosdetemperatura;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import gerenciador.GerenciadorTemperaturas; // Certifique-se de que o pacote está correto
import gerenciador.Temperatura; // Certifique-se de que o pacote está correto

public class Adicionar extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField campoData;
    private JTextField campoTemperatura;
    private GerenciadorTemperaturas gerenciadorTemperaturas;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Adicionar frame = new Adicionar();
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
    public Adicionar() {
        gerenciadorTemperaturas = new GerenciadorTemperaturas(); // Inicializa o gerenciador de temperaturas

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Rótulo e campo para a data
        JLabel lblData = new JLabel("Data (dd/MM/yyyy):");
        lblData.setFont(new Font("Arial", Font.PLAIN, 14));
        lblData.setBounds(10, 20, 150, 25);
        contentPane.add(lblData);

        campoData = new JTextField();
        campoData.setBounds(170, 20, 150, 25);
        contentPane.add(campoData);
        campoData.setColumns(10);

        // Rótulo e campo para a temperatura
        JLabel lblTemperatura = new JLabel("Temperatura:");
        lblTemperatura.setFont(new Font("Arial", Font.PLAIN, 14));
        lblTemperatura.setBounds(10, 60, 150, 25);
        contentPane.add(lblTemperatura);

        campoTemperatura = new JTextField();
        campoTemperatura.setBounds(170, 60, 150, 25);
        contentPane.add(campoTemperatura);
        campoTemperatura.setColumns(10);

        // Botão para adicionar temperatura
        JButton btnAdicionar = new JButton("Adicionar Temperatura");
        btnAdicionar.setBounds(100, 100, 200, 30);
        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarTemperatura();
            }
        });
        contentPane.add(btnAdicionar);
    }

    /**
     * Adiciona um novo registro de temperatura.
     */
    private void adicionarTemperatura() {
        try {
            String dataStr = campoData.getText();
            String temperaturaStr = campoTemperatura.getText();

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date data = sdf.parse(dataStr);
            double temperatura = Double.parseDouble(temperaturaStr);

            
            // Limpar campos após a adição
            campoData.setText("");
            campoTemperatura.setText("");

        } catch (ParseException ex) {
            ex.printStackTrace();
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
    }
}
