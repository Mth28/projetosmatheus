package Gestaopedido;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pedido {

    private String id;
    private List<String> produtos;
    private String status;

    // Construtor
    public Pedido(String id, List<String> produtos, String status) {
        this.id = id;
        this.produtos = new ArrayList<>(produtos);
        this.status = status;
    }

    // Getter e Setter para id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Getter e Setter para produtos
    public List<String> getProdutos() {
        return new ArrayList<>(produtos);
    }

    public void setProdutos(List<String> produtos) {
        this.produtos = new ArrayList<>(produtos);
    }

    // Getter e Setter para status
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id='" + id + '\'' +
                ", produtos=" + produtos +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(id, pedido.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
