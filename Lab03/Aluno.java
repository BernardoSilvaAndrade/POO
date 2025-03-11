public class Aluno extends Pessoa {
    private int matricula;

    public Aluno() {
    }

    public Aluno(int matricula, String nome, String endereço) {
        super(nome, endereço);
        this.matricula = matricula;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
}
