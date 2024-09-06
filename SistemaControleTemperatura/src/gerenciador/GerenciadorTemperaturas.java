package gerenciador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GerenciadorTemperaturas {

    private List<Temperatura> temperaturas;

    // Construtor
    public GerenciadorTemperaturas() {
        this.temperaturas = new ArrayList<>();
    }

    /**
     * Adiciona uma nova temperatura ao registro.
     * @param temperatura A temperatura a ser adicionada.
     */
    public void adicionarTemperatura(Temperatura temperatura) {
        temperaturas.add(temperatura);
    }

    /**
     * Remove uma temperatura pelo objeto.
     * @param temperatura A temperatura a ser removida.
     */
    public void removerTemperatura(Temperatura temperatura) {
        temperaturas.remove(temperatura);
    }

    /**
     * Lista todas as temperaturas registradas.
     * @return Uma lista com todas as temperaturas.
     */
    public List<Temperatura> listarTemperaturas() {
        return new ArrayList<>(temperaturas);
    }

    // Métodos adicionais, se necessários, podem ser adicionados aqui
}
