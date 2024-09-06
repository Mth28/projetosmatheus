package Pedidos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MilkShakeSabores extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JCheckBox[] checkBoxesSabores;
    private Map<String, Integer> saboresMap;
    private JTextField txtNomeCliente, txtTelefone, txtEndereco;
    private JRadioButton rbtnPagamentoDinheiro, rbtnPagamentoCartao;
    private ButtonGroup groupPagamento;
    private JTextArea textAreaResumo;
    private int totalPreco = 0;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                MilkShakeSabores frame = new MilkShakeSabores();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public MilkShakeSabores() {
        setTitle("Milk Shake e Sabores");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 700, 800);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Criar painel para os sabores com caixas de seleção
        JPanel panelSabores = new JPanel();
        panelSabores.setBounds(10, 10, 260, 500);
        contentPane.add(panelSabores);
        panelSabores.setLayout(new GridLayout(0, 1)); // Layout para uma coluna

        // Adicionar caixas de seleção para cada sabor
        String[] sabores = getSaboresArray();
        checkBoxesSabores = new JCheckBox[sabores.length];
        saboresMap = getSaboresMap();

        for (String sabor : sabores) {
            JCheckBox checkBox = new JCheckBox(sabor + " - " + getPreco(sabor));
            panelSabores.add(checkBox);
            checkBoxesSabores[panelSabores.getComponentCount() - 1] = checkBox;
        }

        // Painel para informações do cliente
        JPanel panelCliente = new JPanel();
        panelCliente.setBorder(BorderFactory.createTitledBorder("Informações do Cliente"));
        panelCliente.setBounds(280, 10, 390, 150);
        contentPane.add(panelCliente);
        panelCliente.setLayout(new GridLayout(3, 2, 10, 10));

        JLabel lblNomeCliente = new JLabel("Nome:");
        panelCliente.add(lblNomeCliente);

        txtNomeCliente = new JTextField();
        panelCliente.add(txtNomeCliente);

        JLabel lblTelefone = new JLabel("Telefone:");
        panelCliente.add(lblTelefone);

        txtTelefone = new JTextField();
        panelCliente.add(txtTelefone);

        JLabel lblEndereco = new JLabel("Endereço:");
        panelCliente.add(lblEndereco);

        txtEndereco = new JTextField();
        panelCliente.add(txtEndereco);

        // Painel para opções de pagamento
        JPanel panelPagamento = new JPanel();
        panelPagamento.setBorder(BorderFactory.createTitledBorder("Forma de Pagamento"));
        panelPagamento.setBounds(280, 170, 390, 100);
        contentPane.add(panelPagamento);
        panelPagamento.setLayout(new GridLayout(2, 1, 10, 10));

        rbtnPagamentoDinheiro = new JRadioButton("Dinheiro");
        rbtnPagamentoCartao = new JRadioButton("Cartão");
        groupPagamento = new ButtonGroup();
        groupPagamento.add(rbtnPagamentoDinheiro);
        groupPagamento.add(rbtnPagamentoCartao);

        panelPagamento.add(rbtnPagamentoDinheiro);
        panelPagamento.add(rbtnPagamentoCartao);

        // Botão para confirmar o pedido
        JButton btnConfirmar = new JButton("Confirmar Pedido");
        btnConfirmar.setBounds(280, 280, 200, 30);
        btnConfirmar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarResumo();
            }
        });
        contentPane.add(btnConfirmar);

        // Painel para resumo do pedido
        JPanel panelResumo = new JPanel();
        panelResumo.setBorder(BorderFactory.createTitledBorder("Resumo do Pedido"));
        panelResumo.setBounds(280, 320, 390, 200);
        contentPane.add(panelResumo);
        panelResumo.setLayout(new BorderLayout(10, 10));

        textAreaResumo = new JTextArea();
        textAreaResumo.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textAreaResumo);
        panelResumo.add(scrollPane, BorderLayout.CENTER);

        // Botão para voltar ao menu
        JButton btnVoltarMenu = new JButton("Voltar ao Menu");
        btnVoltarMenu.setBounds(10, 580, 150, 30);
        btnVoltarMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Fecha a janela atual
                new Menu().setVisible(true); // Abre o menu
            }
        });
        contentPane.add(btnVoltarMenu);
    }

    private String[] getSaboresArray() {
        return new String[]{
            "Chocolate - Chocolate ao leite", 
            "Morango - Morango fresco", 
            "Baunilha - Baunilha", 
            "Banana - Banana", 
            "Ovomaltine - Ovomaltine", 
            "Caramelo - Caramelo", 
            "Nutella - Nutella", 
            "Café - Café", 
            "Menta - Menta", 
            "Cookies - Cookies", 
            "Amendoim - Amendoim", 
            "Morango e Banana - Morango, banana", 
            "Chocolate Branco - Chocolate branco", 
            "Frutas Vermelhas - Frutas vermelhas", 
            "Paçoca - Paçoca", 
            "Tiramisu - Tiramisu", 
            "Abacaxi e Hortelã - Abacaxi, hortelã", 
            "Creme de Avelã - Creme de avelã", 
            "Framboesa e Chocolate - Framboesa, chocolate"
        };
    }

    private Map<String, Integer> getSaboresMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Chocolate - Chocolate ao leite", 12);
        map.put("Morango - Morango fresco", 13);
        map.put("Baunilha - Baunilha", 12);
        map.put("Banana - Banana", 13);
        map.put("Ovomaltine - Ovomaltine", 14);
        map.put("Caramelo - Caramelo", 13);
        map.put("Nutella - Nutella", 15);
        map.put("Café - Café", 14);
        map.put("Menta - Menta", 12);
        map.put("Cookies - Cookies", 15);
        map.put("Amendoim - Amendoim", 13);
        map.put("Morango e Banana - Morango, banana", 14);
        map.put("Chocolate Branco - Chocolate branco", 14);
        map.put("Frutas Vermelhas - Frutas vermelhas", 15);
        map.put("Paçoca - Paçoca", 14);
        map.put("Tiramisu - Tiramisu", 15);
        map.put("Abacaxi e Hortelã - Abacaxi, hortelã", 14);
        map.put("Creme de Avelã - Creme de avelã", 15);
        map.put("Framboesa e Chocolate - Framboesa, chocolate", 15);
        return map;
    }

    private String getPreco(String sabor) {
        Integer preco = saboresMap.get(sabor);
        return preco != null ? "R$ " + preco + ",00" : "N/A";
    }

    private void mostrarResumo() {
        String nome = txtNomeCliente.getText();
        String telefone = txtTelefone.getText();
        String endereco = txtEndereco.getText();
        String formaPagamento = rbtnPagamentoDinheiro.isSelected() ? "Dinheiro" : "Cartão";

        totalPreco = 0;
        StringBuilder resumo = new StringBuilder();
        resumo.append("Nome: ").append(nome).append("\n");
        resumo.append("Telefone: ").append(telefone).append("\n");
        resumo.append("Endereço: ").append(endereco).append("\n");
        resumo.append("Forma de Pagamento: ").append(formaPagamento).append("\n");
        resumo.append("Sabores Selecionados:\n");

        for (JCheckBox checkBox : checkBoxesSabores) {
            if (checkBox.isSelected()) {
                String sabor = checkBox.getText().split(" - ")[0];
                resumo.append(sabor).append("\n");
                totalPreco += saboresMap.get(sabor);
            }
        }

        resumo.append("Total: R$ ").append(totalPreco).append(",00");

        textAreaResumo.setText(resumo.toString());
    }
}



