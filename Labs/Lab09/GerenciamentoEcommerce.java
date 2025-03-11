import java.util.Scanner;

public class GerenciamentoEcommerce {
    public static void main(String[] args) {
        ListaProdutos<Produto> listaProdutos = new ListaProdutos<>();
        FilaPedidos<Pedido> filaPedidos = new FilaPedidos<>();
        HistoricoPedidos<Pedido> historicoPedidos = new HistoricoPedidos<>();
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Cadastrar Produto");
            System.out.println("2. Criar Pedido");
            System.out.println("3. Processar Pedido");
            System.out.println("4. Listar Produtos");
            System.out.println("5. Listar Pedidos Pendentes");
            System.out.println("6. Exibir Histórico de Pedidos");
            System.out.println("7. Sair");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Codigo do produto: ");
                    int codigo = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Descricao do produto: ");
                    String descricao = scanner.nextLine();
                    System.out.print("Preço (pressione Enter para usar R$10.00): ");
                    String precoInput = scanner.nextLine();
                    double preco;
                    if (precoInput.isEmpty()) {
                        preco = 10.00;
                    } else {
                        preco = Double.parseDouble(precoInput);
                    }
                    System.out.print("Estoque inicial (pressione Enter para usar 5 unidades): ");
                    String estoqueInput = scanner.nextLine();
                    int estoque;
                    if (estoqueInput.isEmpty()) {
                        estoque = 5;
                    } else {
                        estoque = Integer.parseInt(estoqueInput);
                    }

                    listaProdutos.adicionarProduto(new Produto(codigo, descricao, preco, estoque));
                    System.out.println("Produto cadastrado!");
                    break;

                case 2:
                    if (listaProdutos.ListaVazio()) {
                        System.out.println("Nenhum produto disponível para criar um pedido!");
                        return;
                    }

                    System.out.print("Digite o nome do cliente: ");
                    String clienteNome = scanner.nextLine();

                    Pedido pedido = new Pedido(filaPedidos.size() + 1, clienteNome);
                    int opcaoProduto;

                    do {
                        System.out.println("\nProdutos disponíveis:");
                        listaProdutos.exibirProdutos();

                        System.out.print("Digite o codigo do produto: ");
                        int index = scanner.nextInt();
                        System.out.print("Quantidade: ");
                        int quantidade = scanner.nextInt();
                        scanner.nextLine();

                        try {
                            Produto produto = listaProdutos.buscarProduto(index);
                            pedido.adicionarProduto(produto, quantidade);
                        } catch (Exception e) {
                            System.out.println("Erro: " + e.getMessage());
                        }

                        System.out.print("Adicionar outro produto? (1 - Sim, 2 - Não): ");
                        opcaoProduto = scanner.nextInt();
                        scanner.nextLine();
                    } while (opcaoProduto == 1);

                    if (!pedido.estaVazio()) {
                        filaPedidos.adicionarPedido(pedido);
                        System.out.println("Pedido adicionado à fila!");
                    } else {
                        System.out.println("Pedido vazio! Não foi adicionado.");
                    }
                    break;

                case 3:
                    if (!filaPedidos.estaVazia()) {
                        Pedido pedidoProcessado = filaPedidos.removerPedido();
                        historicoPedidos.adicionarAoHistorico(pedidoProcessado);
                        System.out.println("Pedido processado!");
                    } else {
                        System.out.println("Nenhum pedido na fila.");
                    }
                    break;

                case 4:
                    listaProdutos.exibirProdutos();
                    break;

                case 5:
                    filaPedidos.exibirFila();
                    break;

                case 6:
                    historicoPedidos.exibirHistorico();
                    break;

                case 7:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 7);

        scanner.close();
    }
}
