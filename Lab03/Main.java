import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Curso curso = null;

        while (true) {
            System.out.println("\nMenu de Opções:");
            System.out.println("0 - Sair");
            System.out.println("1 - Criar Curso");
            System.out.println("2 - Cadastrar Professor");
            System.out.println("3 - Cadastrar Aluno");
            System.out.println("4 - Cadastrar Disciplina");
            System.out.println("5 - Listar Professores");
            System.out.println("6 - Listar Alunos");
            System.out.println("7 - Listar Disciplinas");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 0:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                case 1:
                    System.out.print("Digite o nome do curso: ");
                    String nomeCurso = scanner.nextLine();
                    curso = new Curso(nomeCurso);
                    System.out.println("Curso criado com sucesso");
                    break;

                case 2:
                    if (curso == null) {
                        System.out.println("Crie um curso primeiro");
                        break;
                    }
                    System.out.print("Titulação: ");
                    String titulacao = scanner.nextLine();
                    System.out.print("Curso: ");
                    String cursop = scanner.nextLine();
                    System.out.print("Nome do Professor: ");
                    String nomeProfessor = scanner.nextLine();
                    System.out.print("Endereço: ");
                    String enderecop = scanner.nextLine();
                    
                    curso.cadastrarProfessor(new Professor(titulacao,cursop,nomeProfessor,enderecop));
                    System.out.println("Professor cadastrado com sucesso!");
                    break;

                case 3:
                    if (curso == null) {
                        System.out.println("Crie um curso primeiro!");
                        break;
                    }
                    
                    System.out.print("Matrícula: ");
                    int matriculay = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Nome do Aluno: ");
                    String nomeAluno = scanner.nextLine();
                    System.out.print("Endereço: ");
                    String enderecoy = scanner.nextLine();
                    curso.cadastrarAluno(new Aluno(matriculay ,nomeAluno, enderecoy));
                    System.out.println("Aluno cadastrado com sucesso");
                    break;

                case 4:
                    if (curso == null) {
                        System.out.println("Crie um curso primeiro!");
                        break;
                    }
                    if (curso.getProfessores().isEmpty()) {
                        System.out.println("Cadastre professores antes de criar disciplinas!");
                        break;
                    }
                    System.out.print("Nome da Disciplina: ");
                    String nomeDisciplina = scanner.nextLine();
                    System.out.print("Carga Horária: ");
                    int cargaHoraria = scanner.nextInt();
                    scanner.nextLine();
                     System.out.print("Titulação: ");
                    String titulacao1 = scanner.nextLine();
                    System.out.print("Curso: ");
                    String curso1 = scanner.nextLine();
                    System.out.print("Nome do Professor responsavel: ");
                    String nomeProf = scanner.nextLine();
                    System.out.print("Endereço: ");
                    String endereco1 = scanner.nextLine();
                    curso.cadastrarDisciplina(new Disciplina(nomeDisciplina ,cargaHoraria,new Professor(titulacao1,curso1,nomeProf,endereco1)));

                    System.out.println("Disciplina cadastrada com sucesso!");
                    
                    break;

                case 5:
                    if (curso == null || curso.getProfessores().isEmpty()) {
                        System.out.println("Nenhum professor cadastrado!");
                    } else {
                        curso.imprimirListaDeProfessores();
                    }
                    break;

                case 6:
                    if (curso == null || curso.getAlunos().isEmpty()) {
                        System.out.println("Nenhum aluno cadastrado!");
                    } else {
                        curso.imprimirListaDeAlunos();
                    }
                    break;

                case 7:
                    if (curso == null || curso.getDisciplinas().isEmpty()) {
                        System.out.println("Nenhuma disciplina cadastrada!");
                    } else {
                        curso.imprimirListaDeDisciplinas();
                    }
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
