package palindromo;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class CaracteresEspeciais extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel painelConteudo;
    private JTextField campoTexto;
    private JLabel rotuloResultado;

    /**
     * Lança a aplicação.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CaracteresEspeciais quadro = new CaracteresEspeciais();
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
    public CaracteresEspeciais() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 400); // Aumentar a altura para acomodar novos botões
        painelConteudo = new JPanel();
        painelConteudo.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(painelConteudo);
        painelConteudo.setLayout(null);

        // Rótulo
        JLabel rotuloTexto = new JLabel("Digite o texto:");
        rotuloTexto.setFont(new Font("Arial", Font.PLAIN, 14));
        rotuloTexto.setBounds(10, 11, 100, 25);
        painelConteudo.add(rotuloTexto);

        // Campo de texto
        campoTexto = new JTextField();
        campoTexto.setBounds(120, 10, 200, 25);
        painelConteudo.add(campoTexto);
        campoTexto.setColumns(10);

        // Botão para remover caracteres especiais
        JButton botaoRemover = new JButton("Remover Caracteres Especiais");
        botaoRemover.setBounds(120, 50, 200, 30);
        botaoRemover.addActionListener(e -> removerCaracteresEspeciais());
        painelConteudo.add(botaoRemover);

        // Botão para verificar se o texto está vazio ou nulo
        JButton botaoVerificarVazio = new JButton("Verificar Vazio");
        botaoVerificarVazio.setBounds(120, 90, 200, 30);
        botaoVerificarVazio.addActionListener(e -> verificarVazio());
        painelConteudo.add(botaoVerificarVazio);

        // Botão para converter texto para maiúsculas
        JButton botaoConverterMaiusculas = new JButton("Converter para Maiúsculas");
        botaoConverterMaiusculas.setBounds(120, 130, 200, 30);
        botaoConverterMaiusculas.addActionListener(e -> converterParaMaiusculas());
        painelConteudo.add(botaoConverterMaiusculas);

        // Botão para verificar se o texto é um palíndromo
        JButton botaoVerificarPalindromo = new JButton("Verificar Palíndromo");
        botaoVerificarPalindromo.setBounds(120, 170, 200, 30);
        botaoVerificarPalindromo.addActionListener(e -> verificarPalindromo());
        painelConteudo.add(botaoVerificarPalindromo);

        // Rótulo de resultado
        rotuloResultado = new JLabel("");
        rotuloResultado.setFont(new Font("Arial", Font.BOLD, 14));
        rotuloResultado.setBounds(10, 220, 400, 25);
        painelConteudo.add(rotuloResultado);
    }

    /**
     * Remove caracteres especiais do texto e atualiza o rótulo de resultado.
     */
    private void removerCaracteresEspeciais() {
        String texto = campoTexto.getText().trim();
        if (texto.isEmpty()) {
            rotuloResultado.setText("Por favor, digite algum texto.");
            return;
        }
        // Remove caracteres especiais usando regex
        String textoLimpo = texto.replaceAll("[^a-zA-Z0-9 ]", "");
        rotuloResultado.setText("Texto sem caracteres especiais: " + textoLimpo);
    }

    /**
     * Verifica se o texto está vazio ou nulo e atualiza o rótulo de resultado.
     */
    private void verificarVazio() {
        String texto = campoTexto.getText();
        if (texto == null || texto.trim().isEmpty()) {
            rotuloResultado.setText("O texto está vazio ou é nulo.");
        } else {
            rotuloResultado.setText("O texto não está vazio.");
        }
    }

    /**
     * Converte o texto para maiúsculas e atualiza o rótulo de resultado.
     */
    private void converterParaMaiusculas() {
        String texto = campoTexto.getText().trim();
        if (texto.isEmpty()) {
            rotuloResultado.setText("Por favor, digite algum texto.");
            return;
        }
        String textoMaiusculas = texto.toUpperCase();
        rotuloResultado.setText("Texto em maiúsculas: " + textoMaiusculas);
    }

    /**
     * Verifica se o texto é um palíndromo e atualiza o rótulo de resultado.
     */
    private void verificarPalindromo() {
        String texto = campoTexto.getText().trim();
        if (texto.isEmpty()) {
            rotuloResultado.setText("Por favor, digite algum texto.");
            return;
        }
        String textoInvertido = new StringBuilder(texto).reverse().toString();
        if (texto.equalsIgnoreCase(textoInvertido)) {
            rotuloResultado.setText("O texto é um palíndromo.");
        } else {
            rotuloResultado.setText("O texto não é um palíndromo.");
        }
    }
}
