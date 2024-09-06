package Registros;

import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MaiorMenorTemperatura extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldInput;
    private JLabel lblHighest;
    private JLabel lblLowest;
    
    private double highest = Double.MIN_VALUE;
    private double lowest = Double.MAX_VALUE;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MaiorMenorTemperatura frame = new MaiorMenorTemperatura();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public MaiorMenorTemperatura() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblEnterTemperature = new JLabel("Enter Temperature:");
        lblEnterTemperature.setBounds(10, 10, 150, 25);
        contentPane.add(lblEnterTemperature);

        textFieldInput = new JTextField();
        textFieldInput.setBounds(170, 10, 150, 25);
        contentPane.add(textFieldInput);
        textFieldInput.setColumns(10);

        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(330, 10, 90, 25);
        btnSubmit.addActionListener(e -> processTemperature());
        contentPane.add(btnSubmit);

        lblHighest = new JLabel("Highest: ");
        lblHighest.setBounds(10, 50, 400, 25);
        contentPane.add(lblHighest);

        lblLowest = new JLabel("Lowest: ");
        lblLowest.setBounds(10, 80, 400, 25);
        contentPane.add(lblLowest);
    }

    private void processTemperature() {
        try {
            double temperature = Double.parseDouble(textFieldInput.getText());
            if (temperature > highest) {
                highest = temperature;
                lblHighest.setText("Highest: " + highest);
            }
            if (temperature < lowest) {
                lowest = temperature;
                lblLowest.setText("Lowest: " + lowest);
            }
        } catch (NumberFormatException e) {
            lblHighest.setText("Invalid input");
            lblLowest.setText("");
        }
    }
}
