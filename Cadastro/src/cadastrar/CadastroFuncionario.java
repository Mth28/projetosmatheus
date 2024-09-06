package cadastrar;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class CadastroFuncionario extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldNome;
    private JTextField textFieldIdade;
    private JTextField textFieldCpf;
    private JTextField textFieldEmail;
    private JTextField textFieldCargo;
    private JTextField textFieldId;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                CadastroFuncionario frame = new CadastroFuncionario();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public CadastroFuncionario() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitulo = new JLabel("Cadastrar Funcionário");
        lblTitulo.setBounds(132, 11, 200, 14);
        contentPane.add(lblTitulo);

        JLabel lblNome = new JLabel("Nome");
        lblNome.setBounds(10, 39, 82, 14);
        contentPane.add(lblNome);

        JLabel lblIdade = new JLabel("Idade");
        lblIdade.setBounds(10, 64, 82, 14);
        contentPane.add(lblIdade);

        JLabel lblCpf = new JLabel("CPF");
        lblCpf.setBounds(10, 117, 82, 14);
        contentPane.add(lblCpf);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(10, 142, 82, 14);
        contentPane.add(lblEmail);

        JLabel lblCargo = new JLabel("Cargo");
        lblCargo.setBounds(10, 167, 82, 14);
        contentPane.add(lblCargo);

        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(84, 209, 89, 23);
        contentPane.add(btnCadastrar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(201, 209, 89, 23);
        contentPane.add(btnCancelar);

        textFieldNome = new JTextField();
        textFieldNome.setBounds(72, 36, 246, 20);
        contentPane.add(textFieldNome);
        textFieldNome.setColumns(10);

        textFieldIdade = new JTextField();
        textFieldIdade.setBounds(72, 64, 246, 20);
        contentPane.add(textFieldIdade);
        textFieldIdade.setColumns(10);

        textFieldCpf = new JTextField();
        textFieldCpf.setBounds(72, 114, 246, 20);
        contentPane.add(textFieldCpf);
        textFieldCpf.setColumns(10);

        textFieldEmail = new JTextField();
        textFieldEmail.setBounds(72, 139, 246, 20);
        contentPane.add(textFieldEmail);
        textFieldEmail.setColumns(10);

        textFieldCargo = new JTextField();
        textFieldCargo.setBounds(72, 164, 246, 20);
        contentPane.add(textFieldCargo);
        textFieldCargo.setColumns(10);

        JLabel lblId = new JLabel("ID");
        lblId.setBounds(10, 92, 46, 14);
        contentPane.add(lblId);

        textFieldId = new JTextField();
        textFieldId.setBounds(72, 89, 246, 20);
        contentPane.add(textFieldId);
        textFieldId.setColumns(10);

        // Action for Cadastrar button
        btnCadastrar.addActionListener(e -> cadastrarFuncionario());

        // Action for Cancelar button
        btnCancelar.addActionListener(e -> limparCampos());
    }

    private void cadastrarFuncionario() {
        String nome = textFieldNome.getText();
        int idade;
        String cpf = textFieldCpf.getText();
        String email = textFieldEmail.getText();
        String cargo = textFieldCargo.getText();
        
        try {
            idade = Integer.parseInt(textFieldIdade.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Idade deve ser um número válido.");
            return;
        }

        Funcionario funcionario = new Funcionario(nome, idade, cpf, email, cargo);
        FuncionarioDAO.inserirFuncionario(funcionario);

        JOptionPane.showMessageDialog(this, "Funcionário cadastrado com sucesso!");
        limparCampos();
    }

    private void limparCampos() {
        textFieldNome.setText("");
        textFieldIdade.setText("");
        textFieldCpf.setText("");
        textFieldEmail.setText("");
        textFieldCargo.setText("");
        textFieldId.setText("");
    }
}

