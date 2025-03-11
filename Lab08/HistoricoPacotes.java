import java.util.ArrayList;

public class HistoricoPacotes {
    private ArrayList<Pacote> historico;

    public ArrayList<Pacote> getHistorico() {
        return historico;
    }

    public void setHistorico(ArrayList<Pacote> historico) {
        this.historico = historico;
    }

    public HistoricoPacotes() {
        this.historico = new ArrayList<>();
    }

    public void adicionarAoHistorico(Pacote pacote) {
        historico.add(pacote);
    }

    public void exibirHistorico() {
        if (historico.isEmpty()) {
            System.out.println("Nenhum pacote no histórico.");
        } else {
            for (Pacote pacote : historico) {
                System.out.println(pacote);
            }
        }
    }
}
