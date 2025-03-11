#include "FilaPedidos.hpp"
#include "NodoPedido.hpp"
#include <iostream>
using namespace std;

FilaPedidos::FilaPedidos() : frente(nullptr), tras(nullptr) {}

void FilaPedidos::adicionarPedido(Pedido *pedido)
{
    NodoPedido *novoNodo = new NodoPedido(pedido);
    if (tras == nullptr)
    {
        frente = tras = novoNodo;
    }
    else
    {
        tras->prox = novoNodo;
        tras = novoNodo;
    }
    cout << "Pedido adicionado: " << pedido->getDescricaoPedido() << "\n";
}
Pedido *FilaPedidos::removerPedido()
{
    if (frente == nullptr)
    {
        cout << "Fila de pedidos vazia!\n";
        return nullptr;
    }
    NodoPedido *temp = frente;
    Pedido *pedido = temp->pedido;
    frente = frente->prox;
    if (frente == nullptr)
    {
        tras = nullptr;
    }
    delete temp;
    return pedido;
}

void FilaPedidos::exibirPedidos(ListaClientes *listaClientes)
{
    NodoPedido *atual = frente;
    while (atual != nullptr)
    {
        Pedido *pedido = atual->pedido;
        Pessoa *cliente = listaClientes->buscarCliente(pedido->getCpf());
        if (cliente != nullptr)
        {
            cout << "Codigo: " << pedido->getCodigoPedido() << ", Descricao: " << pedido->getDescricaoPedido()
                 << ", Cliente: " << cliente->nome << " (CPF: " << cliente->cpf << ")\n";
        }
        atual = atual->prox;
    }
}

bool FilaPedidos::filaVazia()
{
    return frente == nullptr;
}
