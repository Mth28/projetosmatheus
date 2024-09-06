package Pedidos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class EsfirrasDoces extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JComboBox<String> comboBoxTamanho;
    private JTextArea textAreaResumo;
    private JCheckBox[] chckbxSabores;
    private JRadioButton rbtnMassaTradicional, rbtnMassaIntegral;
    private JCheckBox chckbxExtraChocolate, chckbxAcucar;
    private JSlider sliderQuantidade;
    private JButton btnConfirmar, btnMais, btnMenos, btnVoltar;
    private JTextField txtNome, txtTelefone, txtEndereco;
    private JComboBox<String> comboBoxPagamento;

    // Preços das esfirras
    private static final double PRECO_PEQUENA = 10.0;
    private static final double PRECO_MEDIA = 15.0;
    private static final double PRECO_GRANDE = 20.0;

    // Preços dos sabores (exemplo)
    private static final double PRECO_SABOR_EXTRA = 2.0;

    // Opções de sabores
    private static final String[] SABORES = {
        "Chocolate", "Doce de Leite", "Coco", "Canela", "Frutas"
    };

    // Formas de pagamento
    private static final String[] FORMAS_PAGAMENTO = {"Crédito", "Débito", "Dinheiro"};

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                EsfirrasDoces frame = new EsfirrasDoces();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public EsfirrasDoces() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 984, 800); // Ajustado o tamanho da janela
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Painel para opções de sabores
        JPanel panelRecheios = new JPanel();
        panelRecheios.setBounds(5, 72, 300, 200); // Ajustado o tamanho do painel
        panelRecheios.setBorder(BorderFactory.createTitledBorder("Escolha os Sabores"));
        contentPane.add(panelRecheios);
        panelRecheios.setLayout(new GridLayout(SABORES.length, 1, 5, 5));

        chckbxSabores = new JCheckBox[SABORES.length];
        for (int i = 0; i < SABORES.length; i++) {
            chckbxSabores[i] = new JCheckBox(SABORES[i]);
            panelRecheios.add(chckbxSabores[i]);
        }

        // Painel para opções adicionais e informações do cliente
        JPanel panelExtras = new JPanel();
        panelExtras.setBounds(310, 72, 660, 400); // Ajustado o tamanho do painel
        panelExtras.setBorder(BorderFactory.createTitledBorder("Extras e Tamanho"));
        contentPane.add(panelExtras);
        panelExtras.setLayout(null);

        JLabel lblTamanho = new JLabel("Tamanho:");
        lblTamanho.setBounds(6, 16, 120, 30);
        panelExtras.add(lblTamanho);

        comboBoxTamanho = new JComboBox<>(new String[] {"Pequena", "Média", "Grande"});
        comboBoxTamanho.setBounds(130, 16, 150, 30);
        panelExtras.add(comboBoxTamanho);

        JLabel lblMassa = new JLabel("Tipo de Massa:");
        lblMassa.setBounds(6, 56, 120, 30);
        panelExtras.add(lblMassa);

        JPanel panelMassa = new JPanel();
        panelMassa.setBounds(130, 56, 250, 30);
        panelMassa.setLayout(new BoxLayout(panelMassa, BoxLayout.X_AXIS));
        rbtnMassaTradicional = new JRadioButton("Tradicional");
        rbtnMassaIntegral = new JRadioButton("Integral");
        ButtonGroup groupMassa = new ButtonGroup();
        groupMassa.add(rbtnMassaTradicional);
        groupMassa.add(rbtnMassaIntegral);
        panelMassa.add(rbtnMassaTradicional);
        panelMassa.add(rbtnMassaIntegral);
        panelExtras.add(panelMassa);

        JLabel lblQuantidade = new JLabel("Quantidade:");
        lblQuantidade.setBounds(6, 96, 120, 30);
        panelExtras.add(lblQuantidade);

        sliderQuantidade = new JSlider(1, 10, 1);
        sliderQuantidade.setBounds(130, 96, 250, 50);
        sliderQuantidade.setMajorTickSpacing(1);
        sliderQuantidade.setPaintTicks(true);
        sliderQuantidade.setPaintLabels(true);
        panelExtras.add(sliderQuantidade);

        // Botões para aumentar e diminuir a quantidade
        btnMenos = new JButton("-");
        btnMenos.setBounds(390, 96, 50, 30);
        btnMenos.addActionListener(e -> ajustarQuantidade(-1));
        panelExtras.add(btnMenos);

        btnMais = new JButton("+");
        btnMais.setBounds(450, 96, 50, 30);
        btnMais.addActionListener(e -> ajustarQuantidade(1));
        panelExtras.add(btnMais);

        chckbxExtraChocolate = new JCheckBox("Extra Chocolate");
        chckbxExtraChocolate.setBounds(6, 136, 200, 30);
        panelExtras.add(chckbxExtraChocolate);

        chckbxAcucar = new JCheckBox("Açúcar");
        chckbxAcucar.setBounds(230, 136, 200, 30);
        panelExtras.add(chckbxAcucar);

        // Campos de Cadastro do Cliente
        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(6, 176, 80, 30);
        panelExtras.add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(90, 176, 200, 30);
        panelExtras.add(txtNome);

        JLabel lblTelefone = new JLabel("Telefone:");
        lblTelefone.setBounds(6, 216, 80, 30);
        panelExtras.add(lblTelefone);

        txtTelefone = new JTextField();
        txtTelefone.setBounds(90, 216, 200, 30);
        panelExtras.add(txtTelefone);

        JLabel lblEndereco = new JLabel("Endereço:");
        lblEndereco.setBounds(6, 256, 80, 30);
        panelExtras.add(lblEndereco);

        txtEndereco = new JTextField();
        txtEndereco.setBounds(90, 256, 200, 30);
        panelExtras.add(txtEndereco);

        // Formas de pagamento
        JLabel lblPagamento = new JLabel("Forma de Pagamento:");
        lblPagamento.setBounds(6, 296, 150, 30);
        panelExtras.add(lblPagamento);

        comboBoxPagamento = new JComboBox<>(FORMAS_PAGAMENTO);
        comboBoxPagamento.setBounds(160, 296, 130, 30);
        panelExtras.add(comboBoxPagamento);

        btnConfirmar = new JButton("Confirmar Pedido");
        btnConfirmar.setBounds(6, 336, 150, 50);
        btnConfirmar.addActionListener(e -> mostrarResumo());
        panelExtras.add(btnConfirmar);

        // Botão Voltar
        btnVoltar = new JButton("Voltar ao Menu");
        btnVoltar.setBounds(180, 336, 150, 50);
        btnVoltar.addActionListener(e -> voltarAoMenu());
        panelExtras.add(btnVoltar);

        // Painel para resumo do pedido
        JPanel panelResumo = new JPanel();
        panelResumo.setBounds(5, 485, 963, 275); // Ajustado o tamanho do painel
        panelResumo.setBorder(BorderFactory.createTitledBorder("Resumo do Pedido"));
        contentPane.add(panelResumo);
        panelResumo.setLayout(new BorderLayout(10, 10));

        textAreaResumo = new JTextArea(10, 50);
        textAreaResumo.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textAreaResumo);
        panelResumo.add(scrollPane, BorderLayout.CENTER);
    }

    /**
     * Ajusta a quantidade de esfirras.
     */
    private void ajustarQuantidade(int ajuste) {
        int quantidadeAtual = sliderQuantidade.getValue();
        int novaQuantidade = quantidadeAtual + ajuste;
        if (novaQuantidade < 1) {
            novaQuantidade = 1;
        } else if (novaQuantidade > 10) {
            novaQuantidade = 10;
        }
        sliderQuantidade.setValue(novaQuantidade);
    }

    /**
     * Mostra um resumo do pedido na área de texto.
     */
    private void mostrarResumo() {
        String tamanho = (String) comboBoxTamanho.getSelectedItem();
        String massa = rbtnMassaTradicional.isSelected() ? "Tradicional" : "Integral";
        int quantidade = sliderQuantidade.getValue();

        // Calcular o preço da esfirra
        double preco = 0.0;
        switch (tamanho) {
            case "Pequena":
                preco = PRECO_PEQUENA;
                break;
            case "Média":
                preco = PRECO_MEDIA;
                break;
            case "Grande":
                preco = PRECO_GRANDE;
                break;
        }

        // Calcular o preço dos sabores adicionais
        double precoSabores = 0.0;
        for (JCheckBox sabor : chckbxSabores) {
            if (sabor.isSelected()) {
                precoSabores += PRECO_SABOR_EXTRA;
            }
        }

        // Calcular o preço total
        double precoTotal = (preco + precoSabores) * quantidade;

        // Adicionar detalhes de extras
        StringBuilder extras = new StringBuilder();
        if (chckbxExtraChocolate.isSelected()) extras.append("Extra Chocolate, ");
        if (chckbxAcucar.isSelected()) extras.append("Açúcar, ");

        if (extras.length() > 0) {
            extras.setLength(extras.length() - 2); // Remove a última vírgula e espaço
        } else {
            extras.append("Nenhum");
        }

        // Adicionar detalhes dos sabores
        StringBuilder sabores = new StringBuilder();
        for (JCheckBox sabor : chckbxSabores) {
            if (sabor.isSelected()) sabores.append(sabor.getText()).append(", ");
        }

        if (sabores.length() > 0) {
            sabores.setLength(sabores.length() - 2); // Remove a última vírgula e espaço
        } else {
            sabores.append("Nenhum");
        }

        // Informações do cliente e pagamento
        String nome = txtNome.getText();
        String telefone = txtTelefone.getText();
        String endereco = txtEndereco.getText();
        String formaPagamento = (String) comboBoxPagamento.getSelectedItem();

        // Criar resumo do pedido
        StringBuilder resumo = new StringBuilder();
        resumo.append("Tamanho: ").append(tamanho).append("\n");
        resumo.append("Tipo de Massa: ").append(massa).append("\n");
        resumo.append("Quantidade: ").append(quantidade).append("\n");
        resumo.append("Sabores: ").append(sabores.toString()).append("\n");
        resumo.append("Extras: ").append(extras.toString()).append("\n");
        resumo.append("Preço Total: R$ ").append(String.format("%.2f", precoTotal)).append("\n\n");
        resumo.append("Informações do Cliente:\n");
        resumo.append("Nome: ").append(nome).append("\n");
        resumo.append("Telefone: ").append(telefone).append("\n");
        resumo.append("Endereço: ").append(endereco).append("\n");
        resumo.append("Forma de Pagamento: ").append(formaPagamento).append("\n");

        textAreaResumo.setText(resumo.toString());
    }

    /**
     * Volta ao menu principal.
     */
    private void voltarAoMenu() {
        this.setVisible(false); // Oculta a janela atual
        Menu menuFrame = new Menu();
        menuFrame.setVisible(true); // Mostra a janela do menu
    }
}

