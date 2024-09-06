package Pedidos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Cardapio extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Cardapio frame = new Cardapio();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Cardapio() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1000, 800);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setBounds(5, 5, 974, 751);
        contentPane.add(tabbedPane);

        // Adicionar Pizzas Salgadas
        tabbedPane.addTab("Pizzas Salgadas", createPizzaSalgadaPanel());

        // Adicionar Pizzas Doces
        tabbedPane.addTab("Pizzas Doces", createPizzaDocesPanel());

        // Adicionar Sorvetes
        tabbedPane.addTab("Sorvetes", createSorvetesPanel());

        // Adicionar Milk Shakes
        tabbedPane.addTab("Milk Shakes", createMilkShakesPanel());

        // Adicionar Esfirras Doces
        tabbedPane.addTab("Esfirras Doces", createEsfirrasDocesPanel());

        // Adicionar Pasteis
        tabbedPane.addTab("Pasteis", createPasteisPanel());

        // Adicionar Refrigerantes
        tabbedPane.addTab("Refrigerantes", createRefrigerantesPanel());

        // Adicionar Esfirras Salgadas
        tabbedPane.addTab("Esfirras Salgadas", createEsfirraSalgadaPanel());
    }

    private JPanel createPizzaSalgadaPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        String[] columnNames = {"Pizza", "Preço"};
        String[][] data = {
            {"Margherita", "R$ 30.00"}, {"Pepperoni", "R$ 32.00"}, {"Quatro Queijos", "R$ 35.00"},
            {"Calabresa", "R$ 33.00"}, {"Frango com Catupiry", "R$ 34.00"}, {"Portuguesa", "R$ 34.00"},
            {"Hawaiana", "R$ 34.00"}, {"Vegetariana", "R$ 32.00"}, {"Peperoni", "R$ 32.00"},
            {"Marinara", "R$ 30.00"}, {"Bacon com Cebola", "R$ 34.00"}, {"Diavola", "R$ 33.00"},
            {"Frango e Bacon", "R$ 35.00"}, {"Alho e Óleo", "R$ 31.00"}, {"Pesto com Tomate Seco", "R$ 34.00"},
            {"Lasanha", "R$ 36.00"}, {"Mexicana", "R$ 33.00"}, {"Carbonara", "R$ 35.00"},
            {"Rúcula com Tomate Seco", "R$ 34.00"}, {"Gorgonzola com Pera", "R$ 36.00"}
        };
        JTable table = new JTable(data, columnNames);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        JButton btnVoltar = new JButton("Voltar ao Menu");
        btnVoltar.addActionListener(e -> {
            dispose();
            new Menu().setVisible(true);
        });
        panel.add(btnVoltar, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createPizzaDocesPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        String[] columnNames = {"Pizza", "Preço"};
        String[][] data = {
            {"Nutella", "R$ 35.00"}, {"Frutas", "R$ 34.00"}, {"Granola", "R$ 32.00"},
            {"Leite Condensado", "R$ 33.00"}, {"Chocolate", "R$ 35.00"}, {"Banana com Canela", "R$ 32.00"},
            {"Marmelada com Queijo", "R$ 34.00"}, {"Marshmallow com Chocolate", "R$ 36.00"},
            {"Caramelo com Nozes", "R$ 35.00"}, {"Pêssego com Creme", "R$ 34.00"}, {"Frutas Vermelhas", "R$ 36.00"},
            {"Chocolate Branco com Framboesas", "R$ 37.00"}, {"Doce de Leite com Castanhas", "R$ 35.00"},
            {"Pera com Gorgonzola", "R$ 36.00"}, {"Tiramisu", "R$ 37.00"}, {"Pistache com Mel", "R$ 36.00"},
            {"Abacaxi com Hortelã", "R$ 34.00"}, {"Creme de Avelã com Morangos", "R$ 35.00"},
            {"Maçã com Canela", "R$ 33.00"}
        };
        JTable table = new JTable(data, columnNames);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        JButton btnVoltar = new JButton("Voltar ao Menu");
        btnVoltar.addActionListener(e -> {
            dispose();
            new Menu().setVisible(true);
        });
        panel.add(btnVoltar, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createSorvetesPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        String[] columnNames = {"Sorvete", "Preço"};
        String[][] data = {
            {"Chocolate", "R$ 30.00"}, {"Baunilha", "R$ 28.00"}, {"Morango", "R$ 32.00"},
            {"Flocos", "R$ 29.00"}, {"Creme", "R$ 30.00"}, {"Manga", "R$ 31.00"},
            {"Coco", "R$ 32.00"}, {"Framboesa", "R$ 33.00"}
        };
        JTable table = new JTable(data, columnNames);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        JButton btnVoltar = new JButton("Voltar ao Menu");
        btnVoltar.addActionListener(e -> {
            dispose();
            new Menu().setVisible(true);
        });
        panel.add(btnVoltar, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createMilkShakesPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        String[] columnNames = {"Milk Shake", "Preço"};
        String[][] data = {
            {"Chocolate", "R$ 17.00"}, {"Morango", "R$ 16.00"}, {"Baunilha", "R$ 15.00"},
            {"Caramelo", "R$ 18.00"}, {"Oreo", "R$ 19.00"}, {"Nutella", "R$ 20.00"},
            {"Café", "R$ 17.00"}, {"Menta", "R$ 18.00"}
        };
        JTable table = new JTable(data, columnNames);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        JButton btnVoltar = new JButton("Voltar ao Menu");
        btnVoltar.addActionListener(e -> {
            dispose();
            new Menu().setVisible(true);
        });
        panel.add(btnVoltar, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createEsfirrasDocesPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        String[] columnNames = {"Esfirra", "Preço"};
        String[][] data = {
            {"Chocolate", "R$ 5.00"}, {"Doce de Leite", "R$ 4.50"}, {"Morango", "R$ 5.50"},
            {"Banana", "R$ 5.00"}, {"Canela", "R$ 4.50"}, {"Coco", "R$ 5.00"}, {"Maracujá", "R$ 5.50"}
        };
        JTable table = new JTable(data, columnNames);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        JButton btnVoltar = new JButton("Voltar ao Menu");
        btnVoltar.addActionListener(e -> {
            dispose();
            new Menu().setVisible(true);
        });
        panel.add(btnVoltar, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createPasteisPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        String[] columnNames = {"Pastel", "Preço"};
        String[][] data = {
            {"Carne", "R$ 7.00"}, {"Frango", "R$ 6.50"}, {"Queijo", "R$ 6.00"},
            {"Pizza", "R$ 7.00"}, {"Vegetal", "R$ 6.50"}, {"Calabresa", "R$ 7.00"}
        };
        JTable table = new JTable(data, columnNames);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        JButton btnVoltar = new JButton("Voltar ao Menu");
        btnVoltar.addActionListener(e -> {
            dispose();
            new Menu().setVisible(true);
        });
        panel.add(btnVoltar, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createRefrigerantesPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        String[] columnNames = {"Refrigerante", "Preço"};
        String[][] data = {
            {"Coca-Cola", "R$ 5.00"}, {"Pepsi", "R$ 5.00"}, {"Sprite", "R$ 5.00"},
            {"Fanta", "R$ 5.00"}, {"Guaraná", "R$ 5.00"}
        };
        JTable table = new JTable(data, columnNames);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        JButton btnVoltar = new JButton("Voltar ao Menu");
        btnVoltar.addActionListener(e -> {
            dispose();
            new Menu().setVisible(true);
        });
        panel.add(btnVoltar, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createEsfirraSalgadaPanel() {
        JPanel panel = new JPanel();
        
        // Tabela de Esfirras Salgadas
        String[] columnNames = {"Esfirra", "Preço"};
        String[][] data = {
            {"Carne", "R$ 15.00"}, {"Frango", "R$ 16.00"}, {"Queijo", "R$ 14.00"},
            {"Calabresa", "R$ 15.50"}, {"Presunto e Queijo", "R$ 14.50"}, {"Brócolis com Bacon", "R$ 16.50"},
            {"Pizza", "R$ 17.00"}, {"Lombo Canadense", "R$ 17.50"}, {"Alho e Óleo", "R$ 13.50"},
            {"Azeitona e Queijo", "R$ 14.00"}, {"Milho e Bacon", "R$ 15.00"}, {"Mussarela e Tomate Seco", "R$ 16.00"},
            {"Picanha", "R$ 18.00"}, {"Vegetariana", "R$ 15.00"}, {"Palmito", "R$ 16.50"},
            {"Frango com Catupiry", "R$ 16.50"}, {"Cordeiro", "R$ 17.00"}, {"Ostras", "R$ 20.00"},
            {"Atum", "R$ 18.00"}, {"Salsicha", "R$ 14.50"}
        };
        panel.setLayout(null);
        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 0, 969, 386);
        panel.add(scrollPane);

        // Formulário para Pedidos de Esfirra
        JPanel formPanel = new JPanel();
        formPanel.setBounds(0, 723, 969, 0);
        formPanel.setLayout(new GridLayout(7, 2));

        JLabel lblFlavor = new JLabel("Sabor:");
        JComboBox<String> flavorComboBox = new JComboBox<>(new String[] {
            "Carne", "Frango", "Queijo", "Calabresa", "Presunto e Queijo", "Brócolis com Bacon",
            "Pizza", "Lombo Canadense", "Alho e Óleo", "Azeitona e Queijo", "Milho e Bacon",
            "Mussarela e Tomate Seco", "Picanha", "Vegetariana", "Palmito", "Frango com Catupiry",
            "Cordeiro", "Ostras", "Atum", "Salsicha"
        });



        panel.add(formPanel);
        
                JButton btnVoltar = new JButton("Voltar ao Menu");
                btnVoltar.setBounds(10, 693, 959, 30);
                panel.add(btnVoltar);
                btnVoltar.addActionListener(e -> {
                    dispose();
                    new Menu().setVisible(true);
                });

        return panel;
    }
}

