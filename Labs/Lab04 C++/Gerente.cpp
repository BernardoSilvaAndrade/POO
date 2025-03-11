#include "Gerente.hpp"

using namespace std;

Gerente::Gerente(const string &nome, int salario_base, int numero_de_equipes)
    : Funcionario(nome, salario_base), numero_de_equipes(numero_de_equipes) {}

int Gerente::getNumero_de_equipes()
{
    return numero_de_equipes;
};

int Gerente::bonus() const
{
    return numero_de_equipes * 500;
}