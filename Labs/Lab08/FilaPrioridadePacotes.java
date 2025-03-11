import java.util.Comparator;
import java.util.PriorityQueue;

public class FilaPrioridadePacotes {
    private PriorityQueue<Pacote> filaPrioridade;

    public FilaPrioridadePacotes() {
        this.filaPrioridade = new PriorityQueue<>(Comparator.comparingInt(Pacote::getPrioridade));
    }

    public void adicionarPacote(Pacote pacote) {
        filaPrioridade.add(pacote);
    }

    public Pacote processarPacote() {
        return filaPrioridade.poll();
    }

    public void exibirPacotes() {
        if (filaPrioridade.isEmpty()) {
            System.out.println("Nenhum pacote na fila de prioridade.");
        } else {
            for (Pacote pacote : filaPrioridade) {
                System.out.println(pacote);
            }
        }
    }

    public boolean isVazia() {
        return filaPrioridade.isEmpty();
    }
}
