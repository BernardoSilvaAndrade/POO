import java.util.PriorityQueue;

public class FilaAtendimento {
    private PriorityQueue<Paciente> fila;

    public FilaAtendimento() {
        this.fila = new PriorityQueue<>();
    }

    public void adicionarPaciente(String nome, int prioridade) {
        Paciente novoPaciente = new Paciente(nome, prioridade);
        fila.add(novoPaciente);
    }

    public void atenderPaciente() {
        if (!fila.isEmpty()) {
            Paciente atendido = fila.poll();
            System.out.println("Atendendo: " + atendido.getNome() + " (Prioridade: " + atendido.getPrioridade() + ")");
        } else {
            System.out.println("Nenhum paciente na fila.");
        }
    }

    public void exibirFila() {
        if (fila.isEmpty()) {
            System.out.println("Fila vazia.");
        } else {
            System.out.println("Pacientes na fila:");
            for (Paciente p : fila) {
                System.out.println(p.getNome() + " (Prioridade: " + p.getPrioridade() + ")");
            }
        }
    }

    public boolean estaVazia() {
        return fila.isEmpty();
    }
}