package Gestaopedido;

// Enum que representa os status possíveis para um pedido
public enum Status {
    PENDENTE("Pendente"),
    PROCESSANDO("Processando"),
    ENVIADO("Enviado"),
    ENTREGUE("Entregue");

    private final String descricao;

    // Construtor
    Status(String descricao) {
        this.descricao = descricao;
    }

    // Método para obter a descrição do status
    public String getDescricao() {
        return descricao;
    }

    // Método para obter o status a partir de uma string
    public static Status fromString(String descricao) {
        for (Status status : Status.values()) {
            if (status.descricao.equalsIgnoreCase(descricao)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Status inválido: " + descricao);
    }

    @Override
    public String toString() {
        return descricao;
    }
}

