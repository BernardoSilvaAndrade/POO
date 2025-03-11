import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FilaAtendimento fila = new FilaAtendimento();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println(
                    "\n1. Adicionar paciente\n2. Atender paciente\n3. Exibir fila\n4. Verificar se a fila está vazia\n0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do paciente: ");
                    String nome = scanner.nextLine();
                    System.out.print("Prioridade (1-Alta, 2-Média, 3-Baixa): ");
                    int prioridade = scanner.nextInt();
                    fila.adicionarPaciente(nome, prioridade);
                    break;
                case 2:
                    fila.atenderPaciente();
                    break;
                case 3:
                    fila.exibirFila();
                    break;
                case 4:
                    System.out.println(fila.estaVazia() ? "Fila vazia" : "Ainda há pacientes na fila");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }
}
