package gerenciaestoque;

public class Item {
    private String nome;
    private int quantidade;
    private double preco;


    public Item(String nome, int quantidade, double preco) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    public String toString() {
        return String.format("Item{nome='%s', quantidade=%d, preco=%.2f}", nome, quantidade, preco);
    }
}
