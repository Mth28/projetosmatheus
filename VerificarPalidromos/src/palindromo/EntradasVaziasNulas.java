package palindromo;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class EntradasVaziasNulas extends JFrame {

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
                    EntradasVaziasNulas quadro = new EntradasVaziasNulas();
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
    public EntradasVaziasNulas() {
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

        // Botão para verificar entrada
        JButton botaoVerificar = new JButton("Verificar Entrada");
        botaoVerificar.setBounds(120, 50, 200, 30);
        botaoVerificar.addActionListener(e -> verificarEntrada());
        painelConteudo.add(botaoVerificar);

        // Botão para remover espaços em branco
        JButton botaoRemoverEspacos = new JButton("Remover Espaços em Branco");
        botaoRemoverEspacos.setBounds(120, 90, 200, 30);
        botaoRemoverEspacos.addActionListener(e -> removerEspacos());
        painelConteudo.add(botaoRemoverEspacos);

        // Botão para converter texto para minúsculas
        JButton botaoConverterMinusculas = new JButton("Converter para Minúsculas");
        botaoConverterMinusculas.setBounds(120, 130, 200, 30);
        botaoConverterMinusculas.addActionListener(e -> converterParaMinusculas());
        painelConteudo.add(botaoConverterMinusculas);

        // Botão para contar caracteres
        JButton botaoContarCaracteres = new JButton("Contar Caracteres");
        botaoContarCaracteres.setBounds(120, 170, 200, 30);
        botaoContarCaracteres.addActionListener(e -> contarCaracteres());
        painelConteudo.add(botaoContarCaracteres);

        // Rótulo de resultado
        rotuloResultado = new JLabel("");
        rotuloResultado.setFont(new Font("Arial", Font.BOLD, 14));
        rotuloResultado.setBounds(10, 220, 400, 25);
        painelConteudo.add(rotuloResultado);
    }

    /**
     * Verifica se a entrada está vazia ou nula e atualiza o rótulo de resultado.
     */
    private void verificarEntrada() {
        String texto = campoTexto.getText();
        if (texto == null || texto.trim().isEmpty()) {
            rotuloResultado.setText("A entrada está vazia ou é nula.");
        } else {
            rotuloResultado.setText("A entrada não está vazia.");
        }
    }

    /**
     * Remove espaços em branco do início e do fim do texto e atualiza o rótulo de resultado.
     */
    private void removerEspacos() {
        String texto = campoTexto.getText();
        if (texto == null || texto.trim().isEmpty()) {
            rotuloResultado.setText("Por favor, digite algum texto.");
            return;
        }
        String textoSemEspacos = texto.trim();
        rotuloResultado.setText("Texto sem espaços em branco: " + textoSemEspacos);
    }

    /**
     * Converte o texto para minúsculas e atualiza o rótulo de resultado.
     */
    private void converterParaMinusculas() {
        String texto = campoTexto.getText().trim();
        if (texto.isEmpty()) {
            rotuloResultado.setText("Por favor, digite algum texto.");
            return;
        }
        String textoMinusculas = texto.toLowerCase();
        rotuloResultado.setText("Texto em minúsculas: " + textoMinusculas);
    }

    /**
     * Conta o número de caracteres no texto e atualiza o rótulo de resultado.
     */
    private void contarCaracteres() {
        String texto = campoTexto.getText();
        if (texto == null || texto.trim().isEmpty()) {
            rotuloResultado.setText("Por favor, digite algum texto.");
            return;
        }
        int numeroCaracteres = texto.length();
        rotuloResultado.setText("Número de caracteres: " + numeroCaracteres);
    }
}

