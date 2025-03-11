import java.util.Scanner;

public class GerenciamentoPacotes {
    public static void main(String[] args) {

        ListaClientes listaClientes = new ListaClientes();
        FilaEntradaPacotes filaEntrada = new FilaEntradaPacotes();
        FilaPrioridadePacotes filaPrioridade = new FilaPrioridadePacotes();
        HistoricoPacotes historico = new HistoricoPacotes();

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu de Gerenciamento de Pacotes:");
            System.out.println("1. Adicionar Cliente");
            System.out.println("2. Registrar Pacote");
            System.out.println("3. Processar Próximo Pacote");
            System.out.println("4. Exibir Pacotes na Fila de Entrada");
            System.out.println("5. Exibir Pacotes na Fila de Prioridade");
            System.out.println("6. Exibir Histórico de Pacotes");
            System.out.println("7. Exibir Lista de Clientes");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do cliente: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o CPF do cliente: ");
                    String cpf = scanner.nextLine();
                    listaClientes.adicionarClientes(new Cliente(nome, cpf));
                    System.out.println("Cliente adicionado com sucesso!");
                    break;

                case 2:
                    System.out.print("Digite o código do pacote: ");
                    int codigo = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Digite a descrição do pacote: ");
                    String descricao = scanner.nextLine();
                    System.out.print("Digite a prioridade do pacote (1 = urgente, 2 = normal): ");
                    int prioridade = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Digite o CPF do cliente associado: ");
                    String cpfCliente = scanner.nextLine();

                    Cliente cliente = listaClientes.buscarClientes(cpfCliente);
                    if (cliente != null) {
                        Pacote pacote = new Pacote(codigo, descricao, prioridade, cpfCliente);
                        if (prioridade == 1) {
                            filaPrioridade.adicionarPacote(pacote);
                        } else {
                            filaEntrada.adicionarPacote(pacote);
                        }
                        System.out.println("Pacote registrado com sucesso!");
                    } else {
                        System.out.println("CPF não encontrado. Cadastre o cliente primeiro.");
                    }
                    break;

                case 3:
                    Pacote pacote;
                    if (!filaPrioridade.isVazia()) {
                        pacote = filaPrioridade.processarPacote();
                    } else if (!filaEntrada.isVazia()) {
                        pacote = filaEntrada.processarPacote();
                    } else {
                        System.out.println("Nenhum pacote para processar.");
                        break;
                    }
                    historico.adicionarAoHistorico(pacote);
                    System.out.println("Pacote processado e adicionado ao histórico: " + pacote);
                    break;

                case 4:
                    filaEntrada.exibirPacotes();
                    break;

                case 5:
                    filaPrioridade.exibirPacotes();
                    break;

                case 6:
                    historico.exibirHistorico();
                    break;

                case 7:
                    listaClientes.exibirClientes();
                    break;

                case 8:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 8);

        scanner.close();
    }
}
