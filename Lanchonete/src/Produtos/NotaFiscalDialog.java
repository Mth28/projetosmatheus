package Produtos;

import javax.swing.*;
import java.awt.*;

public class NotaFiscalDialog extends JDialog {

    private static final long serialVersionUID = 1L;

    public NotaFiscalDialog(Frame parent, Venda venda) {
        super(parent, "Nota Fiscal", true);
        setSize(400, 300);
        setLocationRelativeTo(parent);

        // Configurar o layout
        setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        textArea.setText(formatNotaFiscal(venda));

        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        JButton closeButton = new JButton("Fechar");
        closeButton.addActionListener(e -> dispose());
        add(closeButton, BorderLayout.SOUTH);
    }

    private String formatNotaFiscal(Venda venda) {
        StringBuilder sb = new StringBuilder();
        sb.append("Pizza de Calabresa x1 - R$25.0\n"); // Exemplo; adicione lógica para preencher com itens reais
        sb.append("Esfiha de Frango x4 - R$22.0\n"); // Exemplo; adicione lógica para preencher com itens reais
        sb.append("Sorvete de Chocolate x1 - R$7.0\n"); // Exemplo; adicione lógica para preencher com itens reais
        sb.append("Milkshake de Baunilha x1 - R$9.0\n"); // Exemplo; adicione lógica para preencher com itens reais
        sb.append("Pastel de Carne x2 - R$9.0\n"); // Exemplo; adicione lógica para preencher com itens reais
        sb.append("Refrigerante Cola x1 - R$3.0\n"); // Exemplo; adicione lógica para preencher com itens reais
        sb.append("\n--- Nota Fiscal ---\n");
        sb.append("Cliente: ").append(venda.getNomeCliente()).append("\n");
        sb.append("Telefone: ").append(venda.getTelefone()).append("\n");
        sb.append("Endereço: ").append(venda.getEndereco()).append("\n");
        sb.append("Total a pagar: R$").append(venda.getValorPedido()).append("\n");
        sb.append("Pagamento Processado.\n");
        return sb.toString();
    }
}
