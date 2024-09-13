package Produtos;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class CardapioDigital extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextArea orderSummary;
    private JTextField customerNameField;
    private JTextField customerPhoneField;
    private JTextField customerAddressField;
    private JLabel totalLabel;
    private double totalPrice = 0.0;

    // Menus
    private JComboBox<String> pizzaComboBox;
    private JComboBox<String> esfihaComboBox;
    private JComboBox<String> sorveteComboBox;
    private JComboBox<String> milkshakeComboBox;
    private JComboBox<String> pastelComboBox;
    private JComboBox<String> refrigeranteComboBox;
    private JComboBox<String> sucoComboBox;
    private JComboBox<String> aguaComboBox;

    private double[] pizzaPrices = {25.00, 22.00, 27.00, 24.00, 26.00, 29.00, 30.00, 20.00, 23.00, 28.00};
    private double[] esfihaPrices = {5.00, 5.50, 6.00, 5.75, 5.25, 5.80, 5.90, 6.00, 5.30, 5.10};
    private double[] sorvetePrices = {7.00, 8.00, 7.50, 8.50, 7.75, 8.20, 8.00, 7.25, 7.80, 8.10};
    private double[] milkshakePrices = {8.00, 8.50, 9.00, 8.75, 8.25, 9.20, 9.00, 8.50, 8.80, 9.10};
    private double[] pastelPrices = {4.00, 4.50, 4.75, 4.25, 4.80, 4.60, 4.70, 4.55, 4.90, 4.40};
    private double[] refrigerantePrices = {3.00, 3.50, 3.25, 3.75, 3.10, 3.60, 3.45, 3.20, 3.55, 3.70};
    private double[] sucoPrices = {4.00, 4.50, 4.25, 4.75, 4.60, 4.80, 4.35, 4.50, 4.40, 4.20};
    private double[] aguaPrices = {2.00, 2.50, 2.25, 2.75, 2.30, 2.60, 2.45, 2.20, 2.40, 2.55};

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                CardapioDigital frame = new CardapioDigital();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public CardapioDigital() {
        setTitle("Cardápio Digital");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1000, 700);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(10, 10));

        JPanel menuPanel = new JPanel();
        contentPane.add(menuPanel, BorderLayout.CENTER);
        menuPanel.setLayout(new GridLayout(0, 2, 15, 15)); // Ajuste de espaçamento

        // Adicionando ComboBoxes para cada categoria
        addComboBoxes(menuPanel);

        JPanel summaryPanel = new JPanel();
        contentPane.add(summaryPanel, BorderLayout.EAST);
        summaryPanel.setLayout(new BorderLayout(10, 10));

        // Área de resumo
        orderSummary = new JTextArea(20, 30); // Ajustado para 20 linhas e 30 colunas
        orderSummary.setFont(new Font("Monospaced", Font.PLAIN, 12));
        orderSummary.setEditable(false);
        summaryPanel.add(new JScrollPane(orderSummary), BorderLayout.CENTER);

        totalLabel = new JLabel("Total: R$0.00");
        totalLabel.setFont(new Font("Arial", Font.BOLD, 14));
        summaryPanel.add(totalLabel, BorderLayout.SOUTH);

        // Formulário de Nota Fiscal
        JPanel invoicePanel = new JPanel();
        invoicePanel.setLayout(new GridLayout(4, 2, 5, 5)); // Ajustado para 4 linhas

        invoicePanel.add(new JLabel("Nome:"));
        customerNameField = new JTextField();
        invoicePanel.add(customerNameField);

        invoicePanel.add(new JLabel("Telefone:"));
        customerPhoneField = new JTextField();
        invoicePanel.add(customerPhoneField);

        invoicePanel.add(new JLabel("Endereço:"));
        customerAddressField = new JTextField();
        invoicePanel.add(customerAddressField);

        summaryPanel.add(invoicePanel, BorderLayout.NORTH);

        JButton processPaymentButton = new JButton("Processar Pagamento");
        processPaymentButton.setPreferredSize(new Dimension(150, 30)); // Ajustado para 150x30
        processPaymentButton.addActionListener(e -> processPayment());
        summaryPanel.add(processPaymentButton, BorderLayout.SOUTH);
    }

    private void addComboBoxes(JPanel menuPanel) {
        // Pizza ComboBox
        pizzaComboBox = new JComboBox<>(new String[]{
            "Pizza de Calabresa", "Pizza Margherita", "Pizza Portuguesa", "Pizza Frango com Catupiry",
            "Pizza Quatro Queijos", "Pizza Pepperoni", "Pizza Napolitana", "Pizza Atum",
            "Pizza Vegetariana", "Pizza Marguerita Especial"
        });
        menuPanel.add(createPanelForComboBox(pizzaComboBox, pizzaPrices));

        // Esfiha ComboBox
        esfihaComboBox = new JComboBox<>(new String[]{
            "Esfiha de Carne", "Esfiha de Frango", "Esfiha de Queijo", "Esfiha de Escarola",
            "Esfiha de Calabresa", "Esfiha de Alho-Poró", "Esfiha de Cogumelos", "Esfiha de Milho",
            "Esfiha de Espinafre", "Esfiha de Frango com Catupiry"
        });
        menuPanel.add(createPanelForComboBox(esfihaComboBox, esfihaPrices));

        // Sorvete ComboBox
        sorveteComboBox = new JComboBox<>(new String[]{
            "Sorvete de Chocolate", "Sorvete de Baunilha", "Sorvete de Morango", "Sorvete de Coco",
            "Sorvete de Café", "Sorvete de Menta", "Sorvete de Limão", "Sorvete de Framboesa",
            "Sorvete de Caramelo", "Sorvete de Nutella"
        });
        menuPanel.add(createPanelForComboBox(sorveteComboBox, sorvetePrices));

        // Milkshake ComboBox
        milkshakeComboBox = new JComboBox<>(new String[]{
            "Milkshake de Morango", "Milkshake de Chocolate", "Milkshake de Baunilha", "Milkshake de Oreo",
            "Milkshake de Menta", "Milkshake de Café", "Milkshake de Caramelo", "Milkshake de Banana",
            "Milkshake de Nutella", "Milkshake de Framboesa"
        });
        menuPanel.add(createPanelForComboBox(milkshakeComboBox, milkshakePrices));

        // Pastel ComboBox
        pastelComboBox = new JComboBox<>(new String[]{
            "Pastel de Queijo", "Pastel de Carne", "Pastel de Frango", "Pastel de Calabresa",
            "Pastel de Palmito", "Pastel de Pizza", "Pastel de Camarão", "Pastel de Atum",
            "Pastel de Espinafre", "Pastel de Abóbora"
        });
        menuPanel.add(createPanelForComboBox(pastelComboBox, pastelPrices));

        // Refrigerante ComboBox
        refrigeranteComboBox = new JComboBox<>(new String[]{
            "Refrigerante Cola", "Refrigerante Laranja", "Refrigerante Limão", "Refrigerante Guaraná",
            "Refrigerante Uva", "Refrigerante Cerveja", "Refrigerante Água Tônica", "Refrigerante Sprite",
            "Refrigerante Schweppes", "Refrigerante Fanta"
        });
        menuPanel.add(createPanelForComboBox(refrigeranteComboBox, refrigerantePrices));

        // Suco ComboBox
        sucoComboBox = new JComboBox<>(new String[]{
            "Suco de Laranja", "Suco de Maçã", "Suco de Abacaxi", "Suco de Manga",
            "Suco de Morango", "Suco de Melancia", "Suco de Uva", "Suco de Maracujá",
            "Suco de Limão", "Suco de Cenoura"
        });
        menuPanel.add(createPanelForComboBox(sucoComboBox, sucoPrices));

        // Água ComboBox
        aguaComboBox = new JComboBox<>(new String[]{
            "Água Mineral", "Água com Gás", "Água de Coco", "Água de Cevada",
            "Água de Limão", "Água de Laranja", "Água de Frutas", "Água de Melancia",
            "Água com Sabor", "Água de Abacaxi"
        });
        menuPanel.add(createPanelForComboBox(aguaComboBox, aguaPrices));
    }

    private JPanel createPanelForComboBox(JComboBox<String> comboBox, double[] prices) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(5, 5));

        JLabel label = new JLabel("Selecione um item:");
        panel.add(label, BorderLayout.NORTH);

        comboBox.setPreferredSize(new Dimension(200, 30)); // Ajustado para 200x30
        panel.add(comboBox, BorderLayout.CENTER);

        JButton addButton = new JButton("Adicionar");
        addButton.setPreferredSize(new Dimension(100, 30)); // Ajustado para 100x30
        addButton.addActionListener(e -> addSelectedItem(comboBox, prices));
        panel.add(addButton, BorderLayout.SOUTH);

        return panel;
    }

    private void addSelectedItem(JComboBox<String> comboBox, double[] prices) {
        String selectedItem = (String) comboBox.getSelectedItem();
        int index = comboBox.getSelectedIndex();
        double price = prices[index];

        String quantityString = JOptionPane.showInputDialog(this, "Quantidade:", "Entrada de Quantidade", JOptionPane.QUESTION_MESSAGE);
        try {
            int quantity = Integer.parseInt(quantityString);
            if (quantity > 0) {
                double itemTotal = quantity * price;
                totalPrice += itemTotal;
                totalLabel.setText(String.format("Total: R$%.2f", totalPrice));
                orderSummary.append(selectedItem + " x" + quantity + " - R$" + itemTotal + "\n");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Quantidade inválida.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void processPayment() {
        String customerName = customerNameField.getText();
        String customerPhone = customerPhoneField.getText();
        String customerAddress = customerAddressField.getText();
        double paymentAmount = totalPrice;

        if (customerName.isEmpty() || customerPhone.isEmpty() || customerAddress.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos do cliente.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        orderSummary.append("\n--- Nota Fiscal ---\n");
        orderSummary.append("Cliente: " + customerName + "\n");
        orderSummary.append("Telefone: " + customerPhone + "\n");
        orderSummary.append("Endereço: " + customerAddress + "\n");
        orderSummary.append("Total a pagar: R$" + paymentAmount + "\n");
        orderSummary.append("Pagamento Processado.\n");

        // Reset para novos pedidos
        totalPrice = 0.0;
        totalLabel.setText("Total: R$0.00");
        customerNameField.setText("");
        customerPhoneField.setText("");
        customerAddressField.setText("");
        Venda recibo= new Venda(0, customerName, customerPhone, customerAddress, paymentAmount, orderSummary.getText(),"");
        VendaDAO banco= new VendaDAO();
        try {
			banco.adicionarVenda(recibo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
