#pragma once
#include <string>
#include "NodoPessoa.hpp"

using namespace std;

class ListaClientes
{
private:
    NodoPessoa *inicio;

public:
    ListaClientes();
    void adicionarCliente(string nome, string cpf);
    Pessoa *buscarCliente(string cpf);
    void exibirCliente();
};
