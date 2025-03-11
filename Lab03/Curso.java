import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String nome;
    private ArrayList<Professor> professores;
    private ArrayList<Aluno> alunos;
    private ArrayList<Disciplina> disciplinas;

    public Curso(String nome) {
        this.nome = nome;
        this.professores = new ArrayList<>();
        this.alunos = new ArrayList<>();
        this.disciplinas = new ArrayList<>();
    }

    public void cadastrarProfessor(Professor professor) {
        professores.add(professor);
    }

    public void cadastrarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public void cadastrarDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }

    public void imprimirListaDeProfessores() {
    System.out.println("Professores do curso: " + nome);
    for (Professor professor : professores) {
        System.out.println("Nome: " + professor.getNome());
        System.out.println("Titulação: " + professor.getTitulacao());
        System.out.println("Curso: " + professor.getCurso());
        System.out.println("Endereço: " + professor.getEndereço());
        System.out.println("--------------------------");
    }
}

public void imprimirListaDeAlunos() {
    System.out.println("Alunos do curso: " + nome);
    for (Aluno aluno : alunos) {
        System.out.println("Nome: " + aluno.getNome());
        System.out.println("Matrícula: " + aluno.getMatricula());
        System.out.println("Endereço: " + aluno.getEndereço());
        System.out.println("--------------------------");
    }
}

public void imprimirListaDeDisciplinas() {
    System.out.println("Disciplinas do curso: " + nome);
    for (Disciplina disciplina : disciplinas) {
        System.out.println("Nome: " + disciplina.getNome());
        System.out.println("Carga Horária: " + disciplina.getCh());
        System.out.println("Professor Responsável: " + disciplina.getProfessor().getNome());
        System.out.println("Titulação do Professor: " + disciplina.getProfessor().getTitulacao());
        System.out.println("Curso do Professor: " + disciplina.getProfessor().getCurso());
        System.out.println("Endereço do Professor: " + disciplina.getProfessor().getEndereço());
        System.out.println("--------------------------");
    }
}


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(ArrayList<Professor> professores) {
        this.professores = professores;
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }

    public ArrayList<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(ArrayList<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
}
