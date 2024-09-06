package conversor;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ConversoesValidas extends JFrame {

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
                    ConversoesValidas quadro = new ConversoesValidas();
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
    public ConversoesValidas() {
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

        // Botão de conversão de temperatura
        JButton botaoConverterTemperatura = new JButton("Converter Temperatura");
        botaoConverterTemperatura.setBounds(120, 90, 200, 30);
        botaoConverterTemperatura.addActionListener(e -> converterTemperatura());
        painelConteudo.add(botaoConverterTemperatura);

        // Botão de conversão de moeda
        JButton botaoConverterMoeda = new JButton("Converter Moeda");
        botaoConverterMoeda.setBounds(120, 130, 200, 30);
        botaoConverterMoeda.addActionListener(e -> converterMoeda());
        painelConteudo.add(botaoConverterMoeda);

        // Botão de conversão de distância
        JButton botaoConverterDistancia = new JButton("Converter Distância");
        botaoConverterDistancia.setBounds(120, 170, 200, 30);
        botaoConverterDistancia.addActionListener(e -> converterDistancia());
        painelConteudo.add(botaoConverterDistancia);

        // Rótulo de resultado
        rotuloResultado = new JLabel("");
        rotuloResultado.setFont(new Font("Arial", Font.BOLD, 14));
        rotuloResultado.setBounds(10, 220, 400, 25);
        painelConteudo.add(rotuloResultado);
    }

    /**
     * Converte o valor de temperatura entre Celsius e Fahrenheit e atualiza o campo de resultado.
     */
    private void converterTemperatura() {
        try {
            double valor = Double.parseDouble(campoEntrada.getText());
            // Converter de Celsius para Fahrenheit
            double resultado = (valor * 9/5) + 32;
            campoResultado.setText(String.format("%.2f °F", resultado));
            rotuloResultado.setText("Temperatura convertida para Fahrenheit.");
        } catch (NumberFormatException e) {
            rotuloResultado.setText("Por favor, digite um valor válido.");
        }
    }

    /**
     * Converte o valor de moeda entre Reais (BRL) e Dólares (USD) e atualiza o campo de resultado.
     */
    private void converterMoeda() {
        try {
            double valor = Double.parseDouble(campoEntrada.getText());
            // Converter de Reais para Dólares
            double resultado = valor / TAXA_CONVERSAO_USD_BRL;
            campoResultado.setText(String.format("%.2f USD", resultado));
            rotuloResultado.setText("Valor convertido para Dólares.");
        } catch (NumberFormatException e) {
            rotuloResultado.setText("Por favor, digite um valor válido.");
        }
    }

    /**
     * Converte o valor de distância entre Quilômetros e Milhas e atualiza o campo de resultado.
     */
    private void converterDistancia() {
        try {
            double valor = Double.parseDouble(campoEntrada.getText());
            // Converter de Quilômetros para Milhas
            double resultado = valor * 0.621371;
            campoResultado.setText(String.format("%.2f Milhas", resultado));
            rotuloResultado.setText("Distância convertida para Milhas.");
        } catch (NumberFormatException e) {
            rotuloResultado.setText("Por favor, digite um valor válido.");
        }
    }
}
