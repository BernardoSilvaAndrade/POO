import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		ArrayList<Funcionario> funcionarios = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("\nMenu:");
			System.out.println("1. Adicionar Gerente");
			System.out.println("2. Adicionar Desenvolvedor");
			System.out.println("3. Adicionar TechLead");
			System.out.println("4. Listar Funcionarios");
			System.out.println("5. Sair");
			System.out.print("Escolha uma opcao: ");
			int opcao = scanner.nextInt();
			scanner.nextLine(); // Consumir a quebra de linha

			if (opcao == 5)
				break;

			switch (opcao) {
			case 1:

				System.out.print("Nome: ");
				String nome = scanner.nextLine();
				System.out.print("Salario base: ");
				double salarioBase = scanner.nextDouble();

				System.out.print("Numero de equipes: ");
				int numeroDeEquipes = scanner.nextInt();
				Gerente gerente = new Gerente(nome, salarioBase, numeroDeEquipes);
				funcionarios.add(gerente);
				break;
			case 2:

				System.out.print("Nome: ");
				String nome1 = scanner.nextLine();
				System.out.print("Salario base: ");
				double salarioBase1 = scanner.nextDouble();

				scanner.nextLine(); // Consumir a quebra de linha
				System.out.print("Linguagem principal: ");
				String linguagemPrincipal = scanner.nextLine();
				Desenvolvedor desenvolvedor = new Desenvolvedor(nome1, salarioBase1, linguagemPrincipal);
				funcionarios.add(desenvolvedor);
				break;
			case 3:

				System.out.print("Nome: ");
				String nome2 = scanner.nextLine();
				System.out.print("Salario base: ");
				double salarioBase2 = scanner.nextDouble();

				System.out.print("Numero de equipes: ");
				int numeroDeEquipesTechLead = scanner.nextInt();
				scanner.nextLine(); // Consumir a quebra de linha
				System.out.print("Linguagem principal: ");
				String linguagemPrincipalTechLead = scanner.nextLine();
				System.out.print("Projetos em andamento: ");
				int projetosEmAndamento = scanner.nextInt();
				TechLead techLead = new TechLead(nome2, salarioBase2, numeroDeEquipesTechLead,
				                                 linguagemPrincipalTechLead, projetosEmAndamento);
				funcionarios.add(techLead);
				break;
			case 4:
				System.out.println("\nFuncionarios cadastrados:");
				if (funcionarios.isEmpty()) {
					System.out.println("Nenhum funcionario cadastrado.");
				} else {
					for (Funcionario f : funcionarios) {
						System.out.println(f.descricao());
					}
				}

				break;
			default:
				System.out.println("Opcao invalida!");
			}
		}

		scanner.close();
	}
}
