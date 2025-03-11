#pragma once
#include "ListaClientes.hpp"
#include "NodoPedido.hpp"

class FilaPedidos
{
private:
    NodoPedido *frente;
    NodoPedido *tras;

public:
    FilaPedidos();
    void adicionarPedido(Pedido *pedido);
    Pedido *removerPedido();
    void exibirPedidos(ListaClientes *listaClientes);
    bool filaVazia();
};
