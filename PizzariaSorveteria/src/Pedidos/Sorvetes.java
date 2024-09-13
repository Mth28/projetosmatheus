package Pedidos;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.util.HashMap;
import java.util.Map;

public class Sorvetes extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtNome;
    private JTextField txtTelefone;
    private JTextField txtEmail;
    private JTextField txtEndereco;
    private JCheckBox[] checkBoxesSabores;
    private JComboBox<String> comboBoxPagamento;
    private JCheckBox chckbxNotaFiscal;
    private Map<String, Integer> saboresMap;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Sorvetes frame = new Sorvetes();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Sorvetes() {
        setTitle("Sorvetes e Sabores");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 650, 750); // Ajustado para acomodar o campo de nota fiscal
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Painel para os JCheckBox dos sabores
        JPanel panelSabores = new JPanel();
        panelSabores.setBounds(10, 29, 300, 532);
        contentPane.add(panelSabores);
        panelSabores.setLayout(null);

        // Criar e adicionar caixas de seleção para cada sabor
        String[] sabores = getSaboresArray();
        checkBoxesSabores = new JCheckBox[sabores.length];
        saboresMap = getSaboresMap();

        int yPosition = 10;
        for (int i = 0; i < sabores.length; i++) {
            JCheckBox checkBox = new JCheckBox(sabores[i] + " - " + getPreco(sabores[i]));
            checkBox.setBounds(10, yPosition, 280, 20);
            panelSabores.add(checkBox);
            checkBoxesSabores[i] = checkBox;
            yPosition += 25;
        }

        // ComboBox para seleção de forma de pagamento
        JLabel lblPagamento = new JLabel("Forma de Pagamento:");
        lblPagamento.setBounds(320, 29, 150, 20);
        contentPane.add(lblPagamento);

        comboBoxPagamento = new JComboBox<>(new String[]{"Dinheiro", "Cartão de Crédito", "Cartão de Débito", "Pix"});
        comboBoxPagamento.setBounds(320, 60, 200, 30);
        contentPane.add(comboBoxPagamento);

        // CheckBox para Nota Fiscal
        chckbxNotaFiscal = new JCheckBox("Desejo receber nota fiscal");
        chckbxNotaFiscal.setBounds(320, 100, 200, 30);
        contentPane.add(chckbxNotaFiscal);

        // Botão para mostrar pedido
        JButton btnMostrarPedido = new JButton("Mostrar Pedido");
        btnMostrarPedido.setBounds(320, 140, 150, 30);
        btnMostrarPedido.addActionListener(e -> mostrarPedido());
        contentPane.add(btnMostrarPedido);

        // Botão para voltar ao menu
        JButton btnVoltarMenu = new JButton("Voltar ao Menu");
        btnVoltarMenu.setBounds(320, 530, 150, 30);
        btnVoltarMenu.addActionListener(e -> {
            dispose(); // Fecha a janela atual
            // new Menu().setVisible(true); // Descomente isso se houver uma classe Menu
        });
        contentPane.add(btnVoltarMenu);

        // Formulário para cadastro de cliente
        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(320, 181, 100, 20);
        contentPane.add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(320, 211, 200, 20);
        contentPane.add(txtNome);

        JLabel lblTelefone = new JLabel("Telefone:");
        lblTelefone.setBounds(320, 242, 100, 20);
        contentPane.add(lblTelefone);

        txtTelefone = new JTextField();
        txtTelefone.setBounds(320, 272, 200, 20);
        contentPane.add(txtTelefone);

        JLabel lblEmail = new JLabel("E-mail:");
        lblEmail.setBounds(320, 303, 100, 20);
        contentPane.add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(320, 333, 200, 20);
        contentPane.add(txtEmail);

        JLabel lblEndereco = new JLabel("Endereço:");
        lblEndereco.setBounds(320, 364, 100, 20);
        contentPane.add(lblEndereco);

        txtEndereco = new JTextField();
        txtEndereco.setBounds(320, 394, 200, 20);
        contentPane.add(txtEndereco);

        JButton btnCadastrarCliente = new JButton("Cadastrar Cliente");
        btnCadastrarCliente.setBounds(320, 425, 200, 30);
        btnCadastrarCliente.addActionListener(e -> cadastrarCliente());
        contentPane.add(btnCadastrarCliente);
    }

    private String[] getSaboresArray() {
        return new String[]{
            "Chocolate", "Baunilha", "Morango", "Creme", "Café", "Caramelo", 
            "Menta", "Nutella", "Frutas Vermelhas", "Cookies", "Amendoim", 
            "Tiramisu", "Pêssego", "Framboesa", "Abacaxi", "Creme Brulée", 
            "Pistache", "Maracujá", "Goiaba", "Doce de Leite"
        };
    }

    private Map<String, Integer> getSaboresMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Chocolate", 10);
        map.put("Baunilha", 10);
        map.put("Morango", 11);
        map.put("Creme", 10);
        map.put("Café", 11);
        map.put("Caramelo", 11);
        map.put("Menta", 10);
        map.put("Nutella", 12);
        map.put("Frutas Vermelhas", 12);
        map.put("Cookies", 12);
        map.put("Amendoim", 11);
        map.put("Tiramisu", 12);
        map.put("Pêssego", 11);
        map.put("Framboesa", 12);
        map.put("Abacaxi", 11);
        map.put("Creme Brulée", 13);
        map.put("Pistache", 13);
        map.put("Maracujá", 12);
        map.put("Goiaba", 12);
        map.put("Doce de Leite", 12);
        return map;
    }

    private String getPreco(String sabor) {
        Integer preco = saboresMap.get(sabor);
        return preco != null ? "R$ " + preco + ",00" : "N/A";
    }

    private void mostrarPedido() {
        StringBuilder sb = new StringBuilder();
        sb.append("#### Pedido ####\n");
        sb.append("Sabores Selecionados:\n");

        double total = 0.0;
        
        for (JCheckBox checkBox : checkBoxesSabores) {
            if (checkBox.isSelected()) {
                String sabor = checkBox.getText().split(" - ")[0]; // Extrai o nome do sabor
                double preco = saboresMap.get(sabor);
                total += preco;
                sb.append(checkBox.getText()).append("\n");
            }
        }

        // Adicionar informações de pagamento
        String formaPagamento = (String) comboBoxPagamento.getSelectedItem();
        sb.append("Forma de Pagamento: ").append(formaPagamento).append("\n");
        sb.append("Preço Total: R$ ").append(String.format("%.2f", total)).append("\n");

        // Adicionar informações do cliente
        String nome = txtNome.getText();
        String telefone = txtTelefone.getText();
        String email = txtEmail.getText();
        String endereco = txtEndereco.getText();

        if (nome.isEmpty() || telefone.isEmpty() || email.isEmpty() || endereco.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos do cliente.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        sb.append("\nInformações do Cliente:\n");
        sb.append("Nome: ").append(nome).append("\n");
        sb.append("Telefone: ").append(telefone).append("\n");
        sb.append("E-mail: ").append(email).append("\n");
        sb.append("Endereço: ").append(endereco).append("\n");

        if (chckbxNotaFiscal.isSelected()) {
            sb.append("\nNota Fiscal:\n");
            sb.append("Nota fiscal emitida com sucesso.\n");
        }

        JOptionPane.showMessageDialog(this, sb.toString(), "Resumo do Pedido", JOptionPane.INFORMATION_MESSAGE);
    }

    private void cadastrarCliente() {
        String nome = txtNome.getText();
        String telefone = txtTelefone.getText();
        String email = txtEmail.getText();
        String endereco = txtEndereco.getText();

        if (nome.isEmpty() || telefone.isEmpty() || email.isEmpty() || endereco.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos do cliente.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Aqui você pode adicionar a lógica para salvar os dados do cliente
        JOptionPane.showMessageDialog(this, "Cliente cadastrado com sucesso!\nNome: " + nome + "\nTelefone: " + telefone + "\nE-mail: " + email + "\nEndereço: " + endereco, "Cadastro de Cliente", JOptionPane.INFORMATION_MESSAGE);
    }
}
