package gerenciaestoque;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;

public class Adicionar extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldNome;
    private JTextField textFieldQuantidade;
    private JTextField textFieldPreco;
    private Estoque estoque;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Adicionar frame = new Adicionar();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public Adicionar() {
        estoque = new Estoque(); // Inicializa o sistema de estoque

        setTitle("Adicionar Item ao Estoque");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(10, 30, 80, 14);
        contentPane.add(lblNome);

        JLabel lblQuantidade = new JLabel("Quantidade:");
        lblQuantidade.setBounds(10, 70, 80, 14);
        contentPane.add(lblQuantidade);

        JLabel lblPreco = new JLabel("Preço:");
        lblPreco.setBounds(10, 110, 80, 14);
        contentPane.add(lblPreco);

        textFieldNome = new JTextField();
        textFieldNome.setBounds(100, 27, 200, 20);
        contentPane.add(textFieldNome);
        textFieldNome.setColumns(10);

        textFieldQuantidade = new JTextField();
        textFieldQuantidade.setBounds(100, 67, 100, 20);
        contentPane.add(textFieldQuantidade);
        textFieldQuantidade.setColumns(10);

        textFieldPreco = new JTextField();
        textFieldPreco.setBounds(100, 107, 100, 20);
        contentPane.add(textFieldPreco);
        textFieldPreco.setColumns(10);

        JButton btnAdicionar = new JButton("Adicionar");
        btnAdicionar.setBounds(80, 150, 100, 23);
        contentPane.add(btnAdicionar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(190, 150, 100, 23);
        contentPane.add(btnCancelar);

        // Action for the "Adicionar" button
        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarItem();
            }
        });

        // Action for the "Cancelar" button
        btnCancelar.addActionListener(e -> {
            textFieldNome.setText("");
            textFieldQuantidade.setText("");
            textFieldPreco.setText("");
        });
    }

    private void adicionarItem() {
        String nome = textFieldNome.getText();
        String quantidadeStr = textFieldQuantidade.getText();
        String precoStr = textFieldPreco.getText();

        if (nome.isEmpty() || quantidadeStr.isEmpty() || precoStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos os campos devem ser preenchidos.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int quantidade;
        double preco;
        try {
            quantidade = Integer.parseInt(quantidadeStr);
            preco = Double.parseDouble(precoStr);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Quantidade e preço devem ser numéricos.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Item item = new Item(nome, quantidade, preco);
        estoque.adicionarItem(item);
        JOptionPane.showMessageDialog(this, "Item adicionado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        textFieldNome.setText("");
        textFieldQuantidade.setText("");
        textFieldPreco.setText("");
    }
}
