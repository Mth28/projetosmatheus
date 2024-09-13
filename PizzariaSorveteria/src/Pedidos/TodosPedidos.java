package Pedidos;

import javax.swing.*;
import java.awt.*;

public class TodosPedidos extends JFrame {
    
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private CardLayout cardLayout;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                TodosPedidos frame = new TodosPedidos();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public TodosPedidos() {
        initialize();
    }

    private void initialize() {
        setTitle("Cardápio");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        
        cardLayout = new CardLayout();
        contentPane = new JPanel(cardLayout);
        setContentPane(contentPane);
        
        // Adiciona os sub-painéis
        addPanelsToContentPane();
        
        // Adiciona painel de navegação
        JPanel navigationPanel = createNavigationPanel();
        add(navigationPanel, BorderLayout.NORTH);
        
        // Exibe o painel inicial
        cardLayout.show(contentPane, "Esfirras Doces");
    }

    private void addPanelsToContentPane() {
        contentPane.add(createEsfirrasDocesPanel(), "Esfirras Doces");
        contentPane.add(createPasteisPanel(), "Pasteis");
        contentPane.add(createPizzaSalgadaPanel(), "Pizza Salgada");
        contentPane.add(createPizzasDocesPanel(), "Pizzas Doces");
        contentPane.add(createRefrigeranteSaboresPanel(), "Refrigerante Sabores");
        contentPane.add(createSorvetesPanel(), "Sorvetes");
        contentPane.add(createEsfirraSalgadaPanel(), "Esfirra Salgada");
    }

    private JPanel createNavigationPanel() {
        JPanel panel = new JPanel();
        JButton esfirrasDocesButton = new JButton("Esfirras Doces");
        JButton pasteisButton = new JButton("Pasteis");
        JButton pizzaSalgadaButton = new JButton("Pizza Salgada");
        JButton pizzasDocesButton = new JButton("Pizzas Doces");
        JButton refrigeranteSaboresButton = new JButton("Refrigerante Sabores");
        JButton sorvetesButton = new JButton("Sorvetes");
        JButton esfirraSalgadaButton = new JButton("Esfirra Salgada");

        esfirrasDocesButton.addActionListener(e -> cardLayout.show(contentPane, "Esfirras Doces"));
        pasteisButton.addActionListener(e -> cardLayout.show(contentPane, "Pasteis"));
        pizzaSalgadaButton.addActionListener(e -> cardLayout.show(contentPane, "Pizza Salgada"));
        pizzasDocesButton.addActionListener(e -> cardLayout.show(contentPane, "Pizzas Doces"));
        refrigeranteSaboresButton.addActionListener(e -> cardLayout.show(contentPane, "Refrigerante Sabores"));
        sorvetesButton.addActionListener(e -> cardLayout.show(contentPane, "Sorvetes"));
        esfirraSalgadaButton.addActionListener(e -> cardLayout.show(contentPane, "Esfirra Salgada"));

        panel.add(esfirrasDocesButton);
        panel.add(pasteisButton);
        panel.add(pizzaSalgadaButton);
        panel.add(pizzasDocesButton);
        panel.add(refrigeranteSaboresButton);
        panel.add(sorvetesButton);
        panel.add(esfirraSalgadaButton);

        return panel;
    }

    private JPanel createEsfirrasDocesPanel() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Esfirras Doces"));
        // Adicione mais componentes conforme necessário
        return panel;
    }

    private JPanel createPasteisPanel() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Pasteis"));
        // Adicione mais componentes conforme necessário
        return panel;
    }

    private JPanel createPizzaSalgadaPanel() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Pizza Salgada"));
        // Adicione mais componentes conforme necessário
        return panel;
    }

    private JPanel createPizzasDocesPanel() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Pizzas Doces"));
        // Adicione mais componentes conforme necessário
        return panel;
    }

    private JPanel createRefrigeranteSaboresPanel() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Refrigerante Sabores"));
        // Adicione mais componentes conforme necessário
        return panel;
    }

    private JPanel createSorvetesPanel() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Sorvetes"));
        // Adicione mais componentes conforme necessário
        return panel;
    }

    private JPanel createEsfirraSalgadaPanel() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Esfirra Salgada"));
        // Adicione mais componentes conforme necessário
        return panel;
    }
}
