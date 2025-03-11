import java.util.ArrayList;

public class HistoricoPedidos<T> {
    private ArrayList<T> historico;

    public HistoricoPedidos() {
        this.historico = new ArrayList<T>();
    }

    public ArrayList<T> getHistorico() {
        return historico;
    }

    public void setHistorico(ArrayList<T> historico) {
        this.historico = historico;
    }

    public void adicionarAoHistorico(T pedido) {
        historico.add(pedido);
    }

    public void exibirHistorico() {
        for (T pedido : historico) {
            System.out.println(pedido);
        }
    }

}
