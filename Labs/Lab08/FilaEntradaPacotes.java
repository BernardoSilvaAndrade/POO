import java.util.LinkedList;
import java.util.Queue;

public class FilaEntradaPacotes {
    private Queue<Pacote> fila;

    public FilaEntradaPacotes() {
        this.fila = new LinkedList<>();
    }

    public void adicionarPacote(Pacote pacote) {
        fila.add(pacote);
    }

    public Pacote processarPacote() {
        return fila.poll();
    }

    public void exibirPacotes() {
        if (fila.isEmpty()) {
            System.out.println("Nenhum pacote na fila de entrada.");
        } else {
            for (Pacote pacote : fila) {
                System.out.println(pacote);
            }
        }
    }

    public boolean isVazia() {
        return fila.isEmpty();
    }
}
