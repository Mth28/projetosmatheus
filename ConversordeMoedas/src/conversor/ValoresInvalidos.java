package conversor;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ValoresInvalidos extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel painelConteudo;
    private JTextField campoEntrada;
    private JLabel rotuloResultado;
    
    // Limites do intervalo para checar
    private static final double LIMITE_INFERIOR = 0;
    private static final double LIMITE_SUPERIOR = 1000;

    /**
     * Lança a aplicação.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ValoresInvalidos quadro = new ValoresInvalidos();
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
    public ValoresInvalidos() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 400);
        painelConteudo = new JPanel();
        painelConteudo.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(painelConteudo);
        painelConteudo.setLayout(null);

        // Rótulo de entrada
        JLabel rotuloEntrada = new JLabel("Digite um valor:");
        rotuloEntrada.setFont(new Font("Arial", Font.PLAIN, 14));
        rotuloEntrada.setBounds(10, 11, 120, 25);
        painelConteudo.add(rotuloEntrada);

        // Campo de entrada
        campoEntrada = new JTextField();
        campoEntrada.setBounds(140, 10, 200, 25);
        painelConteudo.add(campoEntrada);
        campoEntrada.setColumns(10);

        // Botão para verificar se é um número
        JButton botaoVerificarNumero = new JButton("Verificar se é um número");
        botaoVerificarNumero.setBounds(140, 50, 200, 30);
        botaoVerificarNumero.addActionListener(e -> verificarSeNumero());
        painelConteudo.add(botaoVerificarNumero);

        // Botão para verificar se o valor é positivo
        JButton botaoVerificarPositivo = new JButton("Verificar se é positivo");
        botaoVerificarPositivo.setBounds(140, 90, 200, 30);
        botaoVerificarPositivo.addActionListener(e -> verificarSePositivo());
        painelConteudo.add(botaoVerificarPositivo);

        // Botão para verificar se o valor está dentro de um intervalo
        JButton botaoVerificarIntervalo = new JButton("Verificar se está no intervalo");
        botaoVerificarIntervalo.setBounds(140, 130, 200, 30);
        botaoVerificarIntervalo.addActionListener(e -> verificarIntervalo());
        painelConteudo.add(botaoVerificarIntervalo);

        // Rótulo de resultado
        rotuloResultado = new JLabel("");
        rotuloResultado.setFont(new Font("Arial", Font.BOLD, 14));
        rotuloResultado.setBounds(10, 180, 550, 25);
        painelConteudo.add(rotuloResultado);
    }

    /**
     * Verifica se o texto inserido é um número e atualiza o rótulo de resultado.
     */
    private void verificarSeNumero() {
        String texto = campoEntrada.getText();
        try {
            Double.parseDouble(texto);
            rotuloResultado.setText("O valor é um número válido.");
        } catch (NumberFormatException e) {
            rotuloResultado.setText("O valor não é um número válido.");
        }
    }

    /**
     * Verifica se o número inserido é positivo e atualiza o rótulo de resultado.
     */
    private void verificarSePositivo() {
        String texto = campoEntrada.getText();
        try {
            double valor = Double.parseDouble(texto);
            if (valor > 0) {
                rotuloResultado.setText("O valor é positivo.");
            } else {
                rotuloResultado.setText("O valor não é positivo.");
            }
        } catch (NumberFormatException e) {
            rotuloResultado.setText("O valor não é um número válido.");
        }
    }

    /**
     * Verifica se o número inserido está dentro de um intervalo e atualiza o rótulo de resultado.
     */
    private void verificarIntervalo() {
        String texto = campoEntrada.getText();
        try {
            double valor = Double.parseDouble(texto);
            if (valor >= LIMITE_INFERIOR && valor <= LIMITE_SUPERIOR) {
                rotuloResultado.setText("O valor está dentro do intervalo permitido.");
            } else {
                rotuloResultado.setText("O valor está fora do intervalo permitido.");
            }
        } catch (NumberFormatException e) {
            rotuloResultado.setText("O valor não é um número válido.");
        }
    }
}
