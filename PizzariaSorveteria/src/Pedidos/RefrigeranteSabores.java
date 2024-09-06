package Pedidos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class RefrigeranteSabores extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JComboBox<String> comboBoxTamanho;
    private JTextArea textAreaResumo;
    private JCheckBox chckbxCocaCola, chckbxPepsi, chckbxSprite, chckbxFanta, chckbxGuarana;
    private JCheckBox chckbxGelo, chckbxLimao, chckbxMenta;
    private JTextField txtQuantidade, txtNomeCliente, txtTelefone, txtEndereco;
    private JButton btnMais, btnMenos, btnConfirmar;
    private JRadioButton rbtnPagamentoDinheiro, rbtnPagamentoCartao;
    private ButtonGroup groupPagamento;
    private int quantidade = 1; // Valor inicial da quantidade

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                RefrigeranteSabores frame = new RefrigeranteSabores();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public RefrigeranteSabores() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 800); // Aumentado para acomodar os novos campos
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(10, 10));

        // Painel para informações do cliente
        JPanel panelCliente = new JPanel();
        panelCliente.setBorder(BorderFactory.createTitledBorder("Informações do Cliente"));
        contentPane.add(panelCliente, BorderLayout.NORTH);
        panelCliente.setLayout(new GridLayout(4, 2, 10, 10));

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

        // Painel para opções de sabores
        JPanel panelSabores = new JPanel();
        panelSabores.setBorder(BorderFactory.createTitledBorder("Escolha os Sabores"));
        contentPane.add(panelSabores, BorderLayout.WEST);
        panelSabores.setLayout(new GridLayout(0, 1, 5, 5));

        chckbxCocaCola = new JCheckBox("Coca-Cola");
        panelSabores.add(chckbxCocaCola);

        chckbxPepsi = new JCheckBox("Pepsi");
        panelSabores.add(chckbxPepsi);

        chckbxSprite = new JCheckBox("Sprite");
        panelSabores.add(chckbxSprite);

        chckbxFanta = new JCheckBox("Fanta");
        panelSabores.add(chckbxFanta);

        chckbxGuarana = new JCheckBox("Guaraná");
        panelSabores.add(chckbxGuarana);

        // Painel para opções adicionais
        JPanel panelExtras = new JPanel();
        panelExtras.setBorder(BorderFactory.createTitledBorder("Extras e Tamanho"));
        contentPane.add(panelExtras, BorderLayout.CENTER);
        panelExtras.setLayout(new GridLayout(6, 2, 10, 10));

        JLabel lblTamanho = new JLabel("Tamanho:");
        panelExtras.add(lblTamanho);

        comboBoxTamanho = new JComboBox<>(new String[]{"Pequeno", "Médio", "Grande"});
        panelExtras.add(comboBoxTamanho);

        JLabel lblQuantidade = new JLabel("Quantidade:");
        panelExtras.add(lblQuantidade);

        JPanel panelQuantidade = new JPanel();
        panelExtras.add(panelQuantidade);
        panelQuantidade.setLayout(new FlowLayout());

        txtQuantidade = new JTextField(String.valueOf(quantidade), 5);
        txtQuantidade.setEditable(false);
        panelQuantidade.add(txtQuantidade);

        btnMenos = new JButton("-");
        btnMenos.addActionListener(e -> alterarQuantidade(-1));
        panelQuantidade.add(btnMenos);

        btnMais = new JButton("+");
        btnMais.addActionListener(e -> alterarQuantidade(1));
        panelQuantidade.add(btnMais);

        chckbxGelo = new JCheckBox("Gelo");
        panelExtras.add(chckbxGelo);

        chckbxLimao = new JCheckBox("Limão");
        panelExtras.add(chckbxLimao);

        chckbxMenta = new JCheckBox("Menta");
        panelExtras.add(chckbxMenta);

        // Painel para opções de pagamento
        JPanel panelPagamento = new JPanel();
        panelPagamento.setBorder(BorderFactory.createTitledBorder("Forma de Pagamento"));
        contentPane.add(panelPagamento, BorderLayout.EAST);
        panelPagamento.setLayout(new GridLayout(3, 1, 10, 10));

        rbtnPagamentoDinheiro = new JRadioButton("Dinheiro");
        rbtnPagamentoCartao = new JRadioButton("Cartão");
        groupPagamento = new ButtonGroup();
        groupPagamento.add(rbtnPagamentoDinheiro);
        groupPagamento.add(rbtnPagamentoCartao);

        panelPagamento.add(rbtnPagamentoDinheiro);
        panelPagamento.add(rbtnPagamentoCartao);

        btnConfirmar = new JButton("Confirmar Pedido");
        btnConfirmar.addActionListener(e -> mostrarResumo());
        panelPagamento.add(btnConfirmar);

        // Painel para resumo do pedido
        JPanel panelResumo = new JPanel();
        panelResumo.setBorder(BorderFactory.createTitledBorder("Resumo do Pedido"));
        contentPane.add(panelResumo, BorderLayout.SOUTH);
        panelResumo.setLayout(new BorderLayout(10, 10));

        textAreaResumo = new JTextArea(10, 50);
        textAreaResumo.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textAreaResumo);
        panelResumo.add(scrollPane, BorderLayout.CENTER);
    }

    /**
     * Altera a quantidade de refrigerante.
     */
    private void alterarQuantidade(int incremento) {
        quantidade += incremento;
        if (quantidade < 1) quantidade = 1; // Garantir quantidade mínima
        txtQuantidade.setText(String.valueOf(quantidade));
    }

    /**
     * Mostra um resumo do pedido na área de texto.
     */
    private void mostrarResumo() {
        String nome = txtNomeCliente.getText();
        String telefone = txtTelefone.getText();
        String endereco = txtEndereco.getText();
        String tamanho = (String) comboBoxTamanho.getSelectedItem();
        int qtd = quantidade;

        String formaPagamento = rbtnPagamentoDinheiro.isSelected() ? "Dinheiro" : "Cartão";

        StringBuilder resumo = new StringBuilder();
        resumo.append("Nome: ").append(nome).append("\n");
        resumo.append("Telefone: ").append(telefone).append("\n");
        resumo.append("Endereço: ").append(endereco).append("\n");
        resumo.append("Tamanho: ").append(tamanho).append("\n");
        resumo.append("Quantidade: ").append(qtd).append("\n");
        resumo.append("Forma de Pagamento: ").append(formaPagamento).append("\n");
        resumo.append("Sabores: ");

        if (chckbxCocaCola.isSelected()) resumo.append("Coca-Cola, ");
        if (chckbxPepsi.isSelected()) resumo.append("Pepsi, ");
        if (chckbxSprite.isSelected()) resumo.append("Sprite, ");
        if (chckbxFanta.isSelected()) resumo.append("Fanta, ");
        if (chckbxGuarana.isSelected()) resumo.append("Guaraná, ");

        if (resumo.toString().endsWith(", ")) {
            resumo.setLength(resumo.length() - 2); // Remove a última vírgula e espaço
        }
        resumo.append("\n");

        if (chckbxGelo.isSelected()) resumo.append("Com Gelo\n");
        if (chckbxLimao.isSelected()) resumo.append("Com Limão\n");
        if (chckbxMenta.isSelected()) resumo.append("Com Menta\n");

        textAreaResumo.setText(resumo.toString());
    }
}

