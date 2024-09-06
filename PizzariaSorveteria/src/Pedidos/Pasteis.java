package Pedidos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Pasteis extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtNomeCliente;
    private JTextField txtTelefone;
    private JTextField txtEndereco;
    private JTextField txtQuantidade;
    private JTextArea textAreaResumo;
    private JCheckBox[] saborCheckboxes;
    private JRadioButton rbtnPagamentoDinheiro, rbtnPagamentoCartao;
    private JButton btnConfirmar, btnMais, btnMenos, btnVoltar;

    // Preços dos pastéis por sabor
    private static final double PRECO_CARNE = 10.0;
    private static final double PRECO_FRANGO = 11.0;
    private static final double PRECO_QUEIJO = 9.0;
    private static final double PRECO_CALABRESA = 10.0;
    private static final double PRECO_PRESUNTO_QUEIJO = 10.0;
    private static final double PRECO_BACON_OVO = 11.0;
    private static final double PRECO_FRANGO_CATUPIRY = 12.0;
    private static final double PRECO_PIZZA = 11.0;
    private static final double PRECO_COGUMELOS = 10.0;
    private static final double PRECO_ESPINAFRE = 11.0;
    private static final double PRECO_CARNE_SECA = 12.0;
    private static final double PRECO_PRESUNTO = 10.0;
    private static final double PRECO_QUEIJO_GORGONZOLA = 11.0;
    private static final double PRECO_CALABRESA_QUEIJO = 11.0;
    private static final double PRECO_FRANGO_BACON = 12.0;
    private static final double PRECO_LINGUICA = 11.0;
    private static final double PRECO_TOMATE_MANJERICAO = 10.0;
    private static final double PRECO_RICOTA_ERVAS = 11.0;
    private static final double PRECO_VEGETARIANO = 11.0;
    private static final double PRECO_PRESUNTO_COGUMELOS = 11.0;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Pasteis frame = new Pasteis();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Pasteis() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 800); // Ajustado para acomodar o campo de endereço
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(10, 10));

        // Painel para informações do cliente
        JPanel panelInformacoes = new JPanel();
        panelInformacoes.setBorder(BorderFactory.createTitledBorder("Informações do Cliente"));
        contentPane.add(panelInformacoes, BorderLayout.NORTH);
        panelInformacoes.setLayout(new GridLayout(4, 2, 10, 10));

        JLabel lblNomeCliente = new JLabel("Nome do Cliente:");
        panelInformacoes.add(lblNomeCliente);

        txtNomeCliente = new JTextField();
        panelInformacoes.add(txtNomeCliente);

        JLabel lblTelefone = new JLabel("Telefone:");
        panelInformacoes.add(lblTelefone);

        txtTelefone = new JTextField();
        panelInformacoes.add(txtTelefone);

        JLabel lblEndereco = new JLabel("Endereço:");
        panelInformacoes.add(lblEndereco);

        txtEndereco = new JTextField();
        panelInformacoes.add(txtEndereco);

        JLabel lblQuantidade = new JLabel("Quantidade:");
        panelInformacoes.add(lblQuantidade);

        txtQuantidade = new JTextField("1");
        panelInformacoes.add(txtQuantidade);

        // Painel para opções de sabores
        JPanel panelSabores = new JPanel();
        panelSabores.setBorder(BorderFactory.createTitledBorder("Escolha os Sabores"));
        contentPane.add(panelSabores, BorderLayout.CENTER);
        panelSabores.setLayout(new GridLayout(8, 3, 5, 5));

        saborCheckboxes = new JCheckBox[] {
            new JCheckBox("Carne"),
            new JCheckBox("Frango"),
            new JCheckBox("Queijo"),
            new JCheckBox("Calabresa"),
            new JCheckBox("Presunto e Queijo"),
            new JCheckBox("Bacon e Ovo"),
            new JCheckBox("Frango com Catupiry"),
            new JCheckBox("Pizza"),
            new JCheckBox("Cogumelos"),
            new JCheckBox("Espinafre"),
            new JCheckBox("Carne Seca"),
            new JCheckBox("Presunto"),
            new JCheckBox("Queijo e Gorgonzola"),
            new JCheckBox("Calabresa com Queijo"),
            new JCheckBox("Frango com Bacon"),
            new JCheckBox("Linguiça"),
            new JCheckBox("Tomate e Manjericão"),
            new JCheckBox("Ricota e Ervas"),
            new JCheckBox("Vegetariano"),
            new JCheckBox("Presunto e Cogumelos")
        };

        // Adiciona todos os checkboxes ao painel de sabores
        for (JCheckBox checkBox : saborCheckboxes) {
            panelSabores.add(checkBox);
        }

        // Painel para formas de pagamento
        JPanel panelPagamento = new JPanel();
        panelPagamento.setBorder(BorderFactory.createTitledBorder("Forma de Pagamento"));
        contentPane.add(panelPagamento, BorderLayout.EAST);
        panelPagamento.setLayout(new GridLayout(2, 1, 10, 10));

        rbtnPagamentoDinheiro = new JRadioButton("Dinheiro");
        rbtnPagamentoCartao = new JRadioButton("Cartão");
        ButtonGroup groupPagamento = new ButtonGroup();
        groupPagamento.add(rbtnPagamentoDinheiro);
        groupPagamento.add(rbtnPagamentoCartao);
        panelPagamento.add(rbtnPagamentoDinheiro);
        panelPagamento.add(rbtnPagamentoCartao);

        // Botão para aumentar e diminuir a quantidade
        JPanel panelQuantidade = new JPanel();
        panelQuantidade.setBorder(BorderFactory.createTitledBorder("Quantidade"));
        contentPane.add(panelQuantidade, BorderLayout.SOUTH);
        panelQuantidade.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        btnMenos = new JButton("-");
        btnMenos.addActionListener(e -> ajustarQuantidade(-1));
        panelQuantidade.add(btnMenos);

        txtQuantidade.setColumns(3);
        panelQuantidade.add(txtQuantidade);

        btnMais = new JButton("+");
        btnMais.addActionListener(e -> ajustarQuantidade(1));
        panelQuantidade.add(btnMais);

        btnConfirmar = new JButton("Confirmar Pedido");
        btnConfirmar.addActionListener(e -> mostrarResumo());
        panelQuantidade.add(btnConfirmar);

        btnVoltar = new JButton("Voltar ao Menu");
        btnVoltar.addActionListener(e -> voltarAoMenu());
        panelQuantidade.add(btnVoltar);

        // Painel para resumo do pedido
        JPanel panelResumo = new JPanel();
        panelResumo.setBorder(BorderFactory.createTitledBorder("Resumo do Pedido"));
        contentPane.add(panelResumo, BorderLayout.WEST);
        panelResumo.setLayout(new BorderLayout(10, 10));

        textAreaResumo = new JTextArea(15, 30);
        textAreaResumo.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textAreaResumo);
        panelResumo.add(scrollPane, BorderLayout.CENTER);
    }

    private void ajustarQuantidade(int ajuste) {
        try {
            int quantidadeAtual = Integer.parseInt(txtQuantidade.getText());
            int novaQuantidade = quantidadeAtual + ajuste;
            if (novaQuantidade < 1) {
                novaQuantidade = 1;
            }
            txtQuantidade.setText(Integer.toString(novaQuantidade));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Quantidade inválida. Insira um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void mostrarResumo() {
        String nome = txtNomeCliente.getText();
        String telefone = txtTelefone.getText();
        String endereco = txtEndereco.getText();
        String quantidadeStr = txtQuantidade.getText();
        int quantidade;
        try {
            quantidade = Integer.parseInt(quantidadeStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Quantidade inválida. Insira um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Determinar a forma de pagamento
        String formaPagamento = rbtnPagamentoDinheiro.isSelected() ? "Dinheiro" : "Cartão";

        // Calcular o preço total
        double precoTotal = 0.0;
        for (JCheckBox checkBox : saborCheckboxes) {
            if (checkBox.isSelected()) {
                switch (checkBox.getText()) {
                    case "Carne":
                        precoTotal += PRECO_CARNE;
                        break;
                    case "Frango":
                        precoTotal += PRECO_FRANGO;
                        break;
                    case "Queijo":
                        precoTotal += PRECO_QUEIJO;
                        break;
                    case "Calabresa":
                        precoTotal += PRECO_CALABRESA;
                        break;
                    case "Presunto e Queijo":
                        precoTotal += PRECO_PRESUNTO_QUEIJO;
                        break;
                    case "Bacon e Ovo":
                        precoTotal += PRECO_BACON_OVO;
                        break;
                    case "Frango com Catupiry":
                        precoTotal += PRECO_FRANGO_CATUPIRY;
                        break;
                    case "Pizza":
                        precoTotal += PRECO_PIZZA;
                        break;
                    case "Cogumelos":
                        precoTotal += PRECO_COGUMELOS;
                        break;
                    case "Espinafre":
                        precoTotal += PRECO_ESPINAFRE;
                        break;
                    case "Carne Seca":
                        precoTotal += PRECO_CARNE_SECA;
                        break;
                    case "Presunto":
                        precoTotal += PRECO_PRESUNTO;
                        break;
                    case "Queijo e Gorgonzola":
                        precoTotal += PRECO_QUEIJO_GORGONZOLA;
                        break;
                    case "Calabresa com Queijo":
                        precoTotal += PRECO_CALABRESA_QUEIJO;
                        break;
                    case "Frango com Bacon":
                        precoTotal += PRECO_FRANGO_BACON;
                        break;
                    case "Linguiça":
                        precoTotal += PRECO_LINGUICA;
                        break;
                    case "Tomate e Manjericão":
                        precoTotal += PRECO_TOMATE_MANJERICAO;
                        break;
                    case "Ricota e Ervas":
                        precoTotal += PRECO_RICOTA_ERVAS;
                        break;
                    case "Vegetariano":
                        precoTotal += PRECO_VEGETARIANO;
                        break;
                    case "Presunto e Cogumelos":
                        precoTotal += PRECO_PRESUNTO_COGUMELOS;
                        break;
                }
            }
        }

        precoTotal *= quantidade;

        // Criar o resumo
        StringBuilder resumo = new StringBuilder();
        resumo.append("Nome: ").append(nome).append("\n");
        resumo.append("Telefone: ").append(telefone).append("\n");
        resumo.append("Endereço: ").append(endereco).append("\n");
        resumo.append("Quantidade: ").append(quantidade).append("\n");
        resumo.append("Forma de Pagamento: ").append(formaPagamento).append("\n");
        resumo.append("Sabores Selecionados: ");

        boolean algumSelecionado = false;

        for (JCheckBox checkBox : saborCheckboxes) {
            if (checkBox.isSelected()) {
                resumo.append(checkBox.getText()).append(", ");
                algumSelecionado = true;
            }
        }

        if (algumSelecionado) {
            if (resumo.toString().endsWith(", ")) {
                resumo.setLength(resumo.length() - 2); // Remove a última vírgula e espaço
            }
        } else {
            resumo.append("Nenhum sabor selecionado");
        }

        resumo.append("\n");
        resumo.append("Preço Total: R$ ").append(String.format("%.2f", precoTotal)).append("\n");

        textAreaResumo.setText(resumo.toString());
    }

    private void voltarAoMenu() {
        this.setVisible(false); // Oculta a janela atual
        Menu menuFrame = new Menu();
        menuFrame.setVisible(true); // Mostra a janela do menu
    }
}

