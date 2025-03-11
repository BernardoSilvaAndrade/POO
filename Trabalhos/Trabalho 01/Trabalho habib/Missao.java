import java.util.ArrayList;
import java.util.List;

public class Missao {
    private String nome;
    private String objetivo;
    private String local;
    private List<String> sobreviventes;
    private List<Recurso> recursosColetados;
    private String status;

    public Missao(String nome, String objetivo, String local) {
        this.nome = nome;
        this.objetivo = objetivo;
        this.local = local;
        this.sobreviventes = new ArrayList<>();
        this.recursosColetados = new ArrayList<>();
        this.status = "Em andamento";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public List<String> getSobreviventes() {
        return sobreviventes;
    }

    public void setSobreviventes(List<String> sobreviventes) {
        this.sobreviventes = sobreviventes;
    }

    public List<Recurso> getRecursosColetados() {
        return recursosColetados;
    }

    public void setRecursosColetados(List<Recurso> recursosColetados) {
        this.recursosColetados = recursosColetados;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void adicionarSobrevivente(String sobrevienteID) {
        sobreviventes.add(sobrevienteID);
    }

    public void removerSobrevivente(String sobreviventeID) {
        sobreviventes.remove(sobreviventeID);
    }

    public void adicionarRecursoColetado(Recurso recurso) {
        recursosColetados.add(recurso);
    }

    public void imprimirSobreviventes() {
        System.out.println("Sobreviventes no vault:");
        for (String id : sobreviventes) {
            System.out.println(id);
        }
    }

    public void imprimirSobreviventesMissao() {
        System.out.println("Sobreviventes no missao:");
        for (String id : sobreviventes) {
            System.out.println(id);
        }
    }
}
