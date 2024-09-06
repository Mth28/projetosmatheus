package gerenciador;

import java.util.Date;

public class Tarefa {
    private String titulo;
    private String descricao;
    private Date dataConclusao;
    private boolean status;

    // Construtor
    public Tarefa(String titulo, String descricao, Date dataConclusao, boolean status) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataConclusao = dataConclusao;
        this.status = status;
    }

    // Getters e Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(Date dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Título: " + titulo +
               ", Descrição: " + descricao +
               ", Data de Conclusão: " + dataConclusao +
               ", Status: " + (status ? "Concluída" : "Não Concluída");
    }
}
