package cadastrar;

public class Funcionario {
    private int id;
    private String nome;
    private int idade;
    private String cpf;
    private String email;
    private String cargo;

    // Construtor
    public Funcionario(int id, String nome, int idade, String cpf, String email, String cargo) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.email = email;
        this.cargo = cargo;
    }

    // Construtor sem ID (para inserção)
    public Funcionario(String nome, int idade, String cpf, String email, String cargo) {
        this(-1, nome, idade, cpf, email, cargo);
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Funcionario [id=" + id + ", nome=" + nome + ", idade=" + idade + ", cpf=" + cpf + ", email=" + email
                + ", cargo=" + cargo + "]";
    }
}
