package Pedidos;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;

public class RefrigeranteSabores extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JComboBox<String> comboBoxTamanho;
    private JTextArea textAreaResumo;
    private JCheckBox chckbxCocaCola, chckbxPepsi, chckbxSprite, chckbxFanta, chckbxGuarana;
    private JCheckBox chckbxGelo, chckbxLimao, chckbxMenta;
    private JTextField txtQuantidade, txtNomeCliente, txtTelefone, txtEndereco;
    private JButton btnMais, btnMenos, btnConfirmar, btnVoltar;
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
        setTitle("Sistema de Pedidos - Refrigerante Sabores"); // Adiciona o título
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 800); // Aumentado para acomodar os novos campos
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Painel para informações do cliente
        JPanel panelCliente = new JPanel();
        panelCliente.setBounds(5, 5, 774, 132);
        panelCliente.setBorder(BorderFactory.createTitledBorder("Informações do Cliente"));
        contentPane.add(panelCliente);
        panelCliente.setLayout(null);

        JLabel lblNomeCliente = new JLabel("Nome:");
        lblNomeCliente.setBounds(6, 16, 376, 20);
        panelCliente.add(lblNomeCliente);

        txtNomeCliente = new JTextField();
        txtNomeCliente.setBounds(392, 16, 376, 20);
        panelCliente.add(txtNomeCliente);

        JLabel lblTelefone = new JLabel("Telefone:");
        lblTelefone.setBounds(6, 46, 376, 20);
        panelCliente.add(lblTelefone);

        txtTelefone = new JTextField();
        txtTelefone.setBounds(392, 46, 376, 20);
        panelCliente.add(txtTelefone);

        JLabel lblEndereco = new JLabel("Endereço:");
        lblEndereco.setBounds(6, 76, 376, 20);
        panelCliente.add(lblEndereco);

        txtEndereco = new JTextField();
        txtEndereco.setBounds(392, 76, 376, 20);
        panelCliente.add(txtEndereco);

        // Painel para opções de sabores
        JPanel panelSabores = new JPanel();
        panelSabores.setBounds(5, 147, 160, 208);
        panelSabores.setBorder(BorderFactory.createTitledBorder("Escolha os Sabores"));
        contentPane.add(panelSabores);
        panelSabores.setLayout(null);

        chckbxCocaCola = new JCheckBox("Coca-Cola");
        chckbxCocaCola.setBounds(6, 18, 148, 40);
        panelSabores.add(chckbxCocaCola);

        chckbxPepsi = new JCheckBox("Pepsi");
        chckbxPepsi.setBounds(6, 61, 75, 40);
        panelSabores.add(chckbxPepsi);

        chckbxSprite = new JCheckBox("Sprite");
        chckbxSprite.setBounds(6, 104, 75, 31);
        panelSabores.add(chckbxSprite);

        chckbxFanta = new JCheckBox("Fanta");
        chckbxFanta.setBounds(6, 138, 75, 40);
        panelSabores.add(chckbxFanta);

        chckbxGuarana = new JCheckBox("Guaraná");
        chckbxGuarana.setBounds(6, 170, 75, 40);
        panelSabores.add(chckbxGuarana);

        // Painel para opções adicionais
        JPanel panelExtras = new JPanel();
        panelExtras.setBounds(193, 148, 417, 208);
        panelExtras.setBorder(BorderFactory.createTitledBorder("Extras e Tamanho"));
        contentPane.add(panelExtras);
        panelExtras.setLayout(null);

        JLabel lblTamanho = new JLabel("Tamanho:");
        lblTamanho.setBounds(6, 16, 186, 34);
        panelExtras.add(lblTamanho);

        comboBoxTamanho = new JComboBox<>(new String[]{"Pequeno", "Médio", "Grande"});
        comboBoxTamanho.setBounds(237, 16, 170, 34);
        panelExtras.add(comboBoxTamanho);

        JLabel lblQuantidade = new JLabel("Quantidade:");
        lblQuantidade.setBounds(6, 61, 259, 34);
        panelExtras.add(lblQuantidade);

        JPanel panelQuantidade = new JPanel();
        panelQuantidade.setBounds(237, 61, 170, 34);
        panelExtras.add(panelQuantidade);
        panelQuantidade.setLayout(new BoxLayout(panelQuantidade, BoxLayout.X_AXIS));

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
        chckbxGelo.setBounds(6, 113, 259, 23);
        panelExtras.add(chckbxGelo);

        chckbxLimao = new JCheckBox("Limão");
        chckbxLimao.setBounds(6, 176, 259, 23);
        panelExtras.add(chckbxLimao);

        chckbxMenta = new JCheckBox("Menta");
        chckbxMenta.setBounds(6, 139, 259, 34);
        panelExtras.add(chckbxMenta);

        // Painel para opções de pagamento
        JPanel panelPagamento = new JPanel();
        panelPagamento.setBounds(619, 147, 160, 226);
        panelPagamento.setBorder(BorderFactory.createTitledBorder("Forma de Pagamento"));
        contentPane.add(panelPagamento);

        rbtnPagamentoDinheiro = new JRadioButton("Dinheiro");
        rbtnPagamentoDinheiro.setBounds(6, 17, 115, 40);
        rbtnPagamentoCartao = new JRadioButton("Cartão");
        rbtnPagamentoCartao.setBounds(6, 60, 115, 58);
        groupPagamento = new ButtonGroup();
        groupPagamento.add(rbtnPagamentoDinheiro);
        groupPagamento.add(rbtnPagamentoCartao);
        panelPagamento.setLayout(null);

        panelPagamento.add(rbtnPagamentoDinheiro);
        panelPagamento.add(rbtnPagamentoCartao);

        btnConfirmar = new JButton("Confirmar Pedido");
        btnConfirmar.setBounds(6, 125, 144, 40);
        btnConfirmar.addActionListener(e -> mostrarResumo());
        panelPagamento.add(btnConfirmar);

        // Adiciona o botão Voltar ao Menu
        btnVoltar = new JButton("Voltar ao Menu");
        btnVoltar.setBounds(6, 176, 144, 40);
        btnVoltar.addActionListener(e -> voltarAoMenu());
        panelPagamento.add(btnVoltar);

        // Painel para resumo do pedido
        JPanel panelResumo = new JPanel();
        panelResumo.setBounds(5, 384, 774, 208);
        panelResumo.setBorder(BorderFactory.createTitledBorder("Resumo do Pedido"));
        contentPane.add(panelResumo);
        panelResumo.setLayout(null);

        textAreaResumo = new JTextArea(10, 50);
        textAreaResumo.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textAreaResumo);
        scrollPane.setBounds(6, 16, 762, 186);
        panelResumo.add(scrollPane);
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

    /**
     * Retorna ao menu principal.
     */
    private void voltarAoMenu() {
        this.dispose(); // Fecha a janela atual

        // Supondo que você tenha uma classe MenuPrincipal
        // MenuPrincipal menu = new MenuPrincipal();
        // menu.setVisible(true);

        // Para este exemplo, como MenuPrincipal não está implementado, 
        // substitua a linha acima pela linha de código para exibir o menu principal.
    }
}


