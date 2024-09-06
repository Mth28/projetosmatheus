package gerenciaestoque;

import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private List<Item> itens;

    public Estoque() {
        itens = new ArrayList<>();
    }

    public void adicionarItem(Item item) {
        itens.add(item);
    }

    public List<Item> getItens() {
        return itens;
    }
}