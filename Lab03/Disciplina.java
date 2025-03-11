public class Disciplina {
    private String nome;
    private int ch;
    private Professor professor;

    public Disciplina() {                                
    }

    public Disciplina(String nome, int ch, Professor professor) {
        this.nome = nome;
        this.ch = ch;
        this.professor = professor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCh() {
        return ch;
    }                                                          

    public void setCh(int ch) {
        this.ch = ch;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

}