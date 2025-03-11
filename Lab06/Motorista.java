public class Motorista {
    protected String nome;
    protected String cpf;
    protected String habilitacao;

    public Motorista(String nome, String cpf, String habilitacao) {
        this.nome = nome;
        this.cpf = cpf;
        this.habilitacao = habilitacao;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getHabilitacao() {
        return habilitacao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setHabilitacao(String habilitacao) {
        this.habilitacao = habilitacao;
    }

    public String getDetalhes() {
        return "Nome: " + nome + ", CPF: " + cpf + ", Habilitacao: " + habilitacao;
    }

}