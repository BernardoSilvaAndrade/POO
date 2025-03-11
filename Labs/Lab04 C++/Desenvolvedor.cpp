#include "Desenvolvedor.hpp"

using namespace std;

Desenvolvedor::Desenvolvedor(const string &nome, int salario_base, const std::string &linguagem_principal)
    : Funcionario(nome, salario_base), linguagem_principal(linguagem_principal) {}

string Desenvolvedor::getLinguagemPrincipal() const
{
    return linguagem_principal;
}

string Desenvolvedor::projetos_realizados() const
{
    return "Projetos realizados na linguagem:" + linguagem_principal;
}