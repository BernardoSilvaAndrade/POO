public class Professor extends Pessoa {
    private String titulacao;
    private String curso;

    public Professor() {

    }

    public Professor(String titulacao, String curso, String nome, String endereço) {
        super(nome, endereço);
        this.titulacao = titulacao;
        this.curso = curso;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

}
