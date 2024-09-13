package Produtos;

import java.time.LocalDateTime;

public class Venda {
    private int id;
    private String nomeCliente;
    private String telefone;
    private String endereco;
    private double valorPedido;
    private String notaFiscal;
    private String dataHora;

    public Venda(int id, String nomeCliente, String telefone, String endereco, double valorPedido, String notaFiscal,
			String dataHora) {
		super();
		this.id = id;
		this.nomeCliente = nomeCliente;
		this.telefone = telefone;
		this.endereco = endereco;
		this.valorPedido = valorPedido;
		this.notaFiscal = notaFiscal;
		this.dataHora = dataHora;
	}
	public Venda() {
		// TODO Auto-generated constructor stub
	}
	// Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNomeCliente() { return nomeCliente; }
    public void setNomeCliente(String nomeCliente) { this.nomeCliente = nomeCliente; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
    public double getValorPedido() { return valorPedido; }
    public void setValorPedido(double valorPedido) { this.valorPedido = valorPedido; }
    public String getNotaFiscal() { return notaFiscal; }
    public void setNotaFiscal(String notaFiscal) { this.notaFiscal = notaFiscal; }
    public String getDataHora() { return dataHora; }
    public void setDataHora(String localDateTime) { this.dataHora = localDateTime; }
}
