import java.util.ArrayList;
import java.util.List;

public class Sobrevivente extends Pessoa {
    private List<String> habilidades;
    private String status;

    public Sobrevivente(String nome, int idade, String id, String status) {
        super(nome, idade, id);
        this.habilidades = new ArrayList<>();
        this.status = status;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void adicionarHabilidade(String habilidade) {
        if (habilidades.size() <= 3) {
            habilidades.add(habilidade);
        } else {
            System.out.println("Limite de Habilidades atingido para o sobrevivente " + getNome());
        }
    }

    public void removerHabilidade(String habilidade) {
        if (habilidades.remove(habilidade)) {
            System.out.println("Habilidade " + habilidade + " removida do sobrevivente " + getNome());
        } else {
            System.out.println("Habilidade " + habilidade + " não encontrada para o sobrevivente " + getNome());
        }
    }
}
