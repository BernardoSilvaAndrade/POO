import java.util.LinkedList;
import java.util.Queue;

public class FilaPedidos<T> {
    private Queue<T> fila;

    public FilaPedidos() {
        this.fila = new LinkedList<>();
    }

    public Queue<T> getFila() {
        return fila;
    }

    public void setFila(Queue<T> fila) {
        this.fila = fila;
    }

    public void adicionarPedido(T pedido) {
        fila.add(pedido);
    }

    public T removerPedido() {
        return fila.poll();
    }

    public boolean estaVazia() {
        return fila.isEmpty();
    }

    public int size() {

        return fila.size();

    }

    public void exibirFila() {
        for (T pedido : fila) {
            System.out.println(pedido);
        }
    }

}
