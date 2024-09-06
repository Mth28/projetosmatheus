package conversor;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MoedaNaoReconhecida extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel painelConteudo;
    private JTextField campoEntrada;
    private JTextField campoResultado;
    private JLabel rotuloResultado;

    // Taxa de conversão fixa para moeda
    private static final double TAXA_CONVERSAO_USD_BRL = 5.30; // Exemplo: 1 USD = 5.30 BRL

    /**
     * Lança a aplicação.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MoedaNaoReconhecida quadro = new MoedaNaoReconhecida();
                    quadro.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Cria o quadro.
     */
    public MoedaNaoReconhecida() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 400);
        painelConteudo = new JPanel();
        painelConteudo.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(painelConteudo);
        painelConteudo.setLayout(null);

        // Rótulo de entrada
        JLabel rotuloEntrada = new JLabel("Digite o valor:");
        rotuloEntrada.setFont(new Font("Arial", Font.PLAIN, 14));
        rotuloEntrada.setBounds(10, 11, 100, 25);
        painelConteudo.add(rotuloEntrada);

        // Campo de entrada
        campoEntrada = new JTextField();
        campoEntrada.setBounds(120, 10, 200, 25);
        painelConteudo.add(campoEntrada);
        campoEntrada.setColumns(10);

        // Campo de resultado
        campoResultado = new JTextField();
        campoResultado.setBounds(120, 50, 200, 25);
        campoResultado.setEditable(false);
        painelConteudo.add(campoResultado);
        campoResultado.setColumns(10);

        // Botão de conversão de moeda
        JButton botaoConverterMoeda = new JButton("Converter Moeda");
        botaoConverterMoeda.setBounds(120, 90, 200, 30);
        botaoConverterMoeda.addActionListener(e -> converterMoeda());
        painelConteudo.add(botaoConverterMoeda);

        // Rótulo de resultado
        rotuloResultado = new JLabel("");
        rotuloResultado.setFont(new Font("Arial", Font.BOLD, 14));
        rotuloResultado.setBounds(10, 130, 400, 25);
        painelConteudo.add(rotuloResultado);
    }

    /**
     * Converte o valor de moeda entre Reais (BRL) e Dólares (USD) e atualiza o campo de resultado.
     */
    private void converterMoeda() {
        try {
            double valor = Double.parseDouble(campoEntrada.getText());
            if (valor < 0) {
                rotuloResultado.setText("O valor deve ser positivo.");
                campoResultado.setText("");
                return;
            }
            // Converter de Reais para Dólares
            double resultado = valor / TAXA_CONVERSAO_USD_BRL;
            campoResultado.setText(String.format("%.2f USD", resultado));
            rotuloResultado.setText("Valor convertido para Dólares.");
        } catch (NumberFormatException e) {
            rotuloResultado.setText("Por favor, digite um valor válido.");
            campoResultado.setText("");
        }
    }
}
