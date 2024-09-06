package gerenciador;

import java.util.Date;

public class Temperatura {

    private Date data;
    private double valor;

    // Construtor
    public Temperatura(Date data, double valor) {
        this.data = data;
        this.valor = valor;
    }

    // Getters e Setters
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Data: " + data.toString() + ", Temperatura: " + valor;
    }
}
