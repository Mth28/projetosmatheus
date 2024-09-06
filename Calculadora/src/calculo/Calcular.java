package calculo;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Calcular extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textFieldResult;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Calcular frame = new Calcular();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Calcular() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 350);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblValor1 = new JLabel("Valor 1:");
        lblValor1.setBounds(10, 30, 80, 14);
        contentPane.add(lblValor1);

        JLabel lblValor2 = new JLabel("Valor 2:");
        lblValor2.setBounds(10, 60, 80, 14);
        contentPane.add(lblValor2);

        textField1 = new JTextField();
        textField1.setBounds(100, 27, 120, 20);
        contentPane.add(textField1);
        textField1.setColumns(10);

        textField2 = new JTextField();
        textField2.setBounds(100, 57, 120, 20);
        contentPane.add(textField2);
        textField2.setColumns(10);

        JButton btnSum = new JButton("Somar");
        btnSum.setBounds(240, 26, 80, 23);
        contentPane.add(btnSum);

        JButton btnSubtract = new JButton("Subtrair");
        btnSubtract.setBounds(330, 26, 90, 23);
        contentPane.add(btnSubtract);

        JButton btnMultiply = new JButton("Multiplicar");
        btnMultiply.setBounds(240, 56, 80, 23);
        contentPane.add(btnMultiply);

        JButton btnDivide = new JButton("Dividir");
        btnDivide.setBounds(330, 56, 90, 23);
        contentPane.add(btnDivide);

        JButton btnClear = new JButton("Limpar");
        btnClear.setBounds(240, 86, 180, 23);
        contentPane.add(btnClear);

        JLabel lblResult = new JLabel("Resultado:");
        lblResult.setBounds(10, 100, 80, 14);
        contentPane.add(lblResult);

        textFieldResult = new JTextField();
        textFieldResult.setBounds(100, 97, 120, 20);
        contentPane.add(textFieldResult);
        textFieldResult.setColumns(10);
        textFieldResult.setEditable(false);

        btnSum.addActionListener(e -> performOperation(Operation.ADD));
        btnSubtract.addActionListener(e -> performOperation(Operation.SUBTRACT));
        btnMultiply.addActionListener(e -> performOperation(Operation.MULTIPLY));
        btnDivide.addActionListener(e -> performOperation(Operation.DIVIDE));
        btnClear.addActionListener(e -> clearFields());
    }

    private void performOperation(Operation operation) {
        try {
            double value1 = Double.parseDouble(textField1.getText());
            double value2 = Double.parseDouble(textField2.getText());
            double result = 0;

            switch (operation) {
                case ADD:
                    result = value1 + value2;
                    break;
                case SUBTRACT:
                    result = value1 - value2;
                    break;
                case MULTIPLY:
                    result = value1 * value2;
                    break;
                case DIVIDE:
                    if (value2 != 0) {
                        result = value1 / value2;
                    } else {
                        throw new ArithmeticException("Divisão por zero não é permitida.");
                    }
                    break;
            }

            textFieldResult.setText(String.valueOf(result));
        } catch (NumberFormatException e) {
            textFieldResult.setText("Entrada inválida");
        } catch (ArithmeticException e) {
            textFieldResult.setText(e.getMessage());
        }
    }

    private void clearFields() {
        textField1.setText("");
        textField2.setText("");
        textFieldResult.setText("");
    }

    private enum Operation {
        ADD,
        SUBTRACT,
        MULTIPLY,
        DIVIDE
    }
}

