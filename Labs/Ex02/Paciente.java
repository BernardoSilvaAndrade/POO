
public class Paciente implements Comparable<Paciente> {
    private String nome;
    private int prioridade;

    public Paciente(String nome, int prioridade) {
        this.nome = nome;
        this.prioridade = prioridade;
    }

    public String getNome() {
        return nome;
    }

    public int getPrioridade() {
        return prioridade;
    }

    @Override
    public int compareTo(Paciente outro) {
        return Integer.compare(this.prioridade, outro.prioridade);
    }
}
