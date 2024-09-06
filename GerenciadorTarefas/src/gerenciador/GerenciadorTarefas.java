package gerenciador;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class GerenciadorTarefas {

    private List<Tarefa> tarefas;

    public GerenciadorTarefas() {
        tarefas = new ArrayList<>();
    }

    /**
     * Adiciona uma nova tarefa ao gerenciador.
     * @param tarefa A tarefa a ser adicionada.
     */
    public void adicionarTarefa(Tarefa tarefa) {
        tarefas.add(tarefa);
    }

    /**
     * Remove uma tarefa pelo título.
     * @param titulo O título da tarefa a ser removida.
     */
    public void removerTarefa(String titulo) {
        Iterator<Tarefa> iterator = tarefas.iterator();
        while (iterator.hasNext()) {
            Tarefa tarefa = iterator.next();
            if (tarefa.getTitulo().equalsIgnoreCase(titulo)) {
                iterator.remove();
                return;
            }
        }
        System.out.println("Tarefa com o título \"" + titulo + "\" não encontrada.");
    }

    /**
     * Atualiza uma tarefa existente.
     * @param tarefa A tarefa com as atualizações.
     */
    public void atualizarTarefa(Tarefa tarefa) {
        for (int i = 0; i < tarefas.size(); i++) {
            Tarefa t = tarefas.get(i);
            if (t.getTitulo().equalsIgnoreCase(tarefa.getTitulo())) {
                tarefas.set(i, tarefa);
                return;
            }
        }
        System.out.println("Tarefa com o título \"" + tarefa.getTitulo() + "\" não encontrada.");
    }

    /**
     * Lista todas as tarefas.
     * @return A lista de tarefas.
     */
    public List<Tarefa> listarTarefas() {
        return new ArrayList<>(tarefas);
    }
}

