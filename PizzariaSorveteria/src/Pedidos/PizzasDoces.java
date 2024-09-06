package Pedidos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class PizzasDoces extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JComboBox<String> comboBoxTamanho;
    private JTextArea textAreaResumo;
    private JCheckBox[] chckbxRecheios;
    private JButton btnConfirmar;
    private JButton btnVoltar;
    private JTextField txtQuantidade;
    private JButton btnMais;
    private JButton btnMenos;
    private int quantidade = 1;

    // Preços das pizzas e recheios adicionais
    private static final double PRECO_PEQUENA = 30.0;
    private static final double PRECO_MEDIA = 35.0;
    private static final double PRECO_GRANDE = 40.0;
    private static final double PRECO_RECHEIO_ADICIONAL = 5.0;

    private static final String[] TAMANHOS = {"Pequena", "Média", "Grande"};
    private static final String[] RECHEIOS = {
        "Nutella", "Frutas (Morango, Banana)", "Granola", "Leite Condensado", "Chocolate",
        "Banana e Canela", "Marmelada e Queijo", "Marshmallow e Chocolate", "Caramelo e Nozes",
        "Pêssego e Creme", "Frutas Vermelhas", "Chocolate Branco e Framboesas", "Doce de Leite e Castanhas",
        "Pêra e Gorgonzola", "Tiramisu", "Pistache e Mel", "Abacaxi e Hortelã",
        "Creme de Avelã e Morangos", "Maçã e Canela"
    };
    
    private static final String[] FORMAS_PAGAMENTO = {"Crédito", "Débito", "Dinheiro"};
    
    private JTextField txtNome;
    private JTextField txtTelefone;
    private JTextField txtEndereco;
    private JComboBox<String> comboBoxPagamento;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                PizzasDoces frame = new PizzasDoces();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public PizzasDoces() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 777);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Painel para opções adicionais
        JPanel panelExtras = new JPanel();
        panelExtras.setBounds(15, 11, 747, 298);
        panelExtras.setBorder(BorderFactory.createTitledBorder("Extras e Tamanho"));
        contentPane.add(panelExtras);
        panelExtras.setLayout(null);

        JLabel lblTamanho = new JLabel("Tamanho:");
        lblTamanho.setBounds(6, 28, 100, 25);
        panelExtras.add(lblTamanho);

        comboBoxTamanho = new JComboBox<>(TAMANHOS);
        comboBoxTamanho.setBounds(110, 28, 150, 25);
        panelExtras.add(comboBoxTamanho);

        // Adicionar painel para quantidade
        JPanel panelQuantidade = new JPanel();
        panelQuantidade.setBounds(6, 60, 200, 75);
        panelQuantidade.setBorder(BorderFactory.createTitledBorder("Quantidade"));
        panelExtras.add(panelQuantidade);
        panelQuantidade.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        btnMenos = new JButton("-");
        btnMenos.addActionListener(e -> ajustarQuantidade(-1));
        panelQuantidade.add(btnMenos);

        txtQuantidade = new JTextField(String.valueOf(quantidade), 3);
        txtQuantidade.setHorizontalAlignment(JTextField.CENTER);
        txtQuantidade.setEditable(false);
        panelQuantidade.add(txtQuantidade);

        btnMais = new JButton("+");
        btnMais.addActionListener(e -> ajustarQuantidade(1));
        panelQuantidade.add(btnMais);

        // Painel para opções de recheios
        JPanel panelRecheios = new JPanel();
        panelRecheios.setBounds(417, 60, 320, 220);
        panelExtras.add(panelRecheios);
        panelRecheios.setBorder(BorderFactory.createTitledBorder("Escolha os Recheios (máx. 2)"));
        panelRecheios.setLayout(new GridLayout(0, 2, 5, 5));

        chckbxRecheios = new JCheckBox[RECHEIOS.length];
        for (int i = 0; i < RECHEIOS.length; i++) {
            chckbxRecheios[i] = new JCheckBox(RECHEIOS[i]);
            panelRecheios.add(chckbxRecheios[i]);
        }

        // Painel para informações do cliente
        JPanel panelCliente = new JPanel();
        panelCliente.setBounds(15, 320, 747, 150);
        panelCliente.setBorder(BorderFactory.createTitledBorder("Informações do Cliente"));
        contentPane.add(panelCliente);
        panelCliente.setLayout(new GridLayout(3, 2, 5, 5));

        panelCliente.add(new JLabel("Nome:"));
        txtNome = new JTextField();
        panelCliente.add(txtNome);

        panelCliente.add(new JLabel("Telefone:"));
        txtTelefone = new JTextField();
        panelCliente.add(txtTelefone);

        panelCliente.add(new JLabel("Endereço:"));
        txtEndereco = new JTextField();
        panelCliente.add(txtEndereco);

        // Painel para formas de pagamento
        JPanel panelPagamento = new JPanel();
        panelPagamento.setBounds(15, 481, 415, 58);
        panelPagamento.setBorder(BorderFactory.createTitledBorder("Forma de Pagamento"));
        contentPane.add(panelPagamento);
        panelPagamento.setLayout(new FlowLayout());

        comboBoxPagamento = new JComboBox<>(FORMAS_PAGAMENTO);
        panelPagamento.add(comboBoxPagamento);

        // Botão Confirmar
        btnConfirmar = new JButton("Confirmar Pedido");
        btnConfirmar.setBounds(15, 542, 150, 30);
        btnConfirmar.addActionListener(e -> mostrarResumo());
        contentPane.add(btnConfirmar);

        // Botão Voltar
        btnVoltar = new JButton("Voltar ao Menu");
        btnVoltar.setBounds(175, 542, 150, 30);
        btnVoltar.addActionListener(e -> voltarAoMenu());
        contentPane.add(btnVoltar);

        // Painel para resumo do pedido
        JPanel panelResumo = new JPanel();
        panelResumo.setBounds(15, 583, 747, 130);
        panelResumo.setBorder(BorderFactory.createTitledBorder("Resumo do Pedido"));
        contentPane.add(panelResumo);
        panelResumo.setLayout(new BorderLayout(10, 10));
        
                textAreaResumo = new JTextArea(7, 50);
                panelResumo.add(textAreaResumo, BorderLayout.CENTER);
                textAreaResumo.setEditable(false);
                JScrollPane scrollPane = new JScrollPane();
                scrollPane.setBounds(27, 601, 735, 108);
                contentPane.add(scrollPane);
    }

    /**
     * Ajusta a quantidade de pizzas.
     */
    private void ajustarQuantidade(int ajuste) {
        quantidade += ajuste;
        if (quantidade < 1) {
            quantidade = 1;
        }
        txtQuantidade.setText(String.valueOf(quantidade));
    }

    /**
     * Mostra um resumo do pedido na área de texto.
     */
    private void mostrarResumo() {
        String tamanho = (String) comboBoxTamanho.getSelectedItem();
        
        // Calcular o preço da pizza com base no tamanho
        double precoBase = 0.0;
        switch (tamanho) {
            case "Pequena":
                precoBase = PRECO_PEQUENA;
                break;
            case "Média":
                precoBase = PRECO_MEDIA;
                break;
            case "Grande":
                precoBase = PRECO_GRANDE;
                break;
        }
        
        // Verificar quantidade de recheios selecionados
        int recheiosSelecionados = 0;
        StringBuilder recheios = new StringBuilder();
        for (JCheckBox recheio : chckbxRecheios) {
            if (recheio.isSelected()) {
                recheios.append(recheio.getText()).append(", ");
                recheiosSelecionados++;
            }
        }
        
        if (recheiosSelecionados > 2) {
            JOptionPane.showMessageDialog(this, "Você pode selecionar no máximo 2 recheios.", "Erro", JOptionPane.ERROR_MESSAGE);
            return; // Interrompe a execução se o limite for excedido
        }
        
        if (recheios.length() > 0) {
            recheios.setLength(recheios.length() - 2); // Remove a última vírgula e espaço
        }
        
        // Calcular preço total com base na quantidade e recheios adicionais
        double precoTotal = (precoBase + recheiosSelecionados * PRECO_RECHEIO_ADICIONAL) * quantidade;
        
        // Mostrar resumo
        StringBuilder resumo = new StringBuilder();
        resumo.append("Tamanho: ").append(tamanho).append("\n");
        resumo.append("Quantidade: ").append(quantidade).append("\n");
        resumo.append("Recheios: ").append(recheios).append("\n");
        resumo.append("Preço Total: R$ ").append(String.format("%.2f", precoTotal)).append("\n");
        resumo.append("\nInformações do Cliente:\n");
        resumo.append("Nome: ").append(txtNome.getText()).append("\n");
        resumo.append("Telefone: ").append(txtTelefone.getText()).append("\n");
        resumo.append("Endereço: ").append(txtEndereco.getText()).append("\n");
        resumo.append("Forma de Pagamento: ").append(comboBoxPagamento.getSelectedItem()).append("\n");

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

