#include "HistoricoPedidos.hpp"
#include "NodoPedido.hpp"
#include "Pedido.hpp"
#include "Pessoa.hpp"
#include <iostream>
using namespace std;

HistoricoPedidos::HistoricoPedidos() : inicio(nullptr) {}

void HistoricoPedidos::adicionarAoHistorico(Pedido *pedido)
{
    NodoPedido *novoNodo = new NodoPedido(pedido);
    novoNodo->prox = inicio;
    inicio = novoNodo;
    cout << "Pedido concluido: " << pedido->getDescricaoPedido() << "\n";
}

void HistoricoPedidos::exibirHistorico(ListaClientes *listaClientes)
{
    NodoPedido *atual = inicio;
    while (atual != nullptr)
    {
        Pedido *pedido = atual->pedido;
        Pessoa *cliente = listaClientes->buscarCliente(pedido->getCpf());
        if (cliente != nullptr)
        {
            cout << "Codigo: " << pedido->getCodigoPedido()
                 << ", Descricao: " << pedido->getDescricaoPedido()
                 << ", Cliente: " << cliente->nome
                 << " CPF: " << cliente->cpf << "\n";
        }
        atual = atual->prox;
    }
}
