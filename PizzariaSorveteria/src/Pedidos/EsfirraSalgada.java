package Pedidos;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class EsfirraSalgada extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextArea summaryArea;
    private JComboBox<String> flavorComboBox;
    private JSpinner quantitySpinner;
    private JComboBox<String> paymentComboBox;
    private JTextField nameField;
    private JTextField phoneField;
    private JTextField addressField;
    private JButton submitButton;
    private JButton backButton;

    private static final String[] FLAVORS = {
        "Carne - Carne moída, cebola, temperos: R$ 15,00",
        "Frango - Frango desfiado, catupiry: R$ 16,00",
        "Queijo - Queijo muçarela, parmesão: R$ 14,00",
        "Calabresa - Calabresa, cebola, azeitona: R$ 15,50",
        "Presunto e Queijo - Presunto, queijo muçarela: R$ 14,50",
        "Brócolis com Bacon - Brócolis, bacon crocante: R$ 16,50",
        "Pizza - Molho de tomate, queijo muçarela, orégano: R$ 17,00",
        "Lombo Canadense - Lombo canadense, queijo: R$ 17,50",
        "Alho e Óleo - Alho, óleo, queijo muçarela: R$ 13,50",
        "Azeitona e Queijo - Azeitona, queijo muçarela: R$ 14,00",
        "Milho e Bacon - Milho, bacon: R$ 15,00",
        "Mussarela e Tomate Seco - Mussarela, tomate seco: R$ 16,00",
        "Picanha - Picanha, cebola: R$ 18,00",
        "Vegetariana - Legumes variados: R$ 15,00",
        "Palmito - Palmito, queijo muçarela: R$ 16,50",
        "Frango com Catupiry - Frango, catupiry: R$ 16,50",
        "Cordeiro - Cordeiro, especiarias: R$ 17,00",
        "Ostras - Ostras, molho especial: R$ 20,00",
        "Atum - Atum, cebola roxa: R$ 18,00",
        "Salsicha - Salsicha, queijo cheddar: R$ 14,50"
    };

    private static final String[] PAYMENT_METHODS = {
        "Crédito",
        "Débito",
        "Dinheiro"
    };

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                EsfirraSalgada frame = new EsfirraSalgada();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public EsfirraSalgada() {
        setTitle("Pedido de Esfirra Salgada");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Flavor Selection
        gbc.gridx = 0;
        gbc.gridy = 0;
        contentPane.add(new JLabel("Selecione o sabor:"), gbc);

        flavorComboBox = new JComboBox<>(FLAVORS);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        contentPane.add(flavorComboBox, gbc);

        // Quantity
        gbc.gridx = 0;
        gbc.gridy = 1;
        contentPane.add(new JLabel("Quantidade:"), gbc);

        JPanel quantityPanel = new JPanel();
        quantityPanel.setLayout(new FlowLayout());

        JButton minusButton = new JButton("-");
        JButton plusButton = new JButton("+");
        quantitySpinner = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
        
        minusButton.addActionListener(e -> {
            int currentValue = (Integer) quantitySpinner.getValue();
            if (currentValue > 1) {
                quantitySpinner.setValue(currentValue - 1);
            }
        });
        
        plusButton.addActionListener(e -> {
            int currentValue = (Integer) quantitySpinner.getValue();
            quantitySpinner.setValue(currentValue + 1);
        });

        quantityPanel.add(minusButton);
        quantityPanel.add(quantitySpinner);
        quantityPanel.add(plusButton);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        contentPane.add(quantityPanel, gbc);

        // Payment Method
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        contentPane.add(new JLabel("Forma de Pagamento:"), gbc);

        paymentComboBox = new JComboBox<>(PAYMENT_METHODS);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        contentPane.add(paymentComboBox, gbc);

        // Customer Details
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        contentPane.add(new JLabel("Nome:"), gbc);

        nameField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        contentPane.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        contentPane.add(new JLabel("Telefone:"), gbc);

        phoneField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        contentPane.add(phoneField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        contentPane.add(new JLabel("Endereço:"), gbc);

        addressField = new JTextField(30);
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        contentPane.add(addressField, gbc);

        // Summary Area
        summaryArea = new JTextArea(5, 30);
        summaryArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(summaryArea);
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 3;
        contentPane.add(scrollPane, gbc);

        // Submit and Back Buttons
        submitButton = new JButton("Confirmar Pedido");
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        contentPane.add(submitButton, gbc);

        backButton = new JButton("Voltar ao Menu");
        gbc.gridx = 2;
        gbc.gridy = 7;
        contentPane.add(backButton, gbc);

        // Action Listeners
        submitButton.addActionListener(e -> submitOrder());
        backButton.addActionListener(e -> returnToMenu());
    }

    private void submitOrder() {
        String selectedFlavor = (String) flavorComboBox.getSelectedItem();
        int quantity = (Integer) quantitySpinner.getValue();
        String paymentMethod = (String) paymentComboBox.getSelectedItem();
        String name = nameField.getText();
        String phone = phoneField.getText();
        String address = addressField.getText();

        double total = calculateTotal(selectedFlavor, quantity);

        String summary = String.format("Resumo do Pedido:\n\n" +
            "Sabor: %s\n" +
            "Quantidade: %d\n" +
            "Forma de Pagamento: %s\n" +
            "Total: R$ %.2f\n\n" +
            "Dados do Cliente:\n" +
            "Nome: %s\n" +
            "Telefone: %s\n" +
            "Endereço de Entrega: %s\n",
            selectedFlavor, quantity, paymentMethod, total, name, phone, address
        );

        summaryArea.setText(summary);
    }

    private double calculateTotal(String flavor, int quantity) {
        double price = 0.0;
        String[] parts = flavor.split(": R$ ");
        if (parts.length > 1) {
            String priceStr = parts[1].replace(" ", "").replace(",", ".");
            try {
                price = Double.parseDouble(priceStr);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return price * quantity;
    }

    private void returnToMenu() {
        // Aqui você idealmente retornaria para a tela do menu
        // Por enquanto, apenas fecha a janela atual
        this.dispose();
        Menu.main(new String[]{});
    }
}

