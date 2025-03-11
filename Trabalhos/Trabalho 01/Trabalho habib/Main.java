import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vault vault = new Vault();

        int opcao;
        do {
            System.out.println("\n== Sistema de Gerenciamento do Vault 101 ==");
            System.out.println("1: Cadastrar sobrevivente");
            System.out.println("2: Adicionar habilidade a um sobrevivente");
            System.out.println("3: Remover habilidade de um sobrevivente");
            System.out.println("4: Adicionar recurso ao Vault");
            System.out.println("5: Consumir recurso");
            System.out.println("6: Registrar missão");
            System.out.println("7: Adicionar sobrevivente a uma missão");
            System.out.println("8: Exibir sobreviventes do Vault");
            System.out.println("9: Exibir recursos do Vault");
            System.out.println("10: Exibir missões realizadas");
            System.out.println("11: Exibir sobreviventes cadastrados em uma missão");
            System.out.println("12: Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 01:
                    System.out.print("Nome do sobrevivente: ");
                    String nome = scanner.nextLine();
                    int idade;
                    do {
                        System.out.print("Idade do sobrevivente: ");
                        idade = scanner.nextInt();
                        scanner.nextLine();
                        if (idade < 0) {
                            System.out.println("A idade deve ser igual ou maior que 0.");
                        }
                    } while (idade < 0);
                    System.out.print("Identificador do sobrevivente: ");
                    String identificador = scanner.nextLine();
                    boolean idExistente = false;
                    for (Sobrevivente s : vault.getSobreviventes()) {
                        if (s.getIdentificador().equals(identificador)) {
                            idExistente = true;
                            break;
                        }
                    }

                    if (idExistente) {
                        System.out.println("Erro: Já existe um sobrevivente com o identificador fornecido.");
                    } else {
                        System.out.println("Escolha o status do sobrevivente:");
                        System.out.println("1: Ativo");
                        System.out.println("2: Doente");
                        System.out.println("3: Ferido");
                        System.out.println("4: Morto");
                        System.out.print("Opção: ");
                        int escolhaStatus = scanner.nextInt();
                        scanner.nextLine();

                        String status = "";
                        switch (escolhaStatus) {
                            case 1:
                                status = "Ativo";
                                break;
                            case 2:
                                status = "Doente";
                                break;
                            case 3:
                                status = "Ferido";
                                break;
                            case 4:
                                status = "Morto";
                                break;
                            default:
                                System.out.println("Opção inválida! Definindo status como 'Ativo'.");
                                status = "Ativo";
                        }

                        Sobrevivente novoSobrevivente = new Sobrevivente(nome, idade, identificador, status);
                        novoSobrevivente.setStatus(status);
                        vault.adicionarSobrevivente(novoSobrevivente);
                        System.out.println("Sobrevivente cadastrado com sucesso!");
                    }
                    break;

                case 02:
                    System.out.print("Identificador do sobrevivente: ");
                    String idHabilidade = scanner.nextLine();
                    Sobrevivente sobreviventeHabilidade = null;
                    for (Sobrevivente s : vault.getSobreviventes()) {
                        if (s.getIdentificador().equals(idHabilidade)) {
                            sobreviventeHabilidade = s;
                            break;
                        }
                    }

                    if (sobreviventeHabilidade != null) {
                        if (vault.verificarMorto(sobreviventeHabilidade)) {
                            System.out.println("Não é possível adicionar habilidade ao sobrevivente '"
                                    + sobreviventeHabilidade.getNome() + "' porque ele está morto.");
                            break;
                        }
                        if (sobreviventeHabilidade.getHabilidades().size() >= 3) {
                            System.out.println("Este sobrevivente já possui o número máximo de habilidades.");
                        } else {
                            System.out.println("Escolha uma habilidade:");
                            System.out.println("1. Engenharia (Habilidade de construir e reparar maquinas)");
                            System.out.println("2. Medicina (Habilidade de tratar ferimentos e doencas)");
                            System.out.println("3. Combate (habilidade de lutar com armas ou corpo a corpo)");
                            System.out.println("4. Exploração (habilidade de navegar e mapear áreas desconhecidas)");
                            System.out.println("5. Culinária (habilidade de preparar comida com recursos escassos)");
                            System.out.println("6. Diplomacia (habilidade de negociar com outros grupos)");
                            System.out.println("7. Hackeamento (habilidade de invadir sistemas de segurança)");
                            System.out.println("8. Furtividade  (habilidade de evitar detecção durante missões");
                            System.out.print("Opção: ");
                            int escolhaHabilidade = scanner.nextInt();
                            scanner.nextLine();
                            String habilidade = "";
                            switch (escolhaHabilidade) {
                                case 1:
                                    habilidade = "Engenharia";
                                    break;
                                case 2:
                                    habilidade = "Medicina";
                                    break;
                                case 3:
                                    habilidade = "Combate";
                                    break;
                                case 4:
                                    habilidade = "Exploração";
                                    break;
                                case 5:
                                    habilidade = "Culinária";
                                    break;
                                case 6:
                                    habilidade = "Diplomacia";
                                    break;
                                case 7:
                                    habilidade = "Hackeamento";
                                    break;
                                case 8:
                                    habilidade = "Furtividade";
                                    break;
                                default:
                                    System.out.println("Opção inválida!");
                            }
                            if (!habilidade.isEmpty()) {
                                if (sobreviventeHabilidade.getHabilidades().contains(habilidade)) {
                                    System.out.println("Este sobrevivente já possui a habilidade: " + habilidade);
                                } else {
                                    sobreviventeHabilidade.adicionarHabilidade(habilidade);
                                    System.out.println("Habilidade adicionada " + habilidade);
                                }
                            }
                        }
                    } else {
                        System.out.println("Sobrevivente não encontrado.");
                    }
                    break;
                case 3:
                    System.out.print("ID do sobrevivente: ");
                    String idRemoverHabilidade = scanner.nextLine();
                    Sobrevivente sobreviventeRemoverHabilidade = null;
                    for (Sobrevivente s : vault.getSobreviventes()) {
                        if (s.getIdentificador().equals(idRemoverHabilidade)) {
                            sobreviventeRemoverHabilidade = s;
                            break;
                        }
                    }
                    if (sobreviventeRemoverHabilidade != null) {
                        if (sobreviventeRemoverHabilidade.getHabilidades().isEmpty()) {
                            System.out.println("Este sobrevivente não possui habilidades para remover");
                        } else {
                            System.out.println("Habilidades disponíveis para remoção:");
                            for (String habilidade : sobreviventeRemoverHabilidade.getHabilidades()) {
                                System.out.println("- " + habilidade);
                            }
                            System.out.print("Digite a habilidade a remover: ");
                            String habilidadeRemover = scanner.nextLine();
                            if (sobreviventeRemoverHabilidade.getHabilidades().contains(habilidadeRemover)) {
                                sobreviventeRemoverHabilidade.removerHabilidade(habilidadeRemover);
                                System.out.println("Habilidade removida com sucesso");
                            } else {
                                System.out.println("Habilidade não encontrada");
                            }
                        }
                    } else {
                        System.out.println("Sobrevivente não encontrado");
                    }
                    break;
                case 4:
                    System.out.println("Escolha o tipo de recurso:");
                    System.out.println("1: Água (fundamental para hidratação)");
                    System.out.println("2: Comida (necessária para manter os sobreviventes ativos)");
                    System.out.println("3: Munição (usada para armas de defesa e combate)");
                    System.out.println("4: Remédios (usados para curar doenças e ferimentos)");
                    System.out.println("5: Partes Mecânicas (usadas para construir ou consertar itens no Vault)");
                    System.out.print("Opção: ");
                    int escolhaRecurso = scanner.nextInt();
                    scanner.nextLine();
                    String nomeRecurso = "";
                    switch (escolhaRecurso) {
                        case 1:
                            nomeRecurso = "Água";
                            break;
                        case 2:
                            nomeRecurso = "Comida";
                            break;
                        case 3:
                            nomeRecurso = "Munição";
                            break;
                        case 4:
                            nomeRecurso = "Remédios";
                            break;
                        case 5:
                            nomeRecurso = "Partes Mecânicas";
                            break;
                        default:
                            System.out.println("Opção inválida!");
                    }
                    if (!nomeRecurso.isEmpty()) {
                        System.out.print("Quantidade: ");
                        int quantidade = scanner.nextInt();
                        scanner.nextLine();
                        vault.adicionarRecurso(new Recurso(nomeRecurso, quantidade));
                        System.out.println("Recurso adicionado: " + nomeRecurso + " (Quantidade: " + quantidade + ")");
                    }
                    break;
                case 5:
                    System.out.println("Escolha o tipo de recurso a consumir:");
                    System.out.println("1: Água");
                    System.out.println("2: Comida");
                    System.out.println("3: Munição");
                    System.out.println("4: Remédios");
                    System.out.println("5: Partes Mecânicas");
                    System.out.print("Opção: ");
                    int escolhaConsumo = scanner.nextInt();
                    scanner.nextLine();
                    String recursoConsumir = "";
                    switch (escolhaConsumo) {
                        case 1:
                            recursoConsumir = "Água";
                            break;
                        case 2:
                            recursoConsumir = "Comida";
                            break;
                        case 3:
                            recursoConsumir = "Munição";
                            break;
                        case 4:
                            recursoConsumir = "Remédios";
                            break;
                        case 5:
                            recursoConsumir = "Partes Mecânicas";
                            break;
                        default:
                            System.out.println("Opção inválida!");
                    }
                    if (!recursoConsumir.isEmpty()) {
                        System.out.print("Quantidade a consumir: ");
                        int quantidadeConsumir = scanner.nextInt();
                        scanner.nextLine();
                        Recurso recurso = null;
                        for (Recurso r : vault.getRecursos()) {
                            if (r.getNome().equals(recursoConsumir)) {
                                recurso = r;
                                break;
                            }
                        }
                        if (recurso != null && recurso.getQuantidade() >= quantidadeConsumir) {
                            recurso.setQuantidade(recurso.getQuantidade() - quantidadeConsumir);
                            System.out.println("Recurso consumido: " + recursoConsumir + " (Quantidade: "
                                    + quantidadeConsumir + ")");
                        } else if (recurso != null) {
                            System.out.println("Quantidade insuficiente de " + recursoConsumir + ". Disponível: "
                                    + recurso.getQuantidade());
                        } else {
                            System.out.println("Recurso não encontrado.");
                        }
                    }
                    break;

                case 6:
                    System.out.print("Nome da missão: ");
                    String nomeMissao = scanner.nextLine();

                    if (vault.verificarMissaoExistente(vault, nomeMissao)) {
                        System.out.println("Erro: Já existe uma missão com este nome.");
                    } else {
                        System.out.print("Objetivo: ");
                        String objetivo = scanner.nextLine();
                        System.out.print("Local: ");
                        String local = scanner.nextLine();

                        System.out.println("Escolha o status da missão:");
                        System.out.println("1: Em andamento");
                        System.out.println("2: Sucesso");
                        System.out.println("3: Fracasso");
                        System.out.print("Opção: ");
                        int statusOpcao = scanner.nextInt();
                        scanner.nextLine();

                        String statusMissao = "";
                        switch (statusOpcao) {
                            case 1:
                                statusMissao = "Em andamento";
                                break;
                            case 2:
                                statusMissao = "Sucesso";
                                break;
                            case 3:
                                statusMissao = "Fracasso";
                                break;
                            default:
                                System.out.println("Opção inválida! A missão será marcada como 'Em andamento'.");
                                statusMissao = "Em andamento";
                        }

                        Missao novaMissao = new Missao(nomeMissao, objetivo, local);
                        novaMissao.setStatus(statusMissao);

                        if (statusMissao.equals("Sucesso")) {
                            boolean adicionarMais = true;
                            while (adicionarMais) {
                                System.out.println("Escolha o tipo de recurso coletado na missão:");
                                System.out.println("1: Água");
                                System.out.println("2: Comida");
                                System.out.println("3: Munição");
                                System.out.println("4: Remédios");
                                System.out.println("5: Partes Mecânicas");
                                System.out.print("Opção: ");
                                int recursoEscolhido = scanner.nextInt();
                                scanner.nextLine();

                                String recursoColetado = "";
                                switch (recursoEscolhido) {
                                    case 1:
                                        recursoColetado = "Água";
                                        break;
                                    case 2:
                                        recursoColetado = "Comida";
                                        break;
                                    case 3:
                                        recursoColetado = "Munição";
                                        break;
                                    case 4:
                                        recursoColetado = "Remédios";
                                        break;
                                    case 5:
                                        recursoColetado = "Partes Mecânicas";
                                        break;
                                    default:
                                        System.out.println("Opção inválida! Nenhum recurso coletado.");
                                }

                                if (!recursoColetado.isEmpty()) {
                                    System.out.print("Quantidade coletada: ");
                                    int quantidadeColetada = scanner.nextInt();
                                    scanner.nextLine();
                                    novaMissao
                                            .adicionarRecursoColetado(new Recurso(recursoColetado, quantidadeColetada));
                                    System.out.println("Recurso coletado: " + recursoColetado + " (Quantidade: "
                                            + quantidadeColetada + ")");
                                }

                                System.out.print("Deseja adicionar outro recurso? (1: Sim, 2: Não): ");
                                int continuar = scanner.nextInt();
                                scanner.nextLine();
                                adicionarMais = continuar == 1;
                            }
                        }

                        vault.adicionarMissao(novaMissao);
                        System.out.println("Missão registrada com sucesso!");
                    }
                    break;
                case 7:
                    System.out.print("Nome da missão: ");
                    String nomeMissaoAdicionar = scanner.nextLine();
                    Missao missao = null;
                    for (Missao m : vault.getMissoes()) {
                        if (m.getNome().equals(nomeMissaoAdicionar)) {
                            missao = m;
                            break;
                        }
                    }

                    if (missao != null) {
                        if (missao.getStatus().equals("Fracasso")) {
                            System.out.println(
                                    "Não é possível adicionar sobreviventes a uma missão marcada como 'Fracasso'.");
                        } else if (missao.getSobreviventes().size() < 5) {
                            System.out.print("ID do sobrevivente: ");
                            String idSobreviventeMissao = scanner.nextLine();
                            Sobrevivente sobrevivente = null;
                            for (Sobrevivente s : vault.getSobreviventes()) {
                                if (s.getIdentificador().equals(idSobreviventeMissao)) {
                                    sobrevivente = s;
                                    break;
                                }
                            }

                            if (sobrevivente != null) {
                                if (sobrevivente.getStatus().equals("Morto")) {
                                    System.out.println("Não é possível adicionar o sobrevivente '"
                                            + sobrevivente.getNome() + "' porque está morto.");
                                } else if (sobrevivente.getStatus().equals("Doente")) {
                                    System.out.println("Não é possível adicionar o sobrevivente '"
                                            + sobrevivente.getNome() + "' porque está doente.");
                                } else if (missao.getSobreviventes().contains(idSobreviventeMissao)) {
                                    System.out.println("Este sobrevivente já está na missão.");
                                } else {
                                    missao.adicionarSobrevivente(idSobreviventeMissao);
                                    System.out.println("Sobrevivente adicionado à missão com sucesso!");
                                }
                            } else {
                                System.out.println("Sobrevivente não encontrado.");
                            }
                        } else {
                            System.out.println("A missão já atingiu o limite de 5 sobreviventes.");
                        }
                    } else {
                        System.out.println("Missão não encontrada.");
                    }
                    break;

                case 8:
                    System.out.println("Lista de Sobreviventes no Vault:");
                    for (Sobrevivente s : vault.getSobreviventes()) {
                        System.out.println("ID: " + s.getIdentificador() + " \nNome: " + s.getNome()
                                + " \nStatus do sobrevivente: " + s.getStatus());
                    }
                    break;

                case 9:
                    System.out.println("Lista de recursos no Vault:");
                    for (Recurso r : vault.getRecursos()) {
                        System.out.println(" Recursos: " + r.getNome() + " \nQuantidades: " + r.getQuantidade());
                    }

                case 10:
                    System.out.println("Lista de missões registradas:");
                    for (Missao m : vault.getMissoes()) {
                        System.out.println("- Nome: " + m.getNome() + ", Objetivo: " + m.getObjetivo() + ", Local: "
                                + m.getLocal() + ", Status: " + m.getStatus());
                        if (m.getStatus().equals("Sucesso") && !m.getRecursosColetados().isEmpty()) {
                            System.out.println("  Recursos coletados:");
                            for (Recurso r : m.getRecursosColetados()) {
                                System.out.println("    - " + r.getNome() + ": " + r.getQuantidade());
                            }
                        }
                    }
                    break;

                case 11:
                    System.out.println("Nome da missao:");
                    String nomeMissaoExibir = scanner.nextLine();
                    Missao missaoExibir = null;
                    for (Missao m : vault.getMissoes()) {
                        if (m.getNome().equals(nomeMissaoExibir)) {
                            missaoExibir = m;
                            break;
                        }
                    }
                    if (missaoExibir != null) {
                        System.out.println("Sobreviventes cadastrados na missao: " + missaoExibir.getNome() + "");
                        missaoExibir.imprimirSobreviventesMissao();
                    } else {
                        System.out.println("Missao nao encontrada");
                    }
                    break;

                case 12:
                    System.out.println("Saindo do sistema");
                    break;
                default:
                    System.out.println("Opcao invalida");
            }

        } while (opcao != 12);

        scanner.close();

    }
}
