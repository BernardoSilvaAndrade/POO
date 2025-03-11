#include <iostream>
#include <vector>
#include <string>
#include <memory>
#include "Produto.hpp"
#include "Vestuario.hpp"
#include "Eletronico.hpp"
#include "Cliente.hpp"

using namespace std;

vector<Cliente> clientes;

Cliente* encontrarClientePorCPF(const string& CPF) {
    for (auto& cliente : clientes) {
        if (cliente.getCPF() == CPF) {
            return &cliente;
        }
    }
    return nullptr;
}

void cadastrarCliente() {
    string nome, CPF;
    cout << "Digite o nome do cliente: ";
    cin.ignore();
    getline(cin, nome);
    cout << "Digite o CPF do cliente: ";
    getline(cin, CPF);

    if (encontrarClientePorCPF(CPF)) {
        cout << "Cliente já cadastrado.\n";
        return;
    }

    clientes.emplace_back(nome, CPF);
    cout << "Cliente cadastrado com sucesso!\n";
}

void adicionarProdutoACliente() {
    string CPF;
    cout << "Digite o CPF do cliente: ";
    cin.ignore();
    getline(cin, CPF);

    Cliente* cliente = encontrarClientePorCPF(CPF);
    if (!cliente) {
        cout << "Cliente não encontrado.\n";
        return;
    }

    int tipoProduto;
    cout << "Escolha o tipo de produto:\n1. Eletrônico\n2. Vestuário\nOpção: ";
    cin >> tipoProduto;

    string nome;
    double preco;
    cout << "Digite o nome do produto: ";
    cin.ignore();
    getline(cin, nome);
    cout << "Digite o preço do produto: ";
    cin >> preco;

    if (tipoProduto == 1) {
        int garantia;
        cout << "Digite a garantia (em anos): ";
        cin >> garantia;
        Produto produto(Eletronico(nome, preco, garantia));
        cliente->adicionaCompra(produto);
    } else if (tipoProduto == 2) {
        string tamanho;
        cout << "Digite o tamanho: ";
        cin >> tamanho;
        Produto produto(Vestuario(nome, preco, tamanho));
        cliente->adicionaCompra(produto);
    } else {
        cout << "Opção inválida.\n";
        return;
    }

    cout << "Produto adicionado com sucesso!\n";
}

void exibirDetalhesCliente() {
    string CPF;
    cout << "Digite o CPF do cliente: ";
    cin.ignore();
    getline(cin, CPF);

    Cliente* cliente = encontrarClientePorCPF(CPF);
    if (!cliente) {
        cout << "Cliente não encontrado.\n";
        return;
    }

    cout << cliente->getDetalhes() << endl;
}

int main() {
    int opcao;
    do {
        cout << "Menu de Opções:\n";
        cout << "1. Cadastrar Cliente\n";
        cout << "2. Adicionar Produto a um Cliente\n";
        cout << "3. Exibir Detalhes de um Cliente\n";
        cout << "4. Sair\n";
        cout << "Escolha uma opção: ";
        cin >> opcao;

        switch (opcao) {
            case 1:
                cadastrarCliente();
                break;
            case 2:
                adicionarProdutoACliente();
                break;
            case 3:
                exibirDetalhesCliente();
                break;
            case 4:
                cout << "Encerrando o programa.\n";
                break;
            default:
                cout << "Opção inválida. Tente novamente.\n";
        }
    } while (opcao != 4);

    return 0;
}
