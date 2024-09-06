package Gestaopedido;

import java.util.HashMap;
import java.util.Map;

public class GestorPedidos {

    private Map<String, Pedido> pedidos;

    public GestorPedidos() {
        pedidos = new HashMap<>();
    }

    /**
     * Adiciona um novo pedido ao sistema.
     * @param pedido O pedido a ser adicionado.
     * @throws IllegalArgumentException Se um pedido com o mesmo ID já existir.
     */
    public void criarPedido(Pedido pedido) {
        if (pedidos.containsKey(pedido.getId())) {
            throw new IllegalArgumentException("Pedido com ID já existe.");
        }
        pedidos.put(pedido.getId(), pedido);
    }

    /**
     * Atualiza o status de um pedido existente.
     * @param id O ID do pedido a ser atualizado.
     * @param novoStatus O novo status do pedido.
     * @throws IllegalArgumentException Se o pedido não for encontrado ou o status for inválido.
     */
    public void atualizarStatusPedido(String id, String novoStatus) {
        Pedido pedido = pedidos.get(id);
        if (pedido == null) {
            throw new IllegalArgumentException("Pedido não encontrado.");
        }
        pedido.setStatus(novoStatus);
    }

    /**
     * Remove um pedido pelo ID.
     * @param id O ID do pedido a ser removido.
     * @return true se o pedido foi removido com sucesso, false se o pedido não foi encontrado.
     * @throws IllegalArgumentException Se o pedido não for encontrado.
     */
    public boolean removerPedido(String id) {
        if (!pedidos.containsKey(id)) {
            throw new IllegalArgumentException("Pedido não encontrado.");
        }
        return pedidos.remove(id) != null;
    }

    /**
     * Busca um pedido pelo ID.
     * @param id O ID do pedido a ser buscado.
     * @return O pedido correspondente ao ID, ou null se não encontrado.
     */
    public Pedido buscarPedidoPorId(String id) {
        return pedidos.get(id);
    }

    /**
     * Retorna todos os pedidos no sistema.
     * @return Um array com todos os pedidos.
     */
    public Pedido[] getPedidos() {
        return pedidos.values().toArray(new Pedido[0]);
    }
}

