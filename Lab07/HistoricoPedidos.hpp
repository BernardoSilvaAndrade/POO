#pragma once
#include "NodoPedido.hpp"
#include "ListaClientes.hpp"

class HistoricoPedidos
{
private:
    NodoPedido *inicio;

public:
    HistoricoPedidos();
    void adicionarAoHistorico(Pedido *pedido);
    void exibirHistorico(ListaClientes *listaClientes);
};

