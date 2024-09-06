package CalculoDesconto;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

public class PreçoOriginalNegativo extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldValorOriginal;
    private JTextField textFieldPorcentagemDesconto;
    private JLabel lblFeedback;

    /**
     * Lança a aplicação.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PreçoOriginalNegativo frame = new PreçoOriginalNegativo();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Cria o frame.
     */
    public PreçoOriginalNegativo() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Rótulo para valor original
        JLabel lblValorOriginal = new JLabel("Valor Original:");
        lblValorOriginal.setBounds(10, 10, 150, 25);
        contentPane.add(lblValorOriginal);

        // Campo de texto para valor original
        textFieldValorOriginal = new JTextField();
        textFieldValorOriginal.setBounds(170, 10, 150, 25);
        contentPane.add(textFieldValorOriginal);
        textFieldValorOriginal.setColumns(10);

        // Rótulo para porcentagem de desconto
        JLabel lblPorcentagemDesconto = new JLabel("Porcentagem de Desconto:");
        lblPorcentagemDesconto.setBounds(10, 50, 200, 25);
        contentPane.add(lblPorcentagemDesconto);

        // Campo de texto para porcentagem de desconto
        textFieldPorcentagemDesconto = new JTextField();
        textFieldPorcentagemDesconto.setBounds(220, 50, 100, 25);
        contentPane.add(textFieldPorcentagemDesconto);
        textFieldPorcentagemDesconto.setColumns(10);

        // Botão para calcular desconto
        JButton btnCalcular = new JButton("Calcular Desconto");
        btnCalcular.setBounds(10, 90, 150, 25);
        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularDesconto();
            }
        });
        contentPane.add(btnCalcular);

        // Rótulo para mostrar o feedback
        lblFeedback = new JLabel("");
        lblFeedback.setBounds(10, 130, 400, 50);
        contentPane.add(lblFeedback);
    }

    /**
     * Calcula o valor com desconto e atualiza o feedback.
     */
    private void calcularDesconto() {
        try {
            // Obtém os valores dos campos de texto
            double valorOriginal = Double.parseDouble(textFieldValorOriginal.getText());
            double porcentagemDesconto = Double.parseDouble(textFieldPorcentagemDesconto.getText());

            // Verifica se o valor original é negativo
            if (valorOriginal < 0) {
                lblFeedback.setText("O valor original não pode ser negativo.");
                return;
            }

            // Verifica se a porcentagem de desconto é válida
            if (porcentagemDesconto < 0) {
                lblFeedback.setText("A porcentagem de desconto não pode ser negativa.");
                return;
            } else if (porcentagemDesconto > 100) {
                lblFeedback.setText("A porcentagem de desconto não pode ser maior que 100.");
                return;
            }

            // Calcula o valor final com desconto
            double valorDesconto = valorOriginal * (porcentagemDesconto / 100);
            double valorFinal = valorOriginal - valorDesconto;

            // Atualiza o rótulo com o valor final
            lblFeedback.setText(String.format("Valor com desconto: R$ %.2f", valorFinal));
        } catch (NumberFormatException e) {
            lblFeedback.setText("Por favor, insira valores válidos.");
        }
    }
}
