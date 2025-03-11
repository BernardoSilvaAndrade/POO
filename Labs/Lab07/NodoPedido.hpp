#pragma once
#include "Pedido.hpp"
#include <iostream>

class NodoPedido
{
public:
    Pedido *pedido;
    NodoPedido *prox;

    NodoPedido(Pedido *pedido);
};
