#include "TechLead.hpp"

using namespace std;

TechLead::TechLead(const string &nome, int salario_base, int numero_equipes, const string &linguagem_principal, int projetos_em_andamento)
    : Funcionario(nome, salario_base),
      Gerente(nome,salario_base,numero_de_equipes),
      Desenvolvedor(nome,salario_base,linguagem_principal),
      projetos_em_andamento(projetos_em_andamento) {}

int TechLead::getProjetosEmAndamento()
{
    return projetos_em_andamento;
}

string TechLead::descricao() 
{
    return Funcionario::descricao() + ", Número de equipes: " + to_string(getNumero_de_equipes()) +
           ", Bônus: " + to_string(bonus()) + ", Linguagem principal: " + getLinguagemPrincipal() +
           ", Projetos em andamento: " + to_string(projetos_em_andamento);
}