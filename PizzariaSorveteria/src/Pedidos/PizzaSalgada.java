package Pedidos;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class PizzaSalgada extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JComboBox<String> comboBoxPizza1;
    private JComboBox<String> comboBoxPizza2;
    private JTextArea textAreaResumo;
    private JTextField txtPreco;
    private JTextField txtQuantidade;
    private JTextField txtNomeCliente;
    private JTextField txtEndereco;
    private JTextField txtTelefone;
    private JRadioButton rdbtnCredito, rdbtnDebito, rdbtnDinheiro;
    private ButtonGroup bgPagamento;
    private int quantidade = 1;

    private static final double[] PRECO_PIZZAS = {
        30.00, 32.00, 35.00, 33.00, 34.00, 34.00, 34.00, 32.00, 32.00, 30.00, 34.00, 33.00,
        35.00, 31.00, 34.00, 36.00, 33.00, 35.00, 34.00, 36.00
    };

    private static final String[] PIZZAS = {
        "Margherita", "Pepperoni", "Quatro Queijos", "Calabresa", "Frango com Catupiry", "Portuguesa",
        "Hawaiana", "Vegetariana", "Peperoni", "Marinara", "Bacon com Cebola", "Diavola",
        "Frango e Bacon", "Alho e Óleo", "Pesto com Tomate Seco", "Lasanha", "Mexicana",
        "Carbonara", "Rúcula com Tomate Seco", "Gorgonzola com Pera"
    };

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                PizzaSalgada frame = new PizzaSalgada();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public PizzaSalgada() {
        setTitle("Pedido de Pizza Salgada");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 750, 600); // Ajuste do tamanho para acomodar os componentes
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        addPizzaSelectionPanel();
        addQuantityPanel();
        addCustomerPanel();
        addPaymentPanel();
        addSummaryPanel();
        addActionPanel();
    }

    private void addPizzaSelectionPanel() {
        JPanel panelPizza = new JPanel();
        panelPizza.setBounds(5, 5, 720, 100);
        panelPizza.setBorder(new TitledBorder(new EmptyBorder(5, 5, 5, 5), "Selecione as Pizzas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        contentPane.add(panelPizza);
        panelPizza.setLayout(new GridLayout(1, 2, 10, 10));

        JPanel panelPizza1 = new JPanel();
        panelPizza1.setLayout(new BorderLayout());
        comboBoxPizza1 = new JComboBox<>(PIZZAS);
        comboBoxPizza1.addActionListener(e -> atualizarPreco());
        panelPizza1.add(new JLabel("Pizza 1:"), BorderLayout.NORTH);
        panelPizza1.add(comboBoxPizza1, BorderLayout.CENTER);

        JPanel panelPizza2 = new JPanel();
        panelPizza2.setLayout(new BorderLayout());
        comboBoxPizza2 = new JComboBox<>(PIZZAS);
        comboBoxPizza2.addActionListener(e -> atualizarPreco());
        panelPizza2.add(new JLabel("Pizza 2:"), BorderLayout.NORTH);
        panelPizza2.add(comboBoxPizza2, BorderLayout.CENTER);

        panelPizza.add(panelPizza1);
        panelPizza.add(panelPizza2);
    }

    private void addQuantityPanel() {
        JPanel panelQuantidade = new JPanel();
        panelQuantidade.setBounds(5, 115, 720, 75);
        panelQuantidade.setBorder(new TitledBorder(new EmptyBorder(5, 5, 5, 5), "Quantidade", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        contentPane.add(panelQuantidade);
        panelQuantidade.setLayout(new FlowLayout());

        JButton btnMenos = new JButton("-");
        btnMenos.addActionListener(e -> ajustarQuantidade(-1));
        panelQuantidade.add(btnMenos);

        txtQuantidade = new JTextField(String.valueOf(quantidade), 3);
        txtQuantidade.setEditable(false);
        panelQuantidade.add(txtQuantidade);

        JButton btnMais = new JButton("+");
        btnMais.addActionListener(e -> ajustarQuantidade(1));
        panelQuantidade.add(btnMais);
    }

    private void addCustomerPanel() {
        JPanel panelCliente = new JPanel();
        panelCliente.setBounds(5, 195, 720, 100);
        panelCliente.setBorder(new TitledBorder(new EmptyBorder(5, 5, 5, 5), "Cadastro do Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        contentPane.add(panelCliente);
        panelCliente.setLayout(new GridLayout(3, 2, 10, 10));

        JLabel lblNomeCliente = new JLabel("Nome:");
        txtNomeCliente = new JTextField();
        JLabel lblEndereco = new JLabel("Endereço:");
        txtEndereco = new JTextField();
        JLabel lblTelefone = new JLabel("Telefone:");
        txtTelefone = new JTextField();

        panelCliente.add(lblNomeCliente);
        panelCliente.add(txtNomeCliente);
        panelCliente.add(lblEndereco);
        panelCliente.add(txtEndereco);
        panelCliente.add(lblTelefone);
        panelCliente.add(txtTelefone);
    }

    private void addPaymentPanel() {
        JPanel panelPagamento = new JPanel();
        panelPagamento.setBounds(5, 300, 720, 90);
        panelPagamento.setBorder(new TitledBorder(new EmptyBorder(5, 5, 5, 5), "Método de Pagamento", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        contentPane.add(panelPagamento);
        panelPagamento.setLayout(new GridLayout(4, 1));

        JLabel lblPagamento = new JLabel("Selecione o método de pagamento:");
        rdbtnCredito = new JRadioButton("Crédito");
        rdbtnDebito = new JRadioButton("Débito");
        rdbtnDinheiro = new JRadioButton("Dinheiro");
        bgPagamento = new ButtonGroup();
        bgPagamento.add(rdbtnCredito);
        bgPagamento.add(rdbtnDebito);
        bgPagamento.add(rdbtnDinheiro);

        panelPagamento.add(lblPagamento);
        panelPagamento.add(rdbtnCredito);
        panelPagamento.add(rdbtnDebito);
        panelPagamento.add(rdbtnDinheiro);
    }

    private void addSummaryPanel() {
        JPanel panelResumo = new JPanel();
        panelResumo.setBounds(5, 395, 720, 60);
        panelResumo.setBorder(new TitledBorder(new EmptyBorder(5, 5, 5, 5), "Resumo do Pedido", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        contentPane.add(panelResumo);
        panelResumo.setLayout(new BorderLayout(10, 10));

        textAreaResumo = new JTextArea(3, 40);
        textAreaResumo.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textAreaResumo);
        panelResumo.add(scrollPane, BorderLayout.CENTER);

        JPanel panelPreco = new JPanel();
        panelPreco.add(new JLabel("Preço Total:"));
        txtPreco = new JTextField(10);
        txtPreco.setEditable(false);
        panelPreco.add(txtPreco);
        panelResumo.add(panelPreco, BorderLayout.NORTH);
    }

    private void addActionPanel() {
        JPanel panelAcoes = new JPanel();
        panelAcoes.setBounds(5, 460, 720, 60);
        panelAcoes.setBorder(new TitledBorder(new EmptyBorder(5, 5, 5, 5), "Ações", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        contentPane.add(panelAcoes);
        panelAcoes.setLayout(new GridLayout(1, 4, 10, 10));

        JButton btnConfirmar = new JButton("Confirmar Pedido");
        btnConfirmar.addActionListener(e -> processarPedido());
        panelAcoes.add(btnConfirmar);

        JButton btnLimpar = new JButton("Limpar");
        btnLimpar.addActionListener(e -> limparCampos());
        panelAcoes.add(btnLimpar);

        JButton btnRetornarMenuPrincipal = new JButton("Retornar ao Menu Principal");
        btnRetornarMenuPrincipal.addActionListener(e -> retornarMenu());
        panelAcoes.add(btnRetornarMenuPrincipal);

        // Botão de Carrinho removido
    }

    private void atualizarPreco() {
        int index1 = comboBoxPizza1.getSelectedIndex();
        int index2 = comboBoxPizza2.getSelectedIndex();
        double precoUnitario1 = PRECO_PIZZAS[index1];
        double precoUnitario2 = PRECO_PIZZAS[index2];
        int quantidade = Integer.parseInt(txtQuantidade.getText());
        double precoTotal = (precoUnitario1 + precoUnitario2) * quantidade;
        txtPreco.setText(String.format("R$ %.2f", precoTotal));
    }

    private void ajustarQuantidade(int ajuste) {
        quantidade += ajuste;
        if (quantidade < 1) quantidade = 1; // Garantir que a quantidade não seja menor que 1
        txtQuantidade.setText(String.valueOf(quantidade));
        atualizarPreco();
    }

    private void processarPedido() {
        if (txtNomeCliente.getText().isEmpty() || txtEndereco.getText().isEmpty() || txtTelefone.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos do cliente.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!rdbtnCredito.isSelected() && !rdbtnDebito.isSelected() && !rdbtnDinheiro.isSelected()) {
            JOptionPane.showMessageDialog(this, "Por favor, selecione um método de pagamento.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        atualizarPreco();
        String pizza1 = (String) comboBoxPizza1.getSelectedItem();
        String pizza2 = (String) comboBoxPizza2.getSelectedItem();
        String preco = txtPreco.getText();
        int quantidade = Integer.parseInt(txtQuantidade.getText());
        String nomeCliente = txtNomeCliente.getText();
        String endereco = txtEndereco.getText();
        String telefone = txtTelefone.getText();
        String metodoPagamento = getMetodoPagamento();

        String mensagem = String.format("Resumo do Pedido:\n\nCliente: %s\nEndereço: %s\nTelefone: %s\nMétodo de Pagamento: %s\nPizzas: %s e %s\nQuantidade: %d\nPreço Total: %s",
                nomeCliente, endereco, telefone, metodoPagamento, pizza1, pizza2, quantidade, preco);

        JOptionPane.showMessageDialog(this, mensagem, "Resumo do Pedido", JOptionPane.INFORMATION_MESSAGE);
        limparCampos();
    }

    private String getMetodoPagamento() {
        if (rdbtnCredito.isSelected()) return "Crédito";
        if (rdbtnDebito.isSelected()) return "Débito";
        if (rdbtnDinheiro.isSelected()) return "Dinheiro";
        return "Não especificado";
    }

    private void limparCampos() {
        comboBoxPizza1.setSelectedIndex(0);
        comboBoxPizza2.setSelectedIndex(0);
        txtPreco.setText("");
        txtQuantidade.setText("1");
        txtNomeCliente.setText("");
        txtEndereco.setText("");
        txtTelefone.setText("");
        bgPagamento.clearSelection();
    }

    private void retornarMenu() {
        dispose();
        new Menu().setVisible(true);
    }
}

