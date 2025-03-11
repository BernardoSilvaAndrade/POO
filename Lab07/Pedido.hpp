#pragma once
#include <string>

using namespace std;
class Pedido
{
private:
    int codigoPedido;
    string descricaoPedido;
    int tempoEstimado;
    string cpf;

public:
    Pedido(int codigoPedido, string descricaoPedido, int tempoEstimado, string cpf);
    int getCodigoPedido();
    string getDescricaoPedido();
    int getTempoEstimado();
    string getCpf();
};
