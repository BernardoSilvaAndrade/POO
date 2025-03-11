import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Motorista> motoristas = new ArrayList<>();
        ArrayList<Veiculo> veiculos = new ArrayList<>();
        ArrayList<Viagem> viagens = new ArrayList<>();
        int opcao;

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Cadastrar Motorista");
            System.out.println("2. Cadastrar Veiculo");
            System.out.println("3. Registrar Viagem");
            System.out.println("4. Exibir Detalhes de uma Viagem");
            System.out.println("5. Excluir Motorista");
            System.out.println("6. Excluir Veiculo");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opcao: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("\nCadastro do Motorista:");
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Habilitacao (A, B, C, D, E): ");
                    String habilitacao = scanner.nextLine();

                    motoristas.add(new Motorista(nome, cpf, habilitacao));
                    System.out.println("Motorista cadastrado");
                    break;

                case 2:
                    System.out.println("\nCadastro do Veiculo:");
                    System.out.print("CPF do Motorista: ");
                    cpf = scanner.nextLine();

                    Motorista motorista = null;
                    for (Motorista m : motoristas) {
                        if (m.getCpf().equals(cpf)) {
                            motorista = m;
                            break;
                        }
                    }

                    if (motorista == null) {
                        System.out.println("Motorista nao encontrado");
                        break;
                    }

                    System.out.print("Tipo de Veiculo (1-Moto, 2-Carro, 3-Caminhao): ");
                    int tipo = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Placa: ");
                    String placa = scanner.nextLine();
                    System.out.print("Modelo: ");
                    String modelo = scanner.nextLine();

                    Veiculo veiculo = null;

                    if (tipo == 1) {
                        if (!motorista.getHabilitacao().equalsIgnoreCase("A")) {
                            System.out.println(
                                    "Habilitacao incompativel!");
                            break;
                        }
                        System.out.print("Cilindradas da Moto: ");
                        int cilindradas = scanner.nextInt();
                        veiculo = new Moto(cilindradas, placa, modelo);

                    } else if (tipo == 2) {
                        if (!motorista.getHabilitacao().equalsIgnoreCase("B")) {
                            System.out.println(
                                    "Habilitacao incompativel!");
                            break;
                        }
                        System.out.print("Quantidade de Assentos do Carro: ");
                        int assentos = scanner.nextInt();
                        veiculo = new Carro(assentos, placa, modelo);

                    } else if (tipo == 3) {
                        if (!motorista.getHabilitacao().equalsIgnoreCase("C") &&
                                !motorista.getHabilitacao().equalsIgnoreCase("D") &&
                                !motorista.getHabilitacao().equalsIgnoreCase("E")) {
                            System.out.println(
                                    "Habilitacao incompativel!");
                            break;
                        }
                        System.out.print("Capacidade de Carga do Caminhão: ");
                        double capacidadeCarga = scanner.nextDouble();
                        veiculo = new Caminhao(capacidadeCarga, placa, modelo);

                    } else {
                        System.out.println("Tipo de veiculo invalido!");
                        break;
                    }

                    veiculos.add(veiculo);
                    System.out.println("Veiculo cadastrado com sucesso!");
                    break;

                case 3:
                    System.out.println("\nRegistro da Viagem:");
                    System.out.print("CPF do Motorista: ");
                    cpf = scanner.nextLine();

                    motorista = null;
                    for (Motorista m : motoristas) {
                        if (m.getCpf().equals(cpf)) {
                            motorista = m;
                            break;
                        }
                    }

                    if (motorista == null) {
                        System.out.println("Motorista nao encontrado!");
                        break;
                    }

                    System.out.print("Placa do Veiculo: ");
                    placa = scanner.nextLine();

                    veiculo = null;
                    for (Veiculo v : veiculos) {
                        if (v.getPlaca().equals(placa)) {
                            veiculo = v;
                            break;
                        }
                    }

                    if (veiculo == null) {
                        System.out.println("Veiculo nao encontrado!");
                        break;
                    }

                    System.out.print("Distancia da Viagem (em km): ");
                    double distancia = scanner.nextDouble();

                    Viagem viagem = new Viagem(motorista, veiculo, distancia);
                    viagens.add(viagem);
                    System.out.println("Viagem registrada com sucesso!");
                    break;

                case 4:
                    if (viagens.isEmpty()) {
                        System.out.println("\nNenhuma viagem registrada!");
                    } else {
                        System.out.println("\nLista de Viagens:");
                        for (Viagem v : viagens) {
                            System.out.println(v.getDetalhes());
                        }
                    }
                    break;

                case 5:
                    System.out.print("\nDigite o CPF do motorista a ser excluído: ");
                    cpf = scanner.nextLine();
                    boolean motoristaRemovido = motoristas.removeIf(m -> m.getCpf().equals(cpf));
                    if (motoristaRemovido) {
                        System.out.println("Motorista removido com sucesso!");
                    } else {
                        System.out.println("Motorista nao encontrado!");
                    }
                    break;

                case 6:
                    System.out.print("\nDigite a placa do veículo a ser excluído: ");
                    placa = scanner.nextLine();
                    boolean veiculoRemovido = veiculos.removeIf(v -> v.getPlaca().equals(placa));
                    if (veiculoRemovido) {
                        System.out.println("Veiculo removido com sucesso!");
                    } else {
                        System.out.println("Veiculo nao encontrado!");
                    }
                    break;

                case 7:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 7);

        scanner.close();
    }
}
