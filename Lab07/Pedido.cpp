#include "Pedido.hpp"

Pedido::Pedido(int codigoPedido, std::string descricaoPedido, int tempoEstimado, std::string cpf)
    : codigoPedido(codigoPedido), descricaoPedido(descricaoPedido), tempoEstimado(tempoEstimado), cpf(cpf) {}

string Pedido::getDescricaoPedido()
{
    return descricaoPedido;
}

int Pedido::getCodigoPedido()
{
    return codigoPedido;
}

int Pedido::getTempoEstimado()
{
    return tempoEstimado;
}

string Pedido::getCpf()
{
    return cpf;
}
