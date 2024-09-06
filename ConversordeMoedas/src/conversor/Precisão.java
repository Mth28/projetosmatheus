package conversor;

import java.awt.EventQueue;
import java.awt.Font;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Precisão extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel painelConteudo;
    private JTextField campoNumero;
    private JTextField campoPrecisao;
    private JLabel rotuloResultado;

    /**
     * Lança a aplicação.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Precisão quadro = new Precisão();
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
    public Precisão() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 400);
        painelConteudo = new JPanel();
        painelConteudo.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(painelConteudo);
        painelConteudo.setLayout(null);

        // Rótulo para o número
        JLabel rotuloNumero = new JLabel("Digite um número:");
        rotuloNumero.setFont(new Font("Arial", Font.PLAIN, 14));
        rotuloNumero.setBounds(10, 20, 150, 25);
        painelConteudo.add(rotuloNumero);

        // Campo para o número
        campoNumero = new JTextField();
        campoNumero.setBounds(170, 20, 200, 25);
        painelConteudo.add(campoNumero);
        campoNumero.setColumns(10);

        // Rótulo para a precisão
        JLabel rotuloPrecisao = new JLabel("Digite a precisão (número de casas decimais):");
        rotuloPrecisao.setFont(new Font("Arial", Font.PLAIN, 14));
        rotuloPrecisao.setBounds(10, 60, 300, 25);
        painelConteudo.add(rotuloPrecisao);

        // Campo para a precisão
        campoPrecisao = new JTextField();
        campoPrecisao.setBounds(320, 60, 50, 25);
        painelConteudo.add(campoPrecisao);
        campoPrecisao.setColumns(5);

        // Botão para ajustar a precisão
        JButton botaoAjustarPrecisao = new JButton("Ajustar Precisão");
        botaoAjustarPrecisao.setBounds(170, 100, 200, 30);
        botaoAjustarPrecisao.addActionListener(e -> ajustarPrecisao());
        painelConteudo.add(botaoAjustarPrecisao);

        // Rótulo de resultado
        rotuloResultado = new JLabel("");
        rotuloResultado.setFont(new Font("Arial", Font.BOLD, 14));
        rotuloResultado.setBounds(10, 150, 550, 25);
        painelConteudo.add(rotuloResultado);
    }

    /**
     * Ajusta a precisão do número e atualiza o rótulo de resultado.
     */
    private void ajustarPrecisao() {
        String textoNumero = campoNumero.getText();
        String textoPrecisao = campoPrecisao.getText();

        try {
            double numero = Double.parseDouble(textoNumero);
            int precisao = Integer.parseInt(textoPrecisao);
            
            // Criar formato decimal com a precisão especificada
            String formato = "#." + "#".repeat(precisao); // Ex: "#.##" para 2 casas decimais
            DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
            simbolos.setDecimalSeparator(',');
            DecimalFormat decimalFormat = new DecimalFormat(formato, simbolos);

            // Aplicar o formato ao número
            String numeroFormatado = decimalFormat.format(numero);
            rotuloResultado.setText("Número formatado: " + numeroFormatado);
        } catch (NumberFormatException e) {
            rotuloResultado.setText("Por favor, insira um número válido e uma precisão.");
        } catch (IllegalArgumentException e) {
            rotuloResultado.setText("A precisão deve ser um número inteiro não negativo.");
        }
    }
}
