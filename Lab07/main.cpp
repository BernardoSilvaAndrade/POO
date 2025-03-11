#include <iostream>
#include "ListaClientes.hpp"
#include "FilaPedidos.hpp"
#include "HistoricoPedidos.hpp"
using namespace std;

int main() {
    ListaClientes listaClientes;
    FilaPedidos filaPedidos;
    HistoricoPedidos historico;
    int opcao;

    do {
        cout << "\nMenu:\n";
        cout << "1. Adicionar nova pessoa\n";
        cout << "2. Adicionar novo pedido\n";
        cout << "3. Preparar proximo pedido\n";
        cout << "4. Exibir pedidos em espera\n";
        cout << "5. Exibir historico de pedidos\n";
        cout << "6. Exibir lista de clientes\n";
        cout << "7. Sair\n";
        cout << "Escolha uma opcao: ";
        cin >> opcao;

        switch (opcao) {
            case 1: {
                string nome, cpf;
                cout << "Digite o nome: ";
                cin.ignore();
                getline(cin, nome);
                cout << "Digite o CPF: ";
                cin >> cpf;
                listaClientes.adicionarCliente(nome, cpf);
                break;
            }
            case 2: {
                string descricao, cpf;
                int tempo, codigo;
                cout << "Digite o CPF do cliente: ";
                cin >> cpf;
                Pessoa *cliente = listaClientes.buscarCliente(cpf);
                if (cliente == nullptr) {
                    cout << "Cliente nao encontrado!\n";
                    break;
                }
                cout << "Digite o codigo do pedido: ";
                cin >> codigo;
                cout << "Digite a descricao do pedido: ";
                cin.ignore();
                getline(cin, descricao);
                cout << "Digite o tempo estimado de preparo (minutos): ";
                cin >> tempo;
                Pedido *pedido = new Pedido(codigo, descricao, tempo, cpf);
                filaPedidos.adicionarPedido(pedido);
                break;
            }
            case 3: {
                Pedido *pedido = filaPedidos.removerPedido();
                if (pedido != nullptr) {
                    historico.adicionarAoHistorico(pedido);
                }
                break;
            }
            case 4:
                filaPedidos.exibirPedidos(&listaClientes);
                break;
            case 5:
                historico.exibirHistorico(&listaClientes);
                break;
            case 6:
                listaClientes.exibirCliente();
                break;
            case 7:
                cout << "Encerrando o programa...\n";
                break;
            default:
                cout << "Opcao invalida!\n";
                break;
        }
    } while (opcao != 7);

    return 0;
}