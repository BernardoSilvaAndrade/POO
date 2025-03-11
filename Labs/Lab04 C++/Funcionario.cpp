#include "Funcionario.hpp"
#include <string>

using namespace std;

Funcionario::Funcionario(const string &nome, int salario_base)
    : nome(nome), salario_base(salario_base) {}

string Funcionario::descricao()
{
    return "Funcionário: " + nome + ", Salário base: " + to_string(salario_base);
}

string Funcionario::getNome() const
{
    return nome;
}

int Funcionario::getSalario_base()
{
    return salario_base;
}