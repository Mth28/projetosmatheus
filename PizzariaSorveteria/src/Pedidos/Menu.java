package Pedidos;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Menu extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Menu frame = new Menu();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public Menu() {
        setTitle("Menu Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 642, 720);
        contentPane = new JPanel();
        contentPane.setForeground(new Color(255, 255, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Botão Pizzas Salgadas
        JButton btnPizzasSalgadas = new JButton("Pizzas Salgadas");
        btnPizzasSalgadas.setForeground(Color.RED);
        btnPizzasSalgadas.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnPizzasSalgadas.setBounds(208, 137, 220, 32);
        btnPizzasSalgadas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new PizzaSalgada().setVisible(true);
            }
        });
        contentPane.add(btnPizzasSalgadas);

        // Botão Pizzas Doces
        JButton btnPizzasDoces = new JButton("Pizzas Doces");
        btnPizzasDoces.setForeground(Color.RED);
        btnPizzasDoces.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnPizzasDoces.setBounds(208, 185, 220, 32);
        btnPizzasDoces.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new PizzasDoces().setVisible(true);
            }
        });
        contentPane.add(btnPizzasDoces);

        // Botão Esfirras Doces
        JButton btnEsfirrasDoces = new JButton("Esfirras Doces");
        btnEsfirrasDoces.setForeground(Color.RED);
        btnEsfirrasDoces.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnEsfirrasDoces.setBounds(208, 276, 220, 32);
        btnEsfirrasDoces.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new EsfirrasDoces().setVisible(true);
            }
        });
        contentPane.add(btnEsfirrasDoces);

        // Botão Esfirras Salgadas
        JButton btnEsfirrasSalgadas = new JButton("Esfirras Salgadas");
        btnEsfirrasSalgadas.setForeground(Color.RED);
        btnEsfirrasSalgadas.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnEsfirrasSalgadas.setBounds(208, 228, 220, 37);
        btnEsfirrasSalgadas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new EsfirraSalgada().setVisible(true);
            }
        });
        contentPane.add(btnEsfirrasSalgadas);

        // Botão Refrigerantes
        JButton btnRefrigerantes = new JButton("Refrigerantes");
        btnRefrigerantes.setForeground(Color.RED);
        btnRefrigerantes.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnRefrigerantes.setBounds(208, 367, 224, 37);
        btnRefrigerantes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new RefrigeranteSabores().setVisible(true);
            }
        });
        contentPane.add(btnRefrigerantes);

        // Botão Milk Shakes
        JButton btnMilkShakes = new JButton("Milk Shakes");
        btnMilkShakes.setForeground(Color.RED);
        btnMilkShakes.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnMilkShakes.setBounds(208, 319, 224, 37);
        btnMilkShakes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new MilkShakeSabores().setVisible(true);
            }
        });
        contentPane.add(btnMilkShakes);

        // Botão Pasteis
        JButton btnPasteis = new JButton("Pasteis");
        btnPasteis.setForeground(Color.RED);
        btnPasteis.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnPasteis.setBounds(208, 416, 224, 37);
        btnPasteis.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Pasteis().setVisible(true);
            }
        });
        contentPane.add(btnPasteis);

        // Botão Sorvetes
        JButton btnSorvetes = new JButton("Sorvetes");
        btnSorvetes.setForeground(Color.RED);
        btnSorvetes.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnSorvetes.setBounds(208, 464, 224, 37);
        btnSorvetes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Sorvetes().setVisible(true);
            }
        });
        contentPane.add(btnSorvetes);

        // Botão Cardápio
        JButton btnCardapio = new JButton("Cardápio");
        btnCardapio.setForeground(Color.RED);
        btnCardapio.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnCardapio.setBounds(208, 520, 224, 37);
        btnCardapio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Cardapio().setVisible(true);
            }
        });
        contentPane.add(btnCardapio);


        // Título do Menu
        JLabel lblMenuTitle = new JLabel("Pizzas e Sorvetes");
        lblMenuTitle.setIcon(null);
        lblMenuTitle.setForeground(new Color(255, 0, 0));
        lblMenuTitle.setFont(new Font("Tahoma", Font.PLAIN, 58));
        lblMenuTitle.setBounds(103, 11, 442, 70);
        contentPane.add(lblMenuTitle);
    }
}
