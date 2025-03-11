#include "NodoPedido.hpp"
#include <iostream>

using namespace std;

NodoPedido::NodoPedido(Pedido *pedido) : pedido(pedido), prox(nullptr) {}