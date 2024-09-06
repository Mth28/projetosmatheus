package Registros;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class RegistrosVazios extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldInput;
	private JLabel lblResult;
	private JLabel lblFeedback;

	/**
	 * Lança a aplicação.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrosVazios frame = new RegistrosVazios();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Cria o frame.
	 */
	public RegistrosVazios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Rótulo de instrução
		JLabel lblInstruction = new JLabel("Digite algo:");
		lblInstruction.setBounds(10, 10, 100, 25);
		contentPane.add(lblInstruction);

		// Campo de texto para entrada do usuário
		textFieldInput = new JTextField();
		textFieldInput.setBounds(120, 10, 150, 25);
		contentPane.add(textFieldInput);
		textFieldInput.setColumns(10);

		// Botão de exibir texto
		JButton btnShowText = new JButton("Mostrar Texto");
		btnShowText.setBounds(10, 50, 150, 25);
		btnShowText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblResult.setText("Você digitou: " + textFieldInput.getText());
			}
		});
		contentPane.add(btnShowText);

		// Botão de limpar texto
		JButton btnClearText = new JButton("Limpar Texto");
		btnClearText.setBounds(170, 50, 150, 25);
		btnClearText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldInput.setText("");
				lblResult.setText("");
			}
		});
		contentPane.add(btnClearText);

		// Rótulo para mostrar o resultado
		lblResult = new JLabel("");
		lblResult.setBounds(10, 90, 300, 25);
		contentPane.add(lblResult);

		// Rótulo de feedback
		lblFeedback = new JLabel("Feedback:");
		lblFeedback.setBounds(10, 130, 300, 25);
		contentPane.add(lblFeedback);

		// Botão de feedback
		JButton btnFeedback = new JButton("Gerar Feedback");
		btnFeedback.setBounds(10, 170, 150, 25);
		btnFeedback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblFeedback.setText("Feedback gerado: " + textFieldInput.getText());
			}
		});
		contentPane.add(btnFeedback);
	}
}
