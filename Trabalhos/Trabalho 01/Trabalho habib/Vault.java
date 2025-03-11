import java.util.ArrayList;
import java.util.List;

public class Vault {
    private List<Sobrevivente> sobreviventes;
    private List<Recurso> recursos;
    private List<Missao> missoes;

    public Vault() {
        this.sobreviventes = new ArrayList<>();
        this.recursos = new ArrayList<>();
        this.missoes = new ArrayList<>();
    }

    public List<Sobrevivente> getSobreviventes() {
        return sobreviventes;
    }

    public void adicionarSobrevivente(Sobrevivente sobrevivente) {
        sobreviventes.add(sobrevivente);
    }

    public List<Recurso> getRecursos() {
        return recursos;
    }

    public void adicionarRecurso(Recurso recurso) {
        recursos.add(recurso);
    }

    public List<Missao> getMissoes() {
        return missoes;
    }

    public void adicionarMissao(Missao missao) {
        missoes.add(missao);
    }

    public static boolean verificarMissaoExistente(Vault vault, String nomeMissao) {
        for (Missao m : vault.getMissoes()) {
            if (m.getNome().equalsIgnoreCase(nomeMissao)) {
                return true;
            }
        }
        return false;
    }

    public static boolean verificarMorto(Sobrevivente sobrevivente) {
        if (sobrevivente.getStatus().equals("Morto"))
            return true;
        return false;
    }
}
